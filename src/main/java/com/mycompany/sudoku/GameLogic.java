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

        
    TableSquare[][] Tabuleiro= new TableSquare[9][9];
    private void imprimirTabuleiro(){
        System.out.println("");
        System.out.println("   1 2 3   4 5 6   7 8 9");
        System.out.println(" - - - - - - - - - - - - ");
        for (int x = 0; x < 9; x++) {
            for (int y =  0; y < 9; y++) {
                if(y==0){
                    System.out.print(x+" |");
                }
                 String valor =String.valueOf(Tabuleiro[x][y].getValor());
                 if(y==2 || y==5){ 
                     System.out.print(valor+" | ");
                 }
                 else{
                     System.out.print(valor+" ");
                 }
            }
           System.out.println();
           if(x==2 || x==5){ 
               System.out.println("  | - - - - - - - - -");
           }
        }     
        System.out.println("=====================");
    }
    public int iniciaJogoRandom(){
        System.out.print("[*]Quantos numeros vai sortear [max:80]: ");
        Scanner Teclado = new Scanner(System.in);
        int numeros = Teclado.nextInt();
        TableRandomizer tabuleiroRandom = new TableRandomizer();
        this.Tabuleiro = tabuleiroRandom.getTabuleiroSorteado(numeros);
        this.gameLoop();
        return numeros;
    }
    public int iniciaJogoDefinido(){
        System.out.print("[*] digite as entradas: ");
        Scanner Teclado = new Scanner(System.in);
        List<Insertions> EntradasList = new ArrayList<Insertions>();
        boolean parada= true;
        while(parada){
            String[] entradasTexto = Teclado.nextLine().replace("(","").split("\\)");
            for(String textoEntrada : entradasTexto){
                String[] texto = textoEntrada.split(",");
                int lin = Integer.parseInt(texto[0]);
                int col = Integer.parseInt(texto[1]);
                int val = Integer.parseInt(texto[2]);
                Insertions novaEntrada = new Insertions(lin,col,val);
                if(textoEntrada.equals("-1,-1,-1")){
                    parada=false;
                }else{
                EntradasList.add(novaEntrada);
                }
            }
        }
        TableDefiner Tabuleirodefiner = new TableDefiner(EntradasList);
        this.Tabuleiro = Tabuleirodefiner.tabuleiro;
        this.gameLoop();
        return 0;
    }
    private void fazerJogada(Insertions jogada){
       // if(!jogada.valida){return;}
        int lin = jogada.posX;
        int col = jogada.posY;
        boolean  resultado = Tabuleiro[lin][col].setValor(jogada.valor);
        if(resultado){
            System.out.println("[*] A posicao: "+lin+1+" "+col+1+" foi alterada");
        }else{
            System.out.println("[*] A posicao: "+lin+1+" "+col+1+" esta bloqueada");
        }
    }
    private void deletarJogada(Insertions jogada){
        if(!jogada.valida){return;}
        int lin = jogada.posX;
        int col = jogada.posY;
        boolean  resultado = Tabuleiro[lin][col].setValor(0);
        if(resultado){
            System.out.println("[*] A posicao: "+lin+1+" "+col+1+" foi deletada");
        }else{
            System.out.println("[*] A posicao: "+lin+1+" "+col+1+" nao pode ser deletada");
        }
    }
    private void gameLoop(){
        boolean gameRun = true;
        Scanner Teclado = new Scanner(System.in);
        while(gameRun){
            imprimirTabuleiro();
            System.out.println("[Game] Voce deseja");
            System.out.println("[1] Fazer uma jogada");
            System.out.println("[2] Deletar uma jogada");
            System.out.println("[3] Verficar erros");
            System.out.println("[4] Dicas");
            System.out.println("[5] Sair");
            System.out.print("[*] Digite uma alternativa: ");
            int opçãoSelecionada = Teclado.nextInt();
            String[] entradasTexto;
            switch (opçãoSelecionada) {
                case 1:
                    System.out.println("[*] Digite a(s) jogada(s):");
                    Teclado = new Scanner(System.in);
                    entradasTexto = Teclado.nextLine().replace("(","").split("\\)");
                    System.out.println("\n[*]====LOGS====[*]");

                    for( String textoEntrada: entradasTexto){
                        String[] entradas = textoEntrada.split(","); // Divide pelos separadores ','
                        int col = Integer.parseInt(entradas[0])-1;
                        int lin = Integer.parseInt(entradas[1])-1;
                        int val = Integer.parseInt(entradas[2]);
                        Insertions novaEntrada = new Insertions(lin,col,val);
                        this.fazerJogada(novaEntrada);
                    }
                    System.out.println("[*]====LOGS====[*]");

                    break;
                case 2:
                    System.out.print("[*] Digite a posicao deletada: ");
                    Teclado = new Scanner(System.in);
                    entradasTexto = Teclado.nextLine().replace("(","").split("\\)"); 
                    System.out.println("\n[*]====LOGS====[*]");
                    for( String textoEntrada: entradasTexto){
                        String[] entradas = textoEntrada.split(","); // Divide pelos separadores ','
                        int lin = Integer.parseInt(entradas[1])-1;
                        int col = Integer.parseInt(entradas[0])-1;
                        Insertions novaEntrada = new Insertions(lin,col);
                        this.deletarJogada(novaEntrada);
                    }
                    System.out.println("\n [*]====LOGS====[*]");

                    break;
                case 3:
                    TableChecker checador = new TableChecker();
                    checador.imprimeRepetições(this.Tabuleiro);
                default:
                    break;
            }
        }
    }   

}
