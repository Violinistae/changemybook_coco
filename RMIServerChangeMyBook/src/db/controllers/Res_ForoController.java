/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.controllers;

import db.DBmanage;
import db.models.Foro;
import db.models.Res_Foro;
import db.models.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import rmiserverbook.*;

/**
 *
 * @author Emiliano
 */
public class Res_ForoController extends UnicastRemoteObject implements Res_ForoInterface {
    public Res_ForoController () throws RemoteException {
        super();
    }
    
    private Connection createCon () {
        DBmanage db = new DBmanage();
        Connection con = db.getCon();
        return con;
    }

    @Override
    public ArrayList<Res_Foro> readRes_Foro() {
        PreparedStatement sqlStmnt;
        
        ArrayList<Res_Foro> allResSms = new ArrayList();
        Res_Foro sms;
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            sqlStmnt = con.prepareStatement("Select * from foro order by Id_Mens desc");
            rs = sqlStmnt.executeQuery();
            
            while(rs.next()) {
                sms = new Res_Foro();
                sms.setId_RF(rs.getInt("Id_RF"));
                sms.setRespuestaM(rs.getString("RespuestaM"));                                
                
                int Id_Remitente = rs.getInt("Remitente");                
                try {
                    UsuarioController checkRemitente = new UsuarioController();
                    Usuario remitente = checkRemitente.readUsuarioById(Id_Remitente);
                    sms.setRemitente(remitente);                    
                } catch (RemoteException ex) {
                    //Favor de verificar cuando la longitud de este Array es de 0
                    //significa que hubo un error
                    System.out.println(ex);
                    ArrayList<Res_Foro> rf = new ArrayList();
                    return rf;
                }
                
                sms.setFecha(rs.getDate("Fecha"));
                
                int Id_Mensaje = rs.getInt("Mensaje");                
                try {
                    ForoController checkForoSms = new ForoController();
                    Foro smsForo = checkForoSms.readForoById(Id_Mensaje);
                    sms.setMensaje(smsForo);
                } catch (RemoteException ex) {
                    //Favor de verificar cuando la longitud de este Array es de 0
                    //significa que hubo un error
                    System.out.println(ex);
                    ArrayList<Res_Foro> rf = new ArrayList();
                    return rf;
                }  
                                             
                allResSms.add(sms);
            }
            return allResSms;
        } catch (SQLException ex) {
            //Favor de verificar cuando la longitud de este Array es de 0
            //significa que hubo un error
            System.out.println(ex);
            ArrayList<Res_Foro> rf = new ArrayList();
            return rf;
        }
    }

    @Override
    public Res_Foro readRes_ForoById(int Id_RF) {
        PreparedStatement stmt;                
        Res_Foro sms;
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement("Select * from res_foro where Id_RF = ?");
            stmt.setInt(1, Id_RF);
            rs = stmt.executeQuery(); rs.next();
            sms = new Res_Foro();
            sms.setId_RF(rs.getInt("Id_RF"));
            sms.setRespuestaM(rs.getString("RespuestaM"));                                

            int Id_Remitente = rs.getInt("Remitente");                
            try {
                UsuarioController checkRemitente = new UsuarioController();
                Usuario remitente = checkRemitente.readUsuarioById(Id_Remitente);
                sms.setRemitente(remitente);                    
            } catch (RemoteException ex) {
                //Favor de verificar cuando la longitud de este Array es de 0
                //significa que hubo un error
                System.out.println(ex);
                return null;
            }

            sms.setFecha(rs.getDate("Fecha"));

            int Id_Mensaje = rs.getInt("Mensaje");                
            try {
                ForoController checkForoSms = new ForoController();
                Foro smsForo = checkForoSms.readForoById(Id_Mensaje);
                sms.setMensaje(smsForo);
            } catch (RemoteException ex) {
                //Favor de verificar cuando la longitud de este Array es de 0
                //significa que hubo un error
                System.out.println(ex);
                return null;
            }
            
            return sms;
        } catch (SQLException ex) {
            //Favor de verificar cuando la longitud de este Array es de 0
            //significa que hubo un error
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public int createRes_ForoSms(String Res, int Remitente, Date Fecha, int ForoSms) throws RemoteException {
        //Verificar si existe remitente? y mensaje?
        PreparedStatement stmt;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement(
                "Insert into foro (RespuestaM, Remitente, Fecha, Mensaje)"
                        + "values (?, ?, ?, ?)"
            );                                  
            
            stmt.setString(1, Res);
            stmt.setInt(2, Remitente);
            stmt.setDate(3, Fecha);
            stmt.setInt(4, ForoSms);
            stmt.executeUpdate();
            return 1;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        }
    }
        
}
