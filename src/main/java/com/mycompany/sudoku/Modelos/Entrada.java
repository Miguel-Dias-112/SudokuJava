/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku.Modelos;
public class Entrada{
    private int posX;
    private int posY;
    private int valor;
    private boolean valida;
    @Override
    public boolean equals(Object obj){
        Entrada Ecomparada = (Entrada)obj;
        int _posX = Ecomparada.posX;
        int _posY = Ecomparada.posY;
        int _valor = Ecomparada.valor;
        return  this.posX ==_posX && 
                this.posY==_posY && 
                this.valor==_valor;
            
    }
    private void valida(int posX,int posY,int valor){
        if(posX >=0 && posX <9 &&  posY >=0 && posY <9 && valor>0 && valor <10 ){
            valida=true;
            return;
        }
        
        valida=false;
    }
    private void valida(int posX,int posY){
        if(posX >=0 && posX <9 &&  posY >=0 && posY <9){
            valida=true;
            
        }
        valida=false;
    }
    public Entrada(int lin, int col, int val){
        this.posX = lin;
        this.posY =col; 
        this.valor = val;
        valida(lin,col,val);
        
    }
    public Entrada(int lin, int col){
        this.posX = lin;
        this.posY =col; 
        valida(lin,col);

    }   
    
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getValor() {
        return valor;
    }

    public boolean isValida() {
        return valida;
    }
}
