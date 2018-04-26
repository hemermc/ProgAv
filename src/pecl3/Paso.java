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
public class Paso {
    
    private boolean cerrado=false;

    public synchronized void mirar(){
        while(cerrado){
            try{wait();} catch(InterruptedException ie){}
        }
    }
    public synchronized void abrir(){
        cerrado=false;
        notifyAll();
    }
    public synchronized void cerrar(){
        cerrado=true;
    }
    
    public synchronized boolean getPaso(){
        return cerrado;
    }
}