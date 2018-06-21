/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserverbook;

import db.models.Res_Foro;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Emiliano
 */
public interface Res_ForoInterface extends Remote{
    public ArrayList<Res_Foro> readRes_Foro() throws RemoteException;
    public Res_Foro readRes_ForoById (int Id_Mens) throws RemoteException;
    public int createRes_ForoSms (String Res, int Remitente, Date Fecha,
        int ForoSms) throws RemoteException;
}