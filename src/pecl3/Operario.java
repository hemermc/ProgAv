/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import static java.lang.Thread.sleep;
>>>>>>> 7888ffd44994ff5f0c58a4012a98deb850f9492e

/**
 *
 * @author Oscar
 */
public class Operario implements Runnable {
    
    private BufferedWriter log;
    private Gasolinera gasolinera;
    private String aux;
    private Paso paso;
    
    public Operario (Gasolinera gas, BufferedWriter log, Paso paso){
        this.log = log;
        gasolinera = gas;
        this.paso = paso;
    }
    
    public void run()
    {
        paso.mirar();
        try
        {
            long threadId = Thread.currentThread().getId();
            threadId = (threadId % 3)+1;
            
            
            synchronized(this){
                aux = "Operario " + threadId + " atiende a vehículo.\n";
                log.write(aux);
            }
           // atendiendo...
            //gasolinera.opAtendiendo("Operario"+String.valueOf(threadId));
            Thread.sleep((int)(4000 + (4000*Math.random())));
            System.out.println("Operario " + threadId + " atiende a vehículo.");
<<<<<<< HEAD
            
            gasolinera.atendido(log);
=======
            gasolinera.atendido(log, "Operario" + String.valueOf(threadId));
>>>>>>> 7888ffd44994ff5f0c58a4012a98deb850f9492e
            
        }catch (InterruptedException e) {} catch (IOException ex) {
            Logger.getLogger(Operario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
