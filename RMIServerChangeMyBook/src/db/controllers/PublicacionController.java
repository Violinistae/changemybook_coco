/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.controllers;

import db.DBmanage;
import db.models.Publicacion;
import db.models.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import rmiserverbook.*;

/**
 *
 * @author Emiliano
 */
public class PublicacionController extends UnicastRemoteObject implements PublicacionInterface {
    public PublicacionController () throws RemoteException{
        super();
    }
    
    private Connection createCon () {
        DBmanage db = new DBmanage();
        Connection con = db.getCon();
        return con;
    }
    
    @Override
    public ArrayList<Publicacion> readPublicaciones(){
        PreparedStatement sqlStmnt;
        
        ArrayList<Publicacion> publishedAll = new ArrayList();
        Publicacion published;
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            sqlStmnt = con.prepareStatement("Select * from publicacion order by Id_Pub desc");
            rs = sqlStmnt.executeQuery();
            
            while(rs.next()) {
                published = new Publicacion();
                published.setId_Pub(rs.getInt("Id_Pub"));
                published.setTexto(rs.getString("Texto"));                                
                
                int Id_Publicador = rs.getInt("Publicador");
                
                try {
                    UsuarioController checkPublicador = new UsuarioController();
                    Usuario publicador = checkPublicador.readUsuarioById(Id_Publicador);
                    published.setPublicador(publicador);
                    
                } catch (RemoteException ex) {
                    //Favor de verificar cuando la longitud de este Array es de 0
                    //significa que hubo un error
                    System.out.println(ex);
                    ArrayList<Publicacion> p = new ArrayList();
                    return p;
                }                                
                                                                     
                published.setFoto(rs.getString("Foto"));
                published.setEstadoP(rs.getInt("EstadoP"));
                publishedAll.add(published);
            }
            return publishedAll;
        } catch (SQLException ex) {
            //Favor de verificar cuando la longitud de este Array es de 0
            //significa que hubo un error
            System.out.println(ex);
            ArrayList<Publicacion> p = new ArrayList();
            return p;
        }
    }
    
}
