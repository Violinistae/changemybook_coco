/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.controllers;
import db.DBmanage;
import db.models.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmiserverbook.CompraInterface;

/**
 *
 * @author Emiliano
 */
public class CompraController extends UnicastRemoteObject implements CompraInterface {
    public CompraController () throws RemoteException{
        super();
    }
       
}
