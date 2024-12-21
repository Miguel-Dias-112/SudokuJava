/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

/**
 *
 * @author migue
 */
class Casa{
    private int valor;
    private boolean blocked;
    public Casa(int valor,boolean blocked){
        this.blocked=blocked;
        this.valor=valor;
    }
    int getValor(){
        return valor;
    }
    boolean setValor(int val){
        if(blocked!=true){
            this.valor=val;
            return true;
        }
        return false;
        
    }
}