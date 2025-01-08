/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku.Modelos;

/**
 *
 * @author migue
 */
public class TableSquare{
    private int valor;
    private boolean blocked;
    
    public TableSquare(int valor,boolean blocked){
        this.blocked=blocked;
        this.valor=valor;
    }
    public int getValor(){
        return valor;
    }
    public boolean setValor(int val){
        if(blocked!=true){
            this.valor=val;
            return true;
        }
        return false;
        
    }
}