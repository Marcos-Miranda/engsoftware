package ControlReservas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
    //método para criar a conexão com SGBD
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


	//metodo para a execucao de uma inserção
	/*public static void inSQL(String sql){
		boolean boolIns = false;
		try{
			getConect();
			boolIns = statement.execute(sql);
		}
		catch(SQLException erro){
			System.out.println("\n\nErro de SQL BDConecta "+erro+"! -- de SQL em BDConecta");
		}
		close();
	}*/


	//metodo para a execucao de uma atualização
	/*public static void updSQL(String sql){
		int intUpd = 0;
		try{
			getConect();
			intUpd = statement.executeUpdate(sql);
		}
		catch(SQLException erro){
			System.out.println("Erro ao Atualizar! "+erro);
		}
		close();
	}*/
        


    //método para a execução de uma consulta para verificar se o login informado consta no banco de dados
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
        
    //método para a execução de uma consulta para comparar a senha informada com a registrada no banco de dados
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


	
    //método para encerrar a conexão
    public static void close(){
        try{
            if(!connection.isClosed()) connection.close();
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Problema ao desconectar-se do banco de dados, contate o administrador do sistema");
        }
    }

}

