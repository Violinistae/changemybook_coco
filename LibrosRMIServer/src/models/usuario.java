/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Wero
 */
public class usuario {
    
    private int Id_U;
    private String Username;
    private String Password;
    private String Creditos;
    private String Hash;
    

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

    public String getCreditos() {
        return Creditos;
    }

    public void setCreditos(String Creditos) {
        this.Creditos = Creditos;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String Hash) {
        this.Hash = Hash;
    }   
    
}
