/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.models;

import java.io.Serializable;

/**
 *
 * @author Wero
 */
public class Usuario implements Serializable{
    
    private int Id_U;
    private String Username;
    private String Password;
    private int Creditos;
    private String Hash;
    
    public Usuario() {
        this.Id_U = 0;
        this.Username = "";
        this.Password = "";
        this.Creditos = 0;
        this.Hash = "";
    }

    public int getId_U() {
        return Id_U;
    }

    public void setId_U(int Id_U) {
        this.Id_U = Id_U;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int Creditos) {
        this.Creditos = Creditos;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String Hash) {
        this.Hash = Hash;
    }   
    
}
