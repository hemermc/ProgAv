/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alexandermunguiaclemente
 */
public class Vehiculo extends Thread {
    
    private BufferedWriter log;
    private String identificador;
    private Gasolinera gas;
    private String aux;
    private Paso paso;
    
    public Vehiculo (String identificador, Gasolinera gas, BufferedWriter log, Paso paso) 
    {
        this.identificador = "Vehiculo"+identificador;
        this.gas = gas;
        this.log = log;
        this.paso = paso;
    }
    
    public void run()
    {
        try {
            sleep((int)(500 + (5500 * Math.random())));
            paso.mirar();
            synchronized(this){
                aux = identificador + " espera para entrar a surtidor." + "\n";
                log.write(aux);
            }
            
            System.out.println(identificador + " espera para entrar a surtidor.");
            gas.repostando(identificador, log);
        }catch (InterruptedException|IOException e) {}
    }  
}
