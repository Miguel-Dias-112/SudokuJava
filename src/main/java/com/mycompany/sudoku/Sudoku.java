/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sudoku;
import java.util.Scanner;
/**
 *
 * @author migue
 */
public class Sudoku {
    private static int jogoRandom(){
        System.out.println("[1.1] Quantos numeros vai sortear? [max:81]");
        Scanner Teclado = new Scanner(System.in);
        int numeros = Teclado.nextInt();
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.sorteiaNumeros(numeros);
        tabuleiro.Imprimir();
        
        
        return numeros;
    }
    public static int jogoDefinido(){
        System.out.println("[1.1] digite as entradas:");
        Scanner Teclado = new Scanner(System.in);
        int numeros = Teclado.nextInt();
        return numeros;
    }
    private static int OpcoesJogo(){
        System.out.println("=== Voce quer? ===");
        System.out.println("[1] Criar jogo randomico");
        System.out.println("[2] Criar jogo defindo");
        System.out.println("[3] Encerrar");
        System.out.println("Digite uma alternativa: ");
        Scanner Teclado = new Scanner(System.in);
        int opçãoSelecionada = Teclado.nextInt();
        return opçãoSelecionada;
    }
    private static void cicloJogo(){
        int opçãoSelecionada = OpcoesJogo();
        if(opçãoSelecionada == 1){
            jogoRandom();
        }else if (opçãoSelecionada==2){
            jogoDefinido();
        }else if (opçãoSelecionada==3){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        System.out.println("Bem Vindo!");
        while(true){
            cicloJogo();
        }

        
        
    }
   
}
