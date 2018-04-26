/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

/**
 *
 * @author Oscar
 */
public class Operario implements Runnable {
    
    private Gasolinera gasolinera;
    
    public Operario (Gasolinera gas)
    {

        gasolinera = gas;
    }
    
    public void run()
    {
        try
        {
            long threadId = Thread.currentThread().getId();
            Thread.sleep((int)(400 + (400*Math.random())));
            System.out.println("Operario" + threadId + "atiende a vehículo.");
            gasolinera.atendido();
        }catch (InterruptedException e) {}
    }
}
