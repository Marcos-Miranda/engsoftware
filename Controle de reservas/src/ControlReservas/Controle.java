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
        if(Bd.consultaId("Select count(RA) as Status from Aluno where RA = ?",Integer.parseInt(login))==1){
            JOptionPane.showMessageDialog(null,"login válido");
        }
    }
    
}
