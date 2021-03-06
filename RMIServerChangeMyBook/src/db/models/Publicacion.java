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
public class Publicacion implements Serializable {
    
    private int Id_Pub;
    private String Texto;
    private Usuario Publicador;
    private int Precio;
    private String Foto;
    private int EstadoP;
    
    public Publicacion() {
        this.Id_Pub = 0;
        this.Texto = "";
        this.Publicador = new Usuario();
        this.Precio = 0;
        this.Foto = "";
        this.EstadoP = 0;
    }

    public int getId_Pub() {
        return Id_Pub;
    }

    public void setId_Pub(int Id_Pub) {
        this.Id_Pub = Id_Pub;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public Usuario getPublicador() {
        return Publicador;
    }

    public void setPublicador(Usuario Publicador) {
        this.Publicador = Publicador;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public int getEstadoP() {
        return EstadoP;
    }

    public void setEstadoP(int EstadoP) {
        this.EstadoP = EstadoP;
    }
    
    
    
}
