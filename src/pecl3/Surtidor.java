/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

import java.util.ArrayList;

/**
 *
 * @author alexandermunguiaclemente
 */
public class Surtidor {
    private int numSurtidor;
    private Boolean esperando = false;
    private String atendiendo;
    
    public Surtidor(int identificador) {
        this.numSurtidor = identificador;
    }
    
    //Introducimos a personas en el array de una planta
    public void entrarEnSurtidor(String vehiculo){
      esperando = true;
      atendiendo = vehiculo;   
    }
    
    //Devuelve la persona que sale de la planta
    public String salirSurtidor(){
        String vehiculo = atendiendo;
        atendiendo = "";
        esperando = false;
        return vehiculo;
    }
    
    public Boolean getEsperando(){
        return esperando;
    }
}
