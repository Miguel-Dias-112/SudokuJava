/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku.Controladores;

import com.mycompany.sudoku.Modelos.Entrada;
import com.mycompany.sudoku.Modelos.TableSquare;

/**
 *private void posicionaTabela(Entrada entrada){

    }
 * @author migue
 */
public class Tabuleiro {
    public TableSquare[][] tabuleiro= new TableSquare[9][9];
    public int getSquareValue(int x, int y){
        int valor = tabuleiro[x][y].getValor();
        return valor;
    }
    public void setSquareValue(Entrada jogada, boolean blocked){
        //if(!jogada.valida){return;}
        int x = jogada.getPosX();
        int y = jogada.getPosY();
        int valor = jogada.getValor();
        tabuleiro[x][y] = new TableSquare(valor,blocked);
    }
    public boolean fazerJogada(Entrada jogada){
        if(!jogada.isValida()){return false;}
        int lin = jogada.getPosX();
        int col = jogada.getPosY();
        boolean  resultado = tabuleiro[col][lin].setValor(jogada.getValor());
        return resultado;
    }
    public boolean deletarJogada(Entrada jogada){
        if(!jogada.isValida()){return false;}
        int lin = jogada.getPosX();
        int col = jogada.getPosY();
        boolean  resultado = tabuleiro[col][lin].setValor(0);
        return resultado;
    }
    public Tabuleiro(){
        
   }

}
