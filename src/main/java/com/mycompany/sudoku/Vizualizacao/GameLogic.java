/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku.Vizualizacao;

import com.mycompany.sudoku.Controladores.TableChecker;
import com.mycompany.sudoku.Controladores.TableSetter;
import com.mycompany.sudoku.Modelos.Entrada;
import com.mycompany.sudoku.Modelos.TableSquare;
import com.mycompany.sudoku.Controladores.Tabuleiro;
import com.mycompany.sudoku.Modelos.Repetição;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Lógica do jogo Sudoku.
 * 
 * @author migue
 */
public class GameLogic {

    private Tabuleiro tabuleiro;
    public void imprimirTabuleiro() {
        String[] opcoes = {"Fazer uma jogada", "Deletar uma jogada", "Verificar erros", "Dicas", "Sair"};

        System.out.println();
        System.out.println("     1 2 3   4 5 6   7 8 9");
        System.out.println("   +-------+-------+-------+");

        for (int x = 0; x < 9; x++) {
            System.out.print(" " + (x + 1) + " |");

            for (int y = 0; y < 9; y++) {
                String valor = String.valueOf(tabuleiro.getSquareValue(x, y));
                if ("0".equals(valor)) { // Substitui zeros por espaço para melhorar a visualização
                    valor = "~";
                }

                System.out.print(" " + valor);

                if ((y + 1) % 3 == 0) { // Adiciona separadores verticais entre blocos
                    System.out.print(" |");
                }
            }

            // Adiciona as opções do menu ao lado do tabuleiro
            // Adiciona separadores horizontais entre blocos
           
            if (x < opcoes.length) {
                System.out.print("   [" + (x + 1) + "] " + opcoes[x]);
            }
            if ((x + 1) % 3 == 0) {
                System.out.print("\n   +-------+-------+-------+");
            }
            System.out.println();

            
        }
        System.out.print("[*] Digite uma alternativa: ");
    }
    public int iniciaJogoRandom() {
        System.out.print("[*] Quantos números vai sortear [max: 80]: ");
        Scanner teclado = new Scanner(System.in);
        int numeros = teclado.nextInt();
        this.tabuleiro = TableSetter.TabuleiroSorteado(numeros);
        this.gameLoop();
        return numeros;
    }
    public int iniciaJogoDefinido() {
        System.out.print("[*] Digite as entradas: ");
        Scanner teclado = new Scanner(System.in);
        List<Entrada> entradasList = new ArrayList<>();
        boolean parada = true;
        
        while (parada) {
            String[] entradasTexto = teclado.nextLine().replace("(", "").split("\\)");
            for (String textoEntrada : entradasTexto) {
                String[] texto = textoEntrada.split(",");
                int lin = Integer.parseInt(texto[0]);
                int col = Integer.parseInt(texto[1]);
                int val = Integer.parseInt(texto[2]);
                
                if (textoEntrada.equals("-1,-1,-1")) {
                    parada = false;
                } else {
                    entradasList.add(new Entrada(lin, col, val));
                }
            }
        }
        
        this.tabuleiro = TableSetter.TabuleiroDefinido(entradasList);
        this.gameLoop();
        return 0;
    }

    private void gameLoop() {
        boolean gameRun = true;
        Scanner teclado = new Scanner(System.in);
        while (gameRun) {
            if (TableChecker.checaVitoria(tabuleiro)) {
                System.out.println("[*] PARABÉNS!");
                return;
            }
            this.imprimirTabuleiro();
            int opcaoSelecionada = teclado.nextInt();
            String[] entradasTexto;
            switch (opcaoSelecionada) {
                case 1 -> this.realizarJogadas(teclado);
                case 2 -> this.deletarJogadas(teclado);
                case 3 -> this.verificarErros();
                case 4 -> this.exibirDicas(teclado);
                default -> gameRun = false;
            }
        }
    }

    private void realizarJogadas(Scanner teclado) {
        System.out.println("[*] Digite a(s) jogada(s):");
        teclado = new Scanner(System.in);
        String[] entradasTexto = teclado.nextLine().replace("(", "").split("\\)");

        for (String textoEntrada : entradasTexto) {
            String[] entradas = textoEntrada.split(",");
            int lin = Integer.parseInt(entradas[0]) - 1;
            int col = Integer.parseInt(entradas[1]) - 1;
            int val = Integer.parseInt(entradas[2]);
            Entrada novaEntrada = new Entrada(lin, col, val);

            if (tabuleiro.fazerJogada(novaEntrada)) {
                System.out.println("A posição (" + entradas[0] + "," + entradas[1] + "," + val + ") foi inserida.");
            } else {
                System.out.println("A posição (" + entradas[0] + "," + entradas[1] + "," + val + ") não pode ser inserida.");
            }
        }
    }

    private void deletarJogadas(Scanner teclado) {
        System.out.print("[*] Digite a posição a ser deletada: ");
        teclado = new Scanner(System.in);
        String[] entradasTexto = teclado.nextLine().replace("(", "").split("\\)");

        for (String textoEntrada : entradasTexto) {
            String[] entradas = textoEntrada.split(",");
            int lin = Integer.parseInt(entradas[0]) - 1;
            int col = Integer.parseInt(entradas[1]) - 1;
            Entrada novaEntrada = new Entrada(lin, col);

            if (tabuleiro.deletarJogada(novaEntrada)) {
                System.out.println("A posição (" + entradas[0] + "," + entradas[1] + ") foi deletada.");
            } else {
                System.out.println("A posição (" + entradas[0] + "," + entradas[1] + ") não pode ser deletada.");
            }
        }
    }

    private void verificarErros() {
        HashSet<Repetição> repeticoes = TableChecker.Repetições(tabuleiro);

        if (repeticoes.isEmpty()) {
            System.out.println("\n[*] ===== Sem repetições");
            return;
        }

        System.out.println("\n[*] ===== Repetições");
        for (Repetição repeticao : repeticoes) {
            int posX = repeticao.pIncidencia.getPosX() + 1;
            int posY = repeticao.pIncidencia.getPosY() + 1;
            int pos2X = repeticao.SIncidencia.getPosX() + 1;
            int pos2Y = repeticao.SIncidencia.getPosY() + 1;
            System.out.println("A posição (" + posY + "," + posX + ") repete com (" + pos2Y + "," + pos2X + ")");
        }
        System.out.println("[*] ===== Fim das repetições");
    }

    private void exibirDicas(Scanner teclado) {
        System.out.println("[*] Digite a(s) posição(ões):");
        teclado = new Scanner(System.in);
        String[] entradasTexto = teclado.nextLine().replace("(", "").split("\\)");

        for (String textoEntrada : entradasTexto) {
            String[] entradas = textoEntrada.split(",");
            int lin = Integer.parseInt(entradas[0]) - 1;
            int col = Integer.parseInt(entradas[1]) - 1;
            Entrada novaEntrada = new Entrada(lin, col);

            List<Integer> valoresPossiveis = TableChecker.Dicas(tabuleiro, novaEntrada);
            System.out.print("Para a posição (" + (lin + 1) + "," + (col + 1) + ") os valores [");
            for (int valor : valoresPossiveis) {
                System.out.print(valor + " ");
            }
            System.out.println("] são válidos.");
        }
    }
}
