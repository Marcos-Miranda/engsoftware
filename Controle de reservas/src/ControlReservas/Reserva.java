/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlReservas;

import java.util.Date;

/**
 *
 * @author marki
 */
public class Reserva {
    private String horario;
    private String sala;
    private Date data =  new Date();
    
    public void setHorario(String hor){
        horario=hor;
    }
    
    public void setSala(String s){
        sala=s;
    }
    
    public void setData(Date d){
        data=d;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public String getSala(){
        return sala;
    }
    
    public Date getData(){
        return data;
    }
    
}
