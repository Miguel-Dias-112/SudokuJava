/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

import java.util.Scanner;

/**
 *
 * @author migue
 */
public class GameMenu {
    private int iniciaJogoRandom(){
        System.out.println("[1.1] Quantos numeros vai sortear? [max:81]");
        Scanner Teclado = new Scanner(System.in);
        int numeros = Teclado.nextInt();
        
        RandomTable tabuleiroRandom = new RandomTable(numeros);
        
        return numeros;
    }
    private static int iniciaJogoDefinido(){
        System.out.println("[1.1] digite as entradas:");
        Scanner Teclado = new Scanner(System.in);
        int numeros = Teclado.nextInt();
        return numeros;
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
        if(opçãoSelecionada == 1){
            iniciaJogoRandom();
        }else if (opçãoSelecionada==2){
            iniciaJogoDefinido();
        }else if (opçãoSelecionada==3){
            System.exit(0);
        }
    }
}
