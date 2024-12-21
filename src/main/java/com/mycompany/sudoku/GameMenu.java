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
public class GameMenu {
    private GameLogic jogo;
    
    private int iniciaJogoRandom(){
        System.out.println("[1.1] Quantos numeros vai sortear? [max:81]");
        Scanner Teclado = new Scanner(System.in);
        int numeros = Teclado.nextInt();
        
        RandomTable tabuleiroRandom = new RandomTable();
        int[][] tabuleiro = tabuleiroRandom.getTabuleiroSorteado(numeros);
        jogo = new GameLogic(tabuleiro);
        
        return numeros;
    }
    private int iniciaJogoDefinido(){
        System.out.println("[1.1] digite as entradas:");
        Scanner Teclado = new Scanner(System.in);
        List<Entrada> EntradasList = new ArrayList<Entrada>();
        boolean parada= true;
        
        while(parada){
               String[] entradasTexto = Teclado.nextLine().replace("(","").split("\\)");
             for(String textoEntrada : entradasTexto){
                 Entrada novaEntrada = new Entrada(textoEntrada);
                 if(textoEntrada.equals("-1,-1,-1")){
                     parada=false;
                 }else{
                    EntradasList.add(novaEntrada);
                 }
             }
        }
        DefinedTable Tabuleirodefiner = new DefinedTable(EntradasList);
        int[][] tabuleiroDefinido = Tabuleirodefiner.tabuleiro;
        jogo = new GameLogic(tabuleiroDefinido);
        jogo.Imprimir();
        return 0;
    }
    private int OpcoesJogo(){
        System.out.println("=== Voce quer? ===");
        System.out.println("[1] Criar jogo randomico");
        System.out.println("[2] Criar jogo defindo");
        System.out.println("[3] Encerrar");
        System.out.println("Digite uma alternativa: ");
        Scanner Teclado = new Scanner(System.in);
        int opçãoSelecionada = Teclado.nextInt();
        return opçãoSelecionada;
    }
    public GameMenu(){
        int opçãoSelecionada = OpcoesJogo();
        switch (opçãoSelecionada) {
            case 1:
                iniciaJogoRandom();
                break;
            case 2:
                iniciaJogoDefinido();
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }
    }
}
