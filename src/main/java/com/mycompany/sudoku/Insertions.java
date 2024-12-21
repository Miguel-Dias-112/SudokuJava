/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;
public class Insertions{
    public int posX;
    public int posY;
    public int valor;
    public boolean valida;
    private void validaPos(){
        if(posX >0 && posX <9){
            valida=false;
            return;
        }
        if(posY >0 && posY <9){
            valida=false;
            return;
        }
        
        valida=true;
    }
    public Insertions(int lin, int col, int val){
        this.posX = lin;
        this.posY =col; 
        this.valor = val;
        this.validaPos();
        if(valor>0 && valor <10){
            valida=false;
            return;
        }   
    }
    public Insertions(int lin, int col){
        this.posX = lin;
        this.posY =col; 
        validaPos();  
    }
}
