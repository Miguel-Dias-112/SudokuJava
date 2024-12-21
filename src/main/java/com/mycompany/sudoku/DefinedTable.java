/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

import java.util.List;



public class DefinedTable {
    public int [][] tabuleiro = new int[9][9];
    
    private void posicionaTabela(Entrada entrada){
        if(entrada.valida==true){
            int x = entrada.posX;
            int y = entrada.posY;
            tabuleiro[x][y]=entrada.valor;
        }
    }
    public DefinedTable(List<Entrada> Entradas){
        for(Entrada entrada: Entradas){
            posicionaTabela(entrada);
        }
    }
}
