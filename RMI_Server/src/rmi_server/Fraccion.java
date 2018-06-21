/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.io.Serializable;

/**
 *
 * @author Juan Antonio Castillo Rebolledo 14300080 8° B 1
 */
public class Fraccion implements Serializable{
    
    private int num;
    private int den;
    
    /** Constructor vacío
     * 
     */
    public Fraccion() {
        this.num = 0;
        this.den = 1;
    }
    
    /** Constructor de Fracción con valores de numerador y denominador
     * 
     * @param n int, Numerador de la Fracción
     * @param d int, Denominador de la Fracción
     */
    public Fraccion(int n, int d) {
        this.num = n;
        if(d > 0) {
            this.den = d;
        } else {
            this.den = 1;
        }
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public int getNum() {
        return this.num;
    }
    
    public void setDen(int den) {
        if (den > 0)
            this.den = den;
        else
            this.den = 1;
    }
    
    public int getDen() {
        return this.den;
    }
    
    public void simplificar() {
        int j = this.num;
        int k = this.den;
        int aux;
        while (k != 0)
        {
            aux = j % k;
            j = k;
            k = aux;
        }
        this.num /= j;
        this.den /= j;
        if(this.den < 0) {
            this.den *= -1;
            this.num *= -1;
        }
    }
    
}
