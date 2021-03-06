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
public class Res_Foro implements Serializable {
    
    private int Id_RF;
    private String RespuestaM;
    private Usuario Remitente;
    private Date Fecha;
    private Foro Mensaje;
    
    public Res_Foro() {
        this.Id_RF = 0;
        this.RespuestaM = "";
        this.Remitente = new Usuario();
        this.Fecha = new Date();
        this.Mensaje = new Foro();
    }

    public int getId_RF() {
        return Id_RF;
    }

    public void setId_RF(int Id_RF) {
        this.Id_RF = Id_RF;
    }

    public String getRespuestaM() {
        return RespuestaM;
    }

    public void setRespuestaM(String RespuestaM) {
        this.RespuestaM = RespuestaM;
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

    public Foro getMensaje() {
        return Mensaje;
    }

    public void setMensaje(Foro Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    
    
}
