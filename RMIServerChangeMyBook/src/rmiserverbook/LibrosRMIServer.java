/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserverbook;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import db.controllers.*;

/**
 *
 * @author Emiliano
 */
public class LibrosRMIServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {            
            String name = "Usuario";
            LocateRegistry.createRegistry(1099);
            
            UsuarioController userStub = new UsuarioController();
            Naming.bind(name, userStub);
            
            name = "Publicacion";
            PublicacionController pubStub = new PublicacionController();
            Naming.bind(name, pubStub);
            
            
            System.out.println("Hola");
                                               
        } catch (RemoteExceptioneException | AlreadyBoundException | MalformedURLException ex) {
            Logger.getLogger(LibrosRMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
