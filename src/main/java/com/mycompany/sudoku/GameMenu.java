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
    
    GameLogic Jogo=  new GameLogic();
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
                Jogo.iniciaJogoRandom();

                break;
            case 2:
                Jogo.iniciaJogoDefinido();

                break;
            case 3:
                System.exit(0);
            default:
                break;
        }
    }
}
