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
        System.out.print("[*]Quantos numeros vai sortear [max:80]: ");
        Scanner Teclado = new Scanner(System.in);
        int numeros = Teclado.nextInt();
        
        TableRandomizer tabuleiroRandom = new TableRandomizer();
        Casa[][] tabuleiro = tabuleiroRandom.getTabuleiroSorteado(numeros);
        jogo = new GameLogic(tabuleiro);
        
       jogo.Start();
        return numeros;
    }
    private int iniciaJogoDefinido(){
        System.out.print("[*] digite as entradas: ");
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
        TableDefiner Tabuleirodefiner = new TableDefiner(EntradasList);
        Casa[][] tabuleiroDefinido = Tabuleirodefiner.tabuleiro;
        jogo = new GameLogic(tabuleiroDefinido);

        return 0;
    }
    private int OpcoesJogo(){
        System.out.println("=== Voce quer? ===");
        System.out.println("[1] Criar jogo randomico");
        System.out.println("[2] Criar jogo defindo");
        System.out.println("[3] Encerrar");
        System.out.print("[*] Digite uma alternativa: ");
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
