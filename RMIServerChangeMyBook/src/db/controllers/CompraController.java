/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.controllers;
import db.DBmanage;
import db.models.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import rmiserverbook.CompraInterface;

/**
 *
 * @author Emiliano
 */
public class CompraController extends UnicastRemoteObject implements CompraInterface {
    
    public CompraController () throws RemoteException{
        super();
    }
    
    private Connection createCon () {
        DBmanage db = new DBmanage();
        Connection con = db.getCon();
        return con;
    }
    
    @Override
    public ArrayList<Compra> readCompra() {
        PreparedStatement sqlStmnt;
        
        ArrayList<Compra> listaCompras = new ArrayList();
        Compra compra;
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            sqlStmnt = con.prepareStatement("Select * from compra");
            rs = sqlStmnt.executeQuery();
            
            while(rs.next()) {
                compra = new Compra();
                compra.setId_Compra(rs.getInt("Id_Compra"));
                int id_comprador = rs.getInt("Comprador");
                int id_publicacion = rs.getInt("Publicacion");
                
                try {
                    UsuarioController checkComprador = new UsuarioController();
                    Usuario comprador = checkComprador.readUsuarioById(id_comprador);
                    compra.setComprador(comprador);
                    PublicacionController checkPublicacion = new PublicacionController();
                    Publicacion publicacion = checkPublicacion.readPublicacionById(id_publicacion);
                    compra.setPublicacion(publicacion);
                } catch (RemoteException ex) {
                    //Favor de verificar cuando la longitud de este Array es de 0
                    //significa que hubo un error
                    System.out.println(ex);
                    listaCompras = new ArrayList();
                    return listaCompras;
                }                                
                              
                compra.setDatetime(rs.getDate("Fecha"));
                listaCompras.add(compra);
            }
            return listaCompras;
        } catch (SQLException ex) {
            //Favor de verificar cuando la longitud de este Array es de 0
            //significa que hubo un error
            System.out.println(ex);
            listaCompras = new ArrayList<>();
            return listaCompras;
        }
    }
    
    @Override
    public Compra readCompraById(int Id_Compra) {
        PreparedStatement stmt;
        Compra compra = new Compra();
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement("Select * from compra where Id_Compra = ?");
            stmt.setInt(1, Id_Compra);
            rs = stmt.executeQuery(); rs.next();
            compra.setId_Compra(rs.getInt("Id_Mens"));                            
            int id_publicacion = rs.getInt("Publicacion");
            int id_comprador = rs.getInt("Comprador");               
            try {
                UsuarioController checkComprador = new UsuarioController();
                Usuario comprador = checkComprador.readUsuarioById(id_comprador);
                compra.setComprador(comprador);
                PublicacionController checkPublicacion = new PublicacionController();
                Publicacion publicacion = checkPublicacion.readPublicacionById(id_publicacion);
                compra.setPublicacion(publicacion);                    
            } catch (RemoteException ex) {               
                System.out.println(ex);
                return null;
            }                                

            compra.setDatetime(rs.getDate("Fecha"));            
            return compra;
        } catch (SQLException ex) {
            System.out.println(ex);        
            return null;
        }
    }
    
    @Override
    public int createCompra(int Comprador, int Publicacion, Date Fecha) {
        PreparedStatement stmt;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement(
                "Insert into Compra (Comprador, Publicacion, Fecha)"
                        + "values (?, ?, ?)"
            );                                  
            
            stmt.setInt(1, Comprador);
            stmt.setInt(2, Publicacion);
            java.sql.Date sqlFecha = new java.sql.Date(Fecha.getTime());
            stmt.setDate(3, sqlFecha);            
            stmt.executeUpdate();
            return 1;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        }  
    }
    
    @Override
    public int removeCompra(int Id_Compra) {
        PreparedStatement stmt;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement("DELETE FROM Compra WHERE Id_Compra = ?");
            stmt.setInt(1, Id_Compra);

            return stmt.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
       
}
