/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserverbook;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import db.models.*;
import java.util.Date;

/**
 *
 * @author Emiliano
 */
public interface CompraInterface extends Remote{
    
    public ArrayList<Compra> readCompra() throws RemoteException;
    public Compra readCompraById(int Id_Compra) throws RemoteException;
    public int createCompra(int Comprador, int Publicacion, Date Fecha) throws RemoteException;
    public int removeCompra(int Id_Compra) throws RemoteException;
    public Compra readCompraByPublicacion(int Id_Pub) throws RemoteException;
    
}
