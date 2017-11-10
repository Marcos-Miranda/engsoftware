package ControlReservas;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

//Classe para fazer a comunicação diretamente com o SGBD.

public class Bd{
    static Connection connection = null;
    static ResultSet result      = null;
    static Statement statement   = null;


    //Dados do SGBD
    static String  usuario = "postgres";
    static String  senha  = "5670";
    static String url = "jdbc:postgresql://localhost:5432/postgres"; // nome da fonte de dados
	
    //Método para criar a conexão com SGBD
    public static void getConect(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,usuario,senha);
            statement = connection.createStatement();
        }
        catch(ClassNotFoundException | SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema ao conectar-se no banco de dados, contate o administrador do sistema");
        }
    }

    //Método para a execução de uma consulta para verificar se o login informado consta no banco de dados
    public static int consultaId(String sql,int id){
        ResultSet result = null;
        try{
            getConect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            result = st.executeQuery();
        }	
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        try{
            if(result.next()){
                return result.getInt("Status");
            }
        }
        catch(SQLException errSql){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        close();
        return 0;
    }
        
    //Método para a execução de uma consulta para comparar a senha informada com a registrada no banco de dados
    public static String consultaSenha(String sql,int login){
        ResultSet result = null;
        try{
            getConect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,login);
            result = st.executeQuery();
        }	
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        try{
            if(result.next()){
                return result.getString("Senha");
            }
        }
        catch(SQLException errSql){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        close();
        return "0";
    }
    
    //Método para a execução de uma consulta para retornar as salas disponíveis na data selecionada
    public static List<Sala> retornaSalas(Date data,String horario) throws ParseException{
        ResultSet result = null;
        List<Sala> lista = new ArrayList(); 
        String sql = "select idsala,categoria from sala where idsala not in(select r.idsala from reserva r natural join sala where r.data = ? and r.idhorario = ?)order by categoria";
        try{
            java.sql.Date d = new java.sql.Date(data.getTime());
            getConect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1,d);
            st.setString(2,horario);
            result = st.executeQuery();
        }	
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        try{
            while(result.next()){
                Sala sala = new Sala();
                sala.setIdSala(result.getString("idsala"));
                sala.setCategoria(result.getString("categoria"));
                lista.add(sala);
                
            }
        }
        catch(SQLException errSql){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        close();
        return lista;
    }
    
    //Método para fazer uma reserva 
    public static void efetuarReserva(String sql,int login,String mot,String hor,Date data,String sala){
        
        try{
            getConect();
            java.sql.Date d = new java.sql.Date(data.getTime());
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,sala);
            st.setInt(2,login);
            st.setDate(3,d);
            st.setString(4,mot);
            st.setString(5,hor);
            st.execute();
            
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");            
        }
        close();
    }
    
    //Método para verificar se o aluno já possui uma reserva na data e horário
    public static int verificaAluno(int login,String horario,Date data){
        ResultSet result = null;
        String sql = "select count(RA) as status from reserva where ra=? and idhorario=? and data=?";
        try{
            getConect();
            java.sql.Date d = new java.sql.Date(data.getTime());            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,login);
            st.setString(2,horario);
            st.setDate(3,d);
            result = st.executeQuery();
        }	
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        try{
            if(result.next()){
                return result.getInt("Status");
            }
        }
        catch(SQLException errSql){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        close();
        return 0;
        
    }
    
    //Método para a execução de uma consulta para retornar as reservas do usuário
    public static List<Reserva> retornaReservas(String sql,int login){
        ResultSet result = null;
        List<Reserva> lista = new ArrayList(); 
        try{
            getConect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,login);
            result = st.executeQuery();
        }	
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        try{
            while(result.next()){
                Reserva reserva = new Reserva();
                reserva.setSala(result.getString("idsala"));
                reserva.setHorario(result.getString("idhorario"));
                reserva.setData(result.getDate("data"));
                lista.add(reserva);
                
            }
        }
        catch(SQLException errSql){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");
        }
        
        close();
        return lista;
    }
    
    //Método para excluir uma reserva 
    public static void excluirReserva(String hor,Date data,String sala){
        String sql = "delete from reserva where idhorario=? and idsala=? and data=?";
        try{
            getConect();
            java.sql.Date d = new java.sql.Date(data.getTime());
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,hor);
            st.setString(2,sala);
            st.setDate(3,d);
            st.execute();
            
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema em uma execução sobre o banco de dados, contate o administrador do sistema");            
        }
        close();
    }

	
    //Método para encerrar a conexão
    public static void close(){
        try{
            if(!connection.isClosed()) connection.close();
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema ao desconectar-se do banco de dados, contate o administrador do sistema");
        }
    }

}

