/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserverbook;
import db.models.Publicacion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Emiliano
 */
public interface PublicacionInterface extends Remote {
    public ArrayList<Publicacion> readPublicaciones() throws RemoteException;
    public Publicacion readPublicacionById (int Id_Pub) throws RemoteException;
    public int createPublicacion (String texto, int Id_Publicador, int precio,
            String Foto) throws RemoteException;    
    public int updatePublicacion (int Id_Pub, String texto, int Id_Publicador, int precio,
            String Foto, int EstadoP) throws RemoteException;
}
