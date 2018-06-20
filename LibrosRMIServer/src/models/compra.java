/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Wero
 */
public class compra {
    
    private int Id_Compra;
    private usuario Comprador;
    private publicacion Publicacion;
    private Date datetime;

    public int getId_Compra() {
        return Id_Compra;
    }

    public void setId_Compra(int Id_Compra) {
        this.Id_Compra = Id_Compra;
    }

    public usuario getComprador() {
        return Comprador;
    }

    public void setComprador(usuario Comprador) {
        this.Comprador = Comprador;
    }

    public publicacion getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(publicacion Publicacion) {
        this.Publicacion = Publicacion;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
    
    
}
