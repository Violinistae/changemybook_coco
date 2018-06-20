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
public class foro {
    
    private int Id_Mens;
    private String Mensaje;
    private usuario Remitente;
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

    public usuario getRemitente() {
        return Remitente;
    }

    public void setRemitente(usuario Remitente) {
        this.Remitente = Remitente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
}
