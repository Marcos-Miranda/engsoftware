package ControlReservas;

import java.sql.SQLException;
import javax.swing.JOptionPane;

//Classe para fazer intermédio entre a interface e o banco de dados.


public class Controle {
    
    //Método para autenticação do aluno
    public static void autenticarAluno(String login,String senha) throws SQLException{
        try{
            int s = Integer.parseInt(login);
            if(Bd.consultaId("Select count(RA) as Status from Aluno where RA = ?", s)==1){
                if(Bd.consultaSenha("Select Senha from Aluno where RA = ?", s).equals(senha)){
                    JOptionPane.showMessageDialog(null,"Aluno autenticado");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Senha inválida");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"RA informado não consta na base de dados");
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"RA inválido, o valor deve ser um número inteiro");
        }
    }
    
    //Método para autenticação do professor
    public static void autenticarProfessor(String login,String senha) throws SQLException{
        try{
            int s = Integer.parseInt(login);
            if(Bd.consultaId("Select count(IdProfessor) as Status from Professor where IdProfessor = ?",s)==1){
                if(Bd.consultaSenha("Select Senha from Professor where IdProfessor = ?",s).equals(senha)){
                    JOptionPane.showMessageDialog(null,"Professor autenticado");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Senha inválida");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"RA informado não consta na base de dados");
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"RA inválido, o valor deve ser um número inteiro");
        }
    }
    
}
