/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmiserverbook.PublicacionInterface;
import rmiserverbook.*;
import db.DBmanage;
import db.models.Foro;
import db.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Emiliano
 */
public class ForoController extends UnicastRemoteObject implements ForoInterface{
    public ForoController () throws RemoteException {
        super();
    }
    
    private Connection createCon () {
        DBmanage db = new DBmanage();
        Connection con = db.getCon();
        return con;
    }

    @Override
    public ArrayList<Foro> readForo() {
        PreparedStatement sqlStmnt;
        
        ArrayList<Foro> allSms = new ArrayList();
        Foro sms;
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            sqlStmnt = con.prepareStatement("Select * from foro order by Id_Mens desc");
            rs = sqlStmnt.executeQuery();
            
            while(rs.next()) {
                sms = new Foro();
                sms.setId_Mens(rs.getInt("Id_Mens"));
                sms.setMensaje(rs.getString("Mensaje"));                                
                
                int Id_Remitente = rs.getInt("Remitente");                
                try {
                    UsuarioController checkRemitente = new UsuarioController();
                    Usuario remitente = checkRemitente.readUsuarioById(Id_Remitente);
                    sms.setRemitente(remitente);                    
                } catch (RemoteException ex) {
                    //Favor de verificar cuando la longitud de este Array es de 0
                    //significa que hubo un error
                    System.out.println(ex);
                    ArrayList<Foro> f = new ArrayList();
                    return f;
                }                                
                              
                sms.setFecha(rs.getDate("Fecha"));
                allSms.add(sms);
            }
            return allSms;
        } catch (SQLException ex) {
            //Favor de verificar cuando la longitud de este Array es de 0
            //significa que hubo un error
            System.out.println(ex);
            ArrayList<Foro> f = new ArrayList();
            return f;
        }
    }

    @Override
    public Foro readForoById(int Id_Mens) {
        PreparedStatement stmt;
        Foro sms = new Foro();
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement("Select * from foro where Id_Mens = ?");
            stmt.setInt(1, Id_Mens);
            rs = stmt.executeQuery(); rs.next();
            sms.setId_Mens(rs.getInt("Id_Mens"));
            sms.setMensaje(rs.getString("Mensaje"));                                
                
            int Id_Remitente = rs.getInt("Remitente");                
            try {
                UsuarioController checkRemitente = new UsuarioController();
                Usuario remitente = checkRemitente.readUsuarioById(Id_Remitente);
                sms.setRemitente(remitente);                    
            } catch (RemoteException ex) {               
                System.out.println(ex);
                return null;
            }                                

            sms.setFecha(rs.getDate("Fecha"));            
            return sms;
        } catch (SQLException ex) {
            System.out.println(ex);        
            return null;
        }
    }

    @Override
    public int createForoSms(String Mensaje, int Remitente, Date Fecha) {        
        //Verificar si existe remitente?
        PreparedStatement stmt;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement(
                "Insert into foro (Mensaje, Remitente, Fecha)"
                        + "values (?, ?, ?)"
            );                                  
            
            stmt.setString(1, Mensaje);
            stmt.setInt(2, Remitente);
            stmt.setDate(3, Fecha);         
            stmt.executeUpdate();
            return 1;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        }  
    }
    
    
    
}
