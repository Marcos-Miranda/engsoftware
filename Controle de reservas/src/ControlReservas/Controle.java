/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlReservas;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marki
 */
public class Controle {
    
    /**
     *
     * @param login
     * @param Senha
     * @throws SQLException
     */
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
    
    public static void autenticarProfessor(String login,String senha) throws SQLException{
        if(Bd.consultaId("Select count(IdProfessor) as Status from Professor where IdProfessor = ?",Integer.parseInt(login))==1){
            if(Bd.consultaSenha("Select Senha from Professor where IdProfessor = ?",Integer.parseInt(login)).equals(senha)){
                JOptionPane.showMessageDialog(null,"Professor autenticado");
            }
            else{
                JOptionPane.showMessageDialog(null,"Senha inválida");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Login inválido");
        }
    }
    
}
