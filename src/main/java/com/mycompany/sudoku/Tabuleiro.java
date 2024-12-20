/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;


/**
 *
 * @author migue
 */
public class Tabuleiro {
    int tabuleiro[][]= new int[9][9];


    
    
    public void Imprimir(){
        System.out.println("======Tabuleiro======");
        for (int x = 0; x < 9; x++) {
           for (int y =  0; y < 9; y++) {
                int valor = tabuleiro[x][y];
                if(y==2 || y==5){ System.out.print(valor+" | ");}else{
                    System.out.print(valor+" ");
                }
           }
           System.out.println();
           if(x==2 || x==5){ 
               System.out.println("- - - - - - - - - - -");
           }
        }     
        System.out.println("=====================");
    }
    private final void bauguncaNumeros() {
        for (int i = 1; i <= 9; i++) { // Números de 1 a 9
            int randomNumber = (int) (Math.random() * 10); // De 0 a 9
            trocaNumeros(i, randomNumber); // Troca posições de i e ranNum
        }
    }
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
    
    public Tabuleiro(){
         int _tabuleiro[][]={
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
         this.tabuleiro = _tabuleiro;
         this.bauguncaNumeros();
         this.Imprimir();
         
    }
}