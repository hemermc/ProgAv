/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

//Esto es una prueba de commit
//Alex cabrón
//Esto es otra prueba de commit
/// meee leeees jo puta sssssffssdd ssss pero que paaaasa

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author alexandermunguiaclemente
 */
public class Gasolinera {
    
    private ArrayList <Surtidor> surtidores;
    private int numVehiclos = 0;
    private String buffer[];
    private Lock cerrojo = new ReentrantLock();
    private Condition full = cerrojo.newCondition();
    private Condition empty = cerrojo.newCondition();
    private int in = 0, out = 0, numElem = 0, max = 7;
    private HashMap<String,String> vehiculosCola = new HashMap<String,String>();
    
    public Gasolinera() {
        
        surtidores = new ArrayList<>(); 
        for(int i = 0; i < 8; i++){
            Surtidor s = new Surtidor(i);
            surtidores.add(s);
        }    
    }
    
    public void repostando(String id) throws InterruptedException {
        try
        {
            cerrojo.lock();
            
            while (numElem == max) {
                vehiculosCola.put(id,id);
                full.await();
            }
            
            in = (in + 1)%max;
            surtidores.get(in).entrarEnSurtidor(id);
            System.out.println(id + " entra en el surtidor número " + in + ".");
            numElem ++;
            empty.signal();
    
        } finally {
            cerrojo.unlock();
        } 
    }
    
    public void atendido() throws InterruptedException {
        try 
        {
            cerrojo.lock();
            while (numElem == 0) {
                empty.await();
            }
           String idVehiculo = surtidores.get(out).salirSurtidor();
           System.out.println(idVehiculo + " sale del surtidor.");
           vehiculosCola.remove(idVehiculo);
           numElem --;
           out = (out + 1)%max;
           full.signal();
        
        } finally {
            cerrojo.unlock();
        }
    }
    
    public String imprimir(){
        String vehiculos = "";
        for(String valor :vehiculosCola.values()){
            vehiculos = vehiculos + " " + valor;
        }
        return vehiculos;
    }
}
