/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

/**
 *
 * @author alexandermunguiaclemente
 */
public class Vehiculo extends Thread {
    
    private String identificador;
    private Gasolinera gas;
    
    public Vehiculo (String identificador, Gasolinera gas) 
    {
        this.identificador = "Vehiculo"+identificador;
        this.gas = gas;
    }
    
    public void run()
    {
        try {
            sleep((int)(500 + (100 * Math.random())));
            System.out.println(identificador + " espera para entrar a surtidor.");
            gas.repostando(identificador);
        }catch (InterruptedException e) {}
    }  
}
