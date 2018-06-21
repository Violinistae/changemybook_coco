/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class RMI_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
            String name = "Operacion";
            LocateRegistry.createRegistry(1099);
            OperacionesImp stub = new OperacionesImp();
            Naming.bind(name, stub);
            System.out.println("Hola");
        } catch (RemoteException | AlreadyBoundException | MalformedURLException ex) {
            Logger.getLogger(RMI_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
