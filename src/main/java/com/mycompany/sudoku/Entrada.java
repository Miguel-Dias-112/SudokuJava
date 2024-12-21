/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;
public class Entrada{
    public int posX;
    public int posY;
    public int valor;
    public boolean valida;
    private void validacao(){
        if(posX <0 || posX >9){
            valida=false;
            return;
        }
        if(posY <0 || posY >9){
            valida=false;
            return;
        }
        if(valor <0 || valor >9){
            valida=false;
            return;
        }
        valida=true;
    }
    public Entrada(String entrada){
        String[] valores = entrada.split(","); // Divide pelos separadores ','
        
        // Converter os valores para inteiro
        
        this.posX = Integer.parseInt(valores[0].trim());
        this.posY = Integer.parseInt(valores[1].trim());    
        this.valor = Integer.parseInt(valores[2].trim());
        
        this.validacao();
    }
}
