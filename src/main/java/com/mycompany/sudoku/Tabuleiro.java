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
           for (int y = 0; y < 9; y++) {
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
     public Tabuleiro(){
         Imprimir();
     }
}
