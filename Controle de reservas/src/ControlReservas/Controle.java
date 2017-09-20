package ControlReservas;

import java.sql.SQLException;
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
    
}
