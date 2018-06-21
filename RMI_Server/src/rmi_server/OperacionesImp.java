/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author juanc
 */
public class OperacionesImp extends UnicastRemoteObject implements Operaciones {
    
    public OperacionesImp() throws RemoteException { 
        super();
    }
    
    @Override
    public Fraccion suma(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.setNum(a.getNum() * b.getDen() + b.getNum() * a.getDen());
        resultado.setDen(a.getDen() * b.getDen());
        resultado.simplificar();
        return resultado;
    }
    
    @Override
    public Fraccion resta(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.setNum(a.getNum() * b.getDen() - b.getNum() * a.getDen());
        resultado.setDen(a.getDen() * b.getDen());
        resultado.simplificar();
        return resultado;
    }
    
    @Override
    public Fraccion multiplicacion(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.setNum(a.getNum() * b.getNum());
        resultado.setDen(a.getDen() * b.getDen());
        resultado.simplificar();
        return resultado;
    }
    
    @Override
    public Fraccion division(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.setNum(a.getNum() * b.getDen());
        resultado.setDen(a.getDen() * b.getNum());
        resultado.simplificar();
        return resultado;
    }
    
}
