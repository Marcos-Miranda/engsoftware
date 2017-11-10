package ControlReservas;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

//Classe para fazer intermédio entre a interface e o banco de dados.


public class Controle {
    
    //Método para autenticação do aluno
    public static String autenticarAluno(String login,String senha) throws SQLException{
        String saida;
        try{
            int s = Integer.parseInt(login);
            if(s>=1){
                if(senha.length() >= 3 && senha.length() <= 20 ){
                    if(Bd.consultaId("Select count(RA) as Status from Aluno where RA = ?", s)==1){
                        if(Bd.consultaSenha("Select Senha from Aluno where RA = ?", s).equals(senha)){
                            saida = "Aluno autenticado";
                            Reservas r = new Reservas();
                            r.setLogin(s);
                            r.setCargo(0);//aluno
                            r.getRtm().addListaDeReservas(reservasAluno(s));
                            r.setVisible(true);
                        }
                        else{
                            saida = "Senha inválida";
                        }
                    }
                    else{
                        saida = "RA informado não consta na base de dados";
                    }
                }
                else{
                    saida = "Senha deve ter entre 3 e 20 caracteres";
                }
            }
            else{
                saida = "RA inválido, o valor deve ser maior ou igual a 1";
            }
        }
        catch(NumberFormatException e){
            saida = "RA inválido, o valor deve ser um número inteiro";
        }
        JOptionPane.showMessageDialog(null,saida);
        return saida;
        
    }
    
    //Método para autenticação do professor
    public static String autenticarProfessor(String login,String senha) throws SQLException{
        String saida;
        try{
            int s = Integer.parseInt(login);
            if(s>=1){
                if(senha.length() >= 3 && senha.length() <= 20 ){
                    if(Bd.consultaId("Select count(IdProfessor) as Status from Professor where IdProfessor = ?",s)==1){
                        if(Bd.consultaSenha("Select Senha from Professor where IdProfessor = ?",s).equals(senha)){
                            saida = "Professor autenticado";
                            Reservas r = new Reservas();
                            r.setLogin(s);
                            r.setCargo(1);//professor
                            r.getRtm().addListaDeReservas(reservasProfessor(s));
                            r.setVisible(true);
                        }
                        else{
                            saida = "Senha inválida";
                        }
                    }
                    else{
                        saida = "RA informado não consta na base de dados";
                    }
                }
                else{
                    saida = "Senha deve ter entre 3 e 20 caracteres";
                }
            }
            else{
                saida = "RA inválido, o valor deve ser maior ou igual a 1";
            }
        }
        catch(NumberFormatException e){
            saida = "RA inválido, o valor deve ser um número inteiro";
        }
        JOptionPane.showMessageDialog(null,saida);
        return saida;
    }
    
    //Método para validar data de reserva
    public static int validaData(Date data){
        Calendar c =  new GregorianCalendar();
        Date atual = new Date();
        Calendar hoje =  new GregorianCalendar();
        hoje.setTime(atual);
        c.setTime(data);
        if(hoje.compareTo(c)==0 || hoje.compareTo(c)==1){
            return -1; //data de reserva deve ser pelo menos 1 dia posterior a data de hoje
        }
        if(c.get(c.DAY_OF_WEEK)==Calendar.SATURDAY || c.get(c.DAY_OF_WEEK)==Calendar.SUNDAY){
            return 1;//reservas nos sábados e domingos são inválidas
        }
        return 0; //data válida
    }
    
    
    //Método que chama efetuarReserva para um aluno
    public static String reservaAluno(int login,Date data,String horario,String sala,String motivacao){
        String sql = "insert into Reserva values(?,?,null,?,?,?)";
        if(Bd.verificaAluno(login, horario, data)<=0){
            Bd.efetuarReserva(sql, login, motivacao, horario, data, sala);
            return "Reserva efetuada com sucesso";
        }
        else{
            return "Um aluno não pode fazer mais de uma reserva no mesmo horário";
        }
    }
    
    //Método que chama efetuarReserva para um professor
    public static String reservaProfessor(int login,Date data,String horario,String sala,String motivacao){
        String sql = "insert into Reserva values(?,null,?,?,?,?)";
        Bd.efetuarReserva(sql, login, motivacao, horario, data, sala);
        return "Reserva efetuada com sucesso";
    }
    
    //Método para retornar reservas de um aluno
    public static List<Reserva> reservasAluno(int login){
        String sql= "select idsala,idhorario,data from reserva where data>=current_date and ra=?";
        List<Reserva> l = new ArrayList();
        l=Bd.retornaReservas(sql, login);
        return l;
    }
    
    //Método para retornar reservas de um professor
    public static List<Reserva> reservasProfessor(int login){
        String sql= "select idsala,idhorario,data from reserva where data>=current_date and idprofessor=?";
        List<Reserva> l = new ArrayList();
        l=Bd.retornaReservas(sql, login);
        return l;
    }
    
}
