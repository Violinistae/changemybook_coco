/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserverbook;

import db.models.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Emiliano
 */
public interface UsuarioInterface extends Remote{
    
    // ----------------------- Methods for the UsuarioController ---------------
    public ArrayList<Usuario> readUsuarios() throws RemoteException;
    public Usuario readUsuarioByUsername (String Username) throws RemoteException;
    public Usuario login(String username, String password) throws RemoteException;
    public int createUser (String Username, String Password, 
            int Creditos) throws RemoteException;
    public int updateUser (String Username, String newUsername, String Password,
        int Creditos) throws RemoteException;
    
}
