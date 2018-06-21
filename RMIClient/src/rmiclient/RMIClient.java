/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import com.sun.istack.internal.logging.Logger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import rmi_server.Fraccion;
import rmi_server.Operaciones;
import rmi_server.OperacionesImp;
import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;


/**
 *
 * @author Emiliano
 */
public class RMIClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            Operaciones op;            
            op = (Operaciones)Naming.lookup("rmi://192.168.84.15/Operacion");
            
            Fraccion frac1 = new Fraccion (3, 4);
            Fraccion frac2 = new Fraccion (5, 6);
            
            Fraccion res;
            
            res = op.suma(frac1, frac2);         
            System.out.println(res.getNum()+ "/" + res.getDen());
            
            res = op.resta(frac1, frac2);
            System.out.println(res.getNum()+ "/" + res.getDen());
            
            res = op.multiplicacion(frac1, frac2);
            System.out.println(res.getNum()+ "/" + res.getDen());
            
            res = op.division(frac1, frac2);
            System.out.println(res.getNum()+ "/" + res.getDen());
            
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            //Logger.getLogger(RMIClient.class).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            System.out.println("No pues valio madres");
        }       
        
    }
    
}
