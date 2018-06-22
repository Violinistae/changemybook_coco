/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Wero
 */
public class Compra implements Serializable {
    
    private int Id_Compra;
    private Usuario Comprador;
    private Publicacion Publicacion;
    private Date datetime;

    public int getId_Compra() {
        return Id_Compra;
    }

    public void setId_Compra(int Id_Compra) {
        this.Id_Compra = Id_Compra;
    }

    public Usuario getComprador() {
        return Comprador;
    }

    public void setComprador(Usuario Comprador) {
        this.Comprador = Comprador;
    }

    public Publicacion getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(Publicacion Publicacion) {
        this.Publicacion = Publicacion;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
    
    
}
