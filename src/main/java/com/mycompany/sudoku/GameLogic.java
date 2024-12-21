/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author migue
 */

public class GameLogic {
    Casa[][] Tabuleiro= new Casa[9][9];

    public void Imprimir(){
        System.out.println("");

        System.out.println("======Tabuleiro======");
        for (int x = 0; x < 9; x++) {
           for (int y =  0; y < 9; y++) {
                String valor =String.valueOf(Tabuleiro[x][y].getValor());
                
                if(y==2 || y==5){ 
                    System.out.print(valor+" | ");}
                else{
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
    private void setTabuleiro(Entrada jogada){
       
    }
    private void fazerJogada(Entrada jogada){
        if(!jogada.valida){return;}
        int x = jogada.posX;
        int y = jogada.posY;
        boolean  resultado = Tabuleiro[x][y].setValor(jogada.valor);
        if(!resultado){
            System.out.println("[Game] A posicao: "+x+" "+y+" eh invalida");
        }

    }
    private void deletar(int lin, int col){

        if(lin>=0 && lin<10 && col>=0 && col<10){
            boolean  resultado = Tabuleiro[lin][col].setValor(0);
            if(resultado){
                System.out.println("[Game] A posicao: "+lin+" "+col+" não pode ser deletada");
            }
        }
    }
    public void Start(){
        boolean gameRun = true;
        Imprimir();
        Scanner Teclado = new Scanner(System.in);

        while(gameRun){
            System.out.println("[Game] Voce deseja");
            System.out.println("[1] Fazer uma jogada");
            System.out.println("[2] Deletar uma jogada");
            System.out.println("[3] Verficar erros");
            System.out.println("[4] Dicas");
            System.out.println("[5] Sair");
            System.out.print("[*] Digite uma alternativa: ");

            int opçãoSelecionada = Teclado.nextInt();
            switch (opçãoSelecionada) {
            case 1:
                System.out.println("[Game] Digite a(s) jogada(s):");
                Teclado = new Scanner(System.in);
                String[] entradasTexto = Teclado.nextLine().replace("(","").split("\\)");;;
                for( String textoEntrada: entradasTexto){
                    Entrada novaEntrada = new Entrada(textoEntrada);
                    fazerJogada(novaEntrada);
                }
                Imprimir();
                break;
            case 2:
                System.out.println("[Game] Digite a posicao deletada:");
                Teclado = new Scanner(System.in);
                 String valoresSemParenteses = Teclado.nextLine().substring(1, Teclado.nextLine().length() - 1); // Remove '(' e ')'
                String[] texto = valoresSemParenteses.split(",");
                int lin = Integer.parseInt(texto[0]);
                int col =  Integer.parseInt(texto[1]);
                deletar(lin,col);
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }
        }
    }
    public GameLogic( Casa[][]tabuleiro){
        this.Tabuleiro = tabuleiro;
    }
    
}