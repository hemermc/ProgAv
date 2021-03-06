/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JTextField;
import pecl3cliente.InterfaceGasolinera;

/**
 *
 * @author alexandermunguiaclemente
 */
public class Gasolinera extends UnicastRemoteObject implements InterfaceGasolinera {
    
    private ArrayList <Surtidor> surtidores;
    private int numVehiclos = 0;
    private String buffer[];
    private String vehiculos = "";
    private Lock cerrojo = new ReentrantLock();
    private Condition full = cerrojo.newCondition();
    private Condition empty = cerrojo.newCondition();
    private int in = 0, out = 0, numElem = 0, max = 8;
    private HashMap<String,String> vehiculosCola = new HashMap<String,String>();
    private String aux;
    
    public Gasolinera(HashMap <Integer,JTextField> texto, HashMap <Integer,JTextField> texto2) throws RemoteException {
        
        surtidores = new ArrayList<>(); 
        for(int i = 0; i < 8; i++){
            Surtidor s = new Surtidor(i,texto.get(i),texto2.get(i));
            surtidores.add(s);
        }    
    }
    
    public void repostando(String id, BufferedWriter log) throws InterruptedException {
        try
        {
            cerrojo.lock();
            
            while (numElem == max) {
                if(!vehiculosCola.containsKey(id)){
                    vehiculosCola.put(id,id);
                    vehiculos = vehiculos + " " + id;
                }
                full.await();
            }
            vehiculos = vehiculos + " " + id;
            surtidores.get(in).entrarEnSurtidor(id);
            in = (in + 1)%max;
            aux = id + " entra en el surtidor número " + in + ".\n"; 
            log.write(aux);

            System.out.println(id + " entra en el surtidor número " + in + ".");
            numElem ++;
            empty.signal();
        
        } catch (IOException e) {
        } finally {
            cerrojo.unlock();
        } 
    }
    
    public void opAtendiendo(String ide) throws InterruptedException{
      try 
        {
            cerrojo.lock();
            while (numElem == 0) {
                empty.await();
            }
         
            
        }finally{
          cerrojo.unlock();
      }
    }
<<<<<<< HEAD
    
    public void atendido(BufferedWriter log) throws InterruptedException {
=======
    public void atendido(BufferedWriter log, String ide) throws InterruptedException {
>>>>>>> 7888ffd44994ff5f0c58a4012a98deb850f9492e
        try 
        {
            cerrojo.lock();
            while (numElem == 0) {
                empty.await();
            }
           
            surtidores.get(out).operando(ide);
            String idVehiculo = surtidores.get(out).salirSurtidor();
            vehiculos = vehiculos.replace(idVehiculo + " ", "");
            vehiculos = vehiculos.trim();
            aux = idVehiculo + " sale del surtidor\n" + (out+1);
            log.write(aux);

            System.out.println(idVehiculo + " sale del surtidor." + (out+1));
            numElem --;
            out = (out + 1)%max;
            full.signal();

        } catch (IOException e) {    
        } finally {
            cerrojo.unlock();
        }
    }
    
    public String imprimir() throws InterruptedException {
        try{
            cerrojo.lock();
            return vehiculos;
        }finally {
            cerrojo.unlock();
        }

    }
    
    public String colaVehiculos() throws RemoteException {
        return "oo";
    }

   
    public String Surtidor() throws RemoteException {
        return "gg";
    }
}
