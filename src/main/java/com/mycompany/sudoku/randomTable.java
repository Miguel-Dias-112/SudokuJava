/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

/**
 *
 * @author migue
 */
public class RandomTable {
    public int [][] tabuleiro = new int[9][9];
     private void trocaNumeros(int n1, int n2) {
        for (int y = 0; y<9; y++) {
            for (int x = 0; x<9; x++) {
                if (this.tabuleiro[x][y] == n1) {
                    this.tabuleiro[x][y] = n2;
                } else if (this.tabuleiro[x][y] == n2) {
                    this.tabuleiro[x][y] = n1;
                }
            }   
        }
    }
    private final void baguncaNumeros() {
        for (int i = 1; i <= 9; i++) { // Números de 1 a 9
            int randomNumber = (int) (Math.random() * 10); // De 0 a 9
            trocaNumeros(i, randomNumber); // Troca posições de i e ranNum
        }
    }
    public int[][] getTabuleiroSorteado(int qntdNumeros){
        int totalIteracoes = 81-qntdNumeros;
        for(int i=0; i<totalIteracoes; i++){
            int randomPosY= (int) (Math.random() * 9); // De 0 a 9
            int randomPosX = (int) (Math.random() * 9); // De 0 a 9
            int itemSelecionado = this.tabuleiro[randomPosY][randomPosX];
            if( itemSelecionado != 0 ){
                this.tabuleiro[randomPosY][randomPosX]=0;
            }else{
                while(itemSelecionado == 0){
                    randomPosY= (int) (Math.random() * 9); // De 0 a 9
                    randomPosX = (int) (Math.random() * 9); // De 0 a 9
                    itemSelecionado = this.tabuleiro[randomPosY][randomPosX];

                    this.tabuleiro[randomPosY][randomPosX]=0;
                }
            }
            
        }
        return tabuleiro;
    }
    public RandomTable( ){
        int tabuleiro[][]={
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
        baguncaNumeros();
    }
   
}
