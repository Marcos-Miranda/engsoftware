/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlReservas;

/**
 *
 * @author marki
 */
public class Sala {
    private String idSala;
    private String categoria;
    
    public void setIdSala(String id){
        idSala=id;
    }
    
    public void setCategoria(String cat){
        categoria=cat;
    }
    
    public String getIdSala(){
        return idSala;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
}
