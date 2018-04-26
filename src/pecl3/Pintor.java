/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author alexandermunguiaclemente
 */
public class Pintor extends Thread{
    private JTextField jTextField1;
    private Gasolinera buzon;

    public Pintor(JTextField jTextField1, Gasolinera buzon) {
        this.jTextField1 = jTextField1;
        this.buzon = buzon;
    }
    
    public void run(){
        while(true){
            try {
                sleep((int)(400+400*Math.random()));
               
                    jTextField1.setText(buzon.imprimir()); 
            } catch (InterruptedException ex) {
                Logger.getLogger(Pintor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
}
