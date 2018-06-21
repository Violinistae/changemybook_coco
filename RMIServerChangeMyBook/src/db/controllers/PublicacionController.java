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
                              
                published.setPrecio(rs.getInt("Precio"));
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
    
    @Override
    public Publicacion readPublicacionById (int Id_Pub) {
        PreparedStatement stmt;
        Publicacion publicacion = new Publicacion();
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement("Select * from publicacion where Id_Pub = ?");
            stmt.setInt(1, Id_Pub);
            rs = stmt.executeQuery(); rs.next();
            publicacion.setId_Pub(rs.getInt("Id_Pub"));
            publicacion.setTexto(rs.getString("Texto")); 
            publicacion.setPrecio(rs.getInt("Precio"));
            publicacion.setFoto(rs.getString("Foto"));
            publicacion.setEstadoP(rs.getInt("EstadoP"));
            
            int Id_Publicador = rs.getInt("Publicador");
                
                try {
                    UsuarioController checkPublicador = new UsuarioController();
                    Usuario publicador = checkPublicador.readUsuarioById(Id_Publicador);
                    publicacion.setPublicador(publicador);
                    
                } catch (RemoteException ex) {                    
                    System.out.println(ex);
                    ArrayList<Publicacion> p = new ArrayList();
                    return null; 
               }                         
             
            return publicacion;
        } catch (SQLException ex) {
            System.out.println(ex);        
            return null;
        }        
    }
    
    @Override
    public int createPublicacion (String texto, int Id_Publicador, int precio,
            String Foto){
         
        //verificar si existe Publicador?               
        PreparedStatement stmt;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement(
                "Insert into publicacion (Texto, Publicador, Precio, Foto, EstadoP)"
                        + "values (?, ?, ?, ?, ?)"
            );                                  
            
            stmt.setString(1, texto);
            stmt.setInt(2, Id_Publicador);
            stmt.setInt(3, precio);
            stmt.setString(4, Foto);
            stmt.setInt(5, 0);
            stmt.executeUpdate();
            return 1;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        }        
    }
    
    @Override
    public int updatePublicacion (int Id_Pub, String texto, int Id_Publicador, int precio,
            String Foto, int EstadoP){
                
        PreparedStatement stmt;
        
        try {   
            Connection con = this.createCon();
            stmt = con.prepareStatement(
                "Update publicacion set Texto = ?, Publicador = ?, Precio = ?, Foto = ?,"
                        + "EstadoP = ? where Id_Pub = ?"
            );                        
            
            stmt.setString(1, texto);
            stmt.setInt(2, Id_Publicador);
            stmt.setInt(3, precio);
            stmt.setString(4, Foto);
            stmt.setInt(5, EstadoP);
            stmt.setInt(6, Id_Pub);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        }        
    }
}
