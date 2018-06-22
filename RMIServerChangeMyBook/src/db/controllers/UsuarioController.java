/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.controllers;
import db.DBmanage;
import db.models.*;
import java.rmi.RemoteException;
import rmiserverbook.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import otherop.HashingEncoder;

/**
 *
 * @author Emiliano
 */
public class UsuarioController extends UnicastRemoteObject implements UsuarioInterface {
    
    public UsuarioController () throws RemoteException { 
        super();
    }
    
    private Connection createCon () {
        DBmanage db = new DBmanage();
        Connection con = db.getCon();
        return con;
    }
    
    public Usuario readUsuarioById (int Id_U) {
        PreparedStatement stmt;
        Usuario user = new Usuario();
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement("Select * from usuario where Id_U = ?");
            stmt.setInt(1, Id_U);
            rs = stmt.executeQuery(); rs.next();
            user.setId_U(rs.getInt("Id_U"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
            user.setCreditos(rs.getInt("Creditos"));
            user.setHash(rs.getString("Hash"));  
            return user;
        } catch (SQLException ex) {
            System.out.println(ex);        
            return null;
        }        
    }
    
    @Override
    public ArrayList<Usuario> readUsuarios (){        
        PreparedStatement sqlStmnt;
        
        ArrayList<Usuario> usuarios = new ArrayList();
        Usuario Usuario;
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            sqlStmnt = con.prepareStatement("Select * from Usuario order by Id_U");
            rs = sqlStmnt.executeQuery();
            
            while(rs.next()) {
                Usuario = new Usuario();
                Usuario.setId_U(rs.getInt("Id_U"));
                Usuario.setUsername(rs.getString("Username"));
                Usuario.setPassword(rs.getString("Password"));
                Usuario.setCreditos(rs.getInt("Creditos"));
                Usuario.setHash(rs.getString("Hash"));
                usuarios.add(Usuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println(ex);
            ArrayList<Usuario> u = new ArrayList();
            return u;
        }                
    }
    
    @Override
    public Usuario login(String username, String password) {
        PreparedStatement stmt;
        Usuario user = new Usuario();
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement("Select * from usuario where Username = ? and Password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery(); rs.next();
            user.setId_U(rs.getInt("Id_U"));
            user.setUsername(username);
            user.setPassword("");
            user.setCreditos(rs.getInt("Creditos"));
            user.setHash(rs.getString("Hash"));  
            return user;
        } catch (SQLException ex) {
            System.out.println(ex);        
            return null;
        }    
    }
    
    @Override
    public Usuario readUsuarioByUsername (String Username) {
        PreparedStatement stmt;
        Usuario user = new Usuario();
        ResultSet rs;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement("Select * from usuario where Username = ?");
            stmt.setString(1, Username);
            rs = stmt.executeQuery(); rs.next();
            user.setId_U(rs.getInt("Id_U"));
            user.setUsername(Username);
            user.setPassword(rs.getString("Password"));
            user.setCreditos(rs.getInt("Creditos"));
            user.setHash(rs.getString("Hash"));  
            return user;
        } catch (SQLException ex) {
            System.out.println(ex);        
            return null;
        }        
    } 
    
    @Override
    public int updateDinero (int Id_U, int dinero) {
        PreparedStatement stmt;
        
        try {   
            Connection con = this.createCon();
            stmt = con.prepareStatement(
                "Update usuario set Creditos = ? where Id_U = ?"
            );                        
            
            
            stmt.setInt(1, dinero);
            stmt.setInt(2, Id_U);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        }
    }
    
    @Override
    public int createUser (String Username, String Password, 
            int Creditos){
                     
        Usuario UCheck = readUsuarioByUsername(Username);        
        if (UCheck != null) {
            return 0;               //Ya existe ese Username
        }
        
        HashingEncoder encoder = new HashingEncoder();
        PreparedStatement stmt;
        
        try {
            Connection con = this.createCon();
            stmt = con.prepareStatement(
                "Insert into usuario (Username, Password, Creditos, Hash)"
                        + "values (?, ?, ?, ?)"
            );
            
            String hashPswd, hashHash;
            hashPswd = encoder.encodePswd(Password);
            hashHash = encoder.getNewHash();           
            
            stmt.setString(1, Username);
            stmt.setString(2, hashPswd);
            stmt.setInt(3, Creditos);
            stmt.setString(4, hashHash);
            stmt.executeUpdate();
            return 1;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        }        
    }
    
    @Override
    public int updateUser (String Username, String newUsername, String Password,
        int Creditos){
        
        if (Username.equals(newUsername)) {
            Usuario UCheck = readUsuarioByUsername(newUsername);
            if (UCheck.getUsername().equals(Username)) {
                return 0;               //Ya existe ese Username
            }
        }
        
        HashingEncoder encoder = new HashingEncoder();
        PreparedStatement stmt;
        
        try {   
            Connection con = this.createCon();
            stmt = con.prepareStatement(
                "Update usuario set Username = ?, Password = ?, Creditos = ?, Hash = ?"
                        + "where Username = ?"
            );
            
            String hashPswd, hashHash;
            hashPswd = encoder.encodePswd(Password);
            hashHash = encoder.getNewHash();            
            
            stmt.setString(1, newUsername);
            stmt.setString(2, hashPswd);
            stmt.setString(3, hashHash);
            stmt.setInt(4, Creditos);
            stmt.setString(5, Username);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        }        
    }
        
}
