/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.rmi.*;
/**
 *
 * @author juanc
 */
public interface Operaciones extends Remote {
    
    public Fraccion suma(Fraccion a, Fraccion b) throws RemoteException;
    public Fraccion resta(Fraccion a, Fraccion b) throws RemoteException;
    public Fraccion multiplicacion(Fraccion a, Fraccion b) throws RemoteException;
    public Fraccion division(Fraccion a, Fraccion b) throws RemoteException;
    
}
