/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserverbook;
import db.models.Foro;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Emiliano
 */
public interface ForoInterface extends Remote{
    public ArrayList<Foro> readForo() throws RemoteException;
    public Foro readForoById (int Id_Mens) throws RemoteException;
    public int createForoSms (String Mensaje, int Remitente, Date Fecha
        ) throws RemoteException;
}
