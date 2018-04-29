/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author alexandermunguiaclemente
 */
public class Surtidor {
    private int numSurtidor;
    private Boolean esperando = false;
    private String atendiendo;
    private JTextField vehiculoField;
    
    public Surtidor(int identificador, JTextField v) {
        this.numSurtidor = identificador;
        this.vehiculoField = v;
    }
    //entra el vehiculo al surtidor
    public void entrarEnSurtidor(String vehiculo){
      esperando = true;
      atendiendo = vehiculo;  
      vehiculoField.setText(atendiendo);
    }
    
    //Devuelve el vehiculo que esta en el surtidor
    public String salirSurtidor(){
        String vehiculo = atendiendo;
        atendiendo = "";
        vehiculoField.setText(atendiendo);
        esperando = false;
        return vehiculo;
    }
    
    public Boolean getEsperando(){
        return esperando;
    }
}
