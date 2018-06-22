/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.models;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Wero
 */
public class Foro implements Serializable {
    
    private int Id_Mens;
    private String Mensaje;
    private Usuario Remitente;
    private Date Fecha;

    public int getId_Mens() {
        return Id_Mens;
    }

    public void setId_Mens(int Id_Mens) {
        this.Id_Mens = Id_Mens;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public Usuario getRemitente() {
        return Remitente;
    }

    public void setRemitente(Usuario Remitente) {
        this.Remitente = Remitente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
}
