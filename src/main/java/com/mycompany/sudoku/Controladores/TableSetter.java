/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku.Controladores;

import com.mycompany.sudoku.Modelos.Entrada;
import com.mycompany.sudoku.Modelos.TableSquare;
import java.util.List;

/**
 *
 * @author migue
 */
public class TableSetter {
    private static int [][] tabuleiro = new int[9][9];
    private static void trocaNumeros(int n1, int n2) {
        for (int y = 0; y<9; y++) {
            for (int x = 0; x<9; x++) {
                if (tabuleiro[x][y] == n1) {
                    tabuleiro[x][y] = n2;
                } else if (tabuleiro[x][y] == n2) {
                    tabuleiro[x][y] = n1;
                }
            }   
        }
    }
    private static final void bauguncaNumeros() {
        for (int i = 1; i <= 9; i++) { // Números de 1 a 9
            int randomNumber = (int) (Math.random() * 8)+1; // De 0 a 9
            trocaNumeros(i, randomNumber); // Troca posições de i e ranNum
        }
    }
    private static int[][] sorteiaValores(int qntdNumeros){
        int totalIteracoes = 81-qntdNumeros;
        for(int i=0; i<totalIteracoes; i++){
            int randomPosY= (int) (Math.random() * 9); // De 0 a 9
            int randomPosX = (int) (Math.random() * 9); // De 0 a 9
            int itemSelecionado = tabuleiro[randomPosY][randomPosX];
            if( itemSelecionado != 0 ){
                tabuleiro[randomPosY][randomPosX]=0;
            }
            else{
                while(itemSelecionado == 0){
                    randomPosY= (int) (Math.random() * 9); // De 0 a 9
                    randomPosX = (int) (Math.random() * 9); // De 0 a 9
                    itemSelecionado = tabuleiro[randomPosY][randomPosX];
                    tabuleiro[randomPosY][randomPosX]=0;

                }
            }   
        }
        return tabuleiro;
    }
    public static  Tabuleiro TabuleiroSorteado(int val){
         int _tabuleiro[][]= {
                {1,2,3,  4,5,6,  7,8,9},
                {4,5,6,  7,8,9,  1,2,3},
                {7,8,9,  1,2,3,  4,5,6},

                {2,3,1,  5,6,4,  8,9,7},
                {5,6,4,  8,9,7,  2,3,1},
                {8,9,7,  2,3,1,  5,6,4},

                {3,1,2,  6,4,5,  9,7,8},
                {6,4,5,  9,7,8,  3,1,2},
                {9,7,8,  3,1,2,  6,4,5}
         };
        tabuleiro = _tabuleiro;
        bauguncaNumeros();
        int[][] tabuleiroSorteado = sorteiaValores(val);
        Tabuleiro novoTabuleiro = new Tabuleiro();

        for(int x=0; x<9; x++){
            for(int y=0; y<9; y++){
                int valor = tabuleiroSorteado[x][y];
                if(valor!=0){
                    Entrada entrada = new Entrada(x,y,valor);
                    novoTabuleiro.setSquareValue(entrada,true);
                }else{
                    Entrada entrada = new Entrada(x,y);
                   novoTabuleiro.setSquareValue(entrada,false);
                }
            }
        }
        return novoTabuleiro;
    }
    public static Tabuleiro TabuleiroDefinido(List<Entrada> Entradas){
        Tabuleiro novoTabuleiro = new Tabuleiro();
        for(int x=0; x<9;x++){
            for(int y=0; y<9;y++){
                Entrada entrada = new Entrada(x,y);
                novoTabuleiro.setSquareValue(entrada,false);
            }
        }
        for(Entrada entrada: Entradas){
            if(!entrada.isValida()){continue;}
            novoTabuleiro.setSquareValue(entrada, true);
        }
        return novoTabuleiro;
    }

    
   
}
