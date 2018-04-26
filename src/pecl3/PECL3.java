/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author alexandermunguiaclemente
 */
public class PECL3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService operarios = Executors.newFixedThreadPool(3);
        Gasolinera gas = new Gasolinera();    
        Operario op;
        Vehiculo veh;
        
        for(int i = 0; i < 200; i++)
        {
           veh = new Vehiculo("" + i, gas); 
           veh.start();
        }
        
        for(int i = 0; i < 200; i++)
        {
            op = new Operario(gas);
            operarios.execute(op);
       
        }
        operarios.shutdown();
     
    }
}
