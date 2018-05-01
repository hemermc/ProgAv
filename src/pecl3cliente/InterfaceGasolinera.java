/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl3cliente;

import java.rmi.RemoteException;

/**
 *
 * @author alexandermunguiaclemente
 */
public interface InterfaceGasolinera {
    String colaVehiculos() throws RemoteException;
    String Surtidor() throws RemoteException;
}
