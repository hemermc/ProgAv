/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Oscar
 */
public class Operario implements Runnable {
    
    private BufferedWriter log;
    private Gasolinera gasolinera;
    private String aux;
    
    public Operario (Gasolinera gas, BufferedWriter log)
    {
        this.log = log;
        gasolinera = gas;
    }
    
    public void run()
    {
        try
        {
            long threadId = Thread.currentThread().getId();
            threadId = threadId % 3;
            Thread.sleep((int)(400 + (400*Math.random())));
            
            synchronized(this){
                aux = "Operario " + threadId + " atiende a vehículo.\n";
                log.write(aux);
            }
            
            System.out.println("Operario " + threadId + " atiende a vehículo.");
            gasolinera.atendido(log);
            
        }catch (InterruptedException|IOException e) {}
    }
}
