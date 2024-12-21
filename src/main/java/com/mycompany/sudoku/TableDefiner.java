/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

import java.util.List;



public class TableDefiner {
    public TableSquare[][] tabuleiro = new TableSquare[9][9];
    
    private void posicionaTabela(Insertions entrada){
        if(entrada.valida==true){
            int x = entrada.posX;
            int y = entrada.posY;
            tabuleiro[x][y] = new TableSquare(entrada.valor,true);
        }
    }
    public TableDefiner(List<Insertions> Entradas){
        for(int x=0; x<9;x++){
            for(int y=0; y<9;y++){
                tabuleiro[x][y]= new TableSquare(0,false);
            }
        }
        for(Insertions entrada: Entradas){
            posicionaTabela(entrada);
        }
    }
}
