/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku.Controladores;

import com.mycompany.sudoku.Modelos.Entrada;
import com.mycompany.sudoku.Modelos.Repetição;
import com.mycompany.sudoku.Modelos.TableSquare;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author migue
 */

public class TableChecker {
    private static HashSet<Repetição> incidenciasLaterais(Tabuleiro Tabuleiro, Entrada entrada){
        int posX = entrada.getPosX();
        int posY = entrada.getPosY();
        int valor = entrada.getValor();
        HashSet<Repetição> incidencias = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            // Verificação horizontal (linha fixa, coluna variando)
            if (i != posX) {  // Evita comparar a própria posição
                int valorCasaHorizontal = Tabuleiro.getSquareValue(i,posY);
                if (valorCasaHorizontal == valor && valor != 0) {
                    Entrada IncidenciaHorizontal = new Entrada(i, posY, valor);
                    Repetição repeticao = new Repetição(entrada, IncidenciaHorizontal);
                    incidencias.add(repeticao);
                }
            }

            // Verificação vertical (coluna fixa, linha variando)
            if (i != posY) {  // Evita comparar a própria posição
                int valorCasaVertical = Tabuleiro.getSquareValue(posX,i);
                if (valorCasaVertical == valor && valor != 0) {
                    Entrada IncidenciaVertical = new Entrada(posX, i, valor);
                    Repetição repeticao = new Repetição(entrada, IncidenciaVertical);
                    incidencias.add(repeticao);
                }
            }
        }
        return incidencias;
    }
    private static HashSet<Repetição> incidenciasQuadrante(Tabuleiro tabuleiro, Entrada entrada) {  
        HashSet<Repetição> incidencias = new HashSet<>();
        int linhaQuadrante = (entrada.getPosX() / 3) * 3;
        int colunaQuadrante =(entrada.getPosY() / 3) * 3;
        for (int i = 0  ; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int linhaAtual = linhaQuadrante + i;
                int colunaAtual = colunaQuadrante + j;
                int valorCasa = tabuleiro.getSquareValue(linhaAtual, colunaAtual);
                int valorEntrada = entrada.getValor();
                Entrada EntradaQuadrante = new Entrada(linhaAtual,colunaAtual,valorCasa);
                if(valorCasa == valorEntrada && valorCasa !=0 && !entrada.equals(EntradaQuadrante )){
                    Repetição Repetição = new Repetição(entrada,EntradaQuadrante);
                    incidencias.add(Repetição);
                }
            }
        }
        return  incidencias;
    }
    // Método para encontrar a intersecção entre repetições de linhas e quadrantes
    public static HashSet<Repetição> Repetições(Tabuleiro tabuleiro) {
        HashSet<Repetição> incidencias = new HashSet<>();
        HashSet<Repetição> repeticoesLinhas = new HashSet<>();
        HashSet<Repetição> repeticoesQuadrantes = new HashSet<>();
        for(int x =0;x<9;x++){
            for(int y =0;y<9;y++){
                int valor =tabuleiro.getSquareValue(x,y);
                if(valor==0){continue;}
                Entrada entrada = new Entrada(x,y,valor);
                HashSet<Repetição> repeticoesLinha = incidenciasLaterais(tabuleiro,entrada);
                HashSet<Repetição> repeticoesQuadrante = incidenciasQuadrante(tabuleiro,entrada);
                repeticoesLinhas.addAll(repeticoesLinha);
                repeticoesQuadrantes.addAll(repeticoesQuadrante);
            }
        }        
        for (Repetição rep : repeticoesLinhas) {
            boolean repetido = false;
            for (Repetição rep2 : incidencias) {
                if (rep.equals(rep2)) { // Verifica se ainda não foi adicionado
                    repetido=true;
                }
            }
            if(!repetido){
                incidencias.add(rep);
            }
        }
        for (Repetição rep : repeticoesQuadrantes) {
                boolean repetido = false;
                for (Repetição rep2 : incidencias) {
                    if (rep.equals(rep2)) { // Verifica se ainda não foi adicionado
                        repetido=true;
                    }
                }
                if(!repetido){
                    incidencias.add(rep);
                }
        }
        return  incidencias;
    }
   
    public static List<Integer> Dicas(Tabuleiro tabuleiro, Entrada posicao){
            HashSet<Integer> valoresIncidentes = new HashSet<>();
            HashSet<Repetição> repeticoesTotal = new HashSet<>();
            for(int valorTeste = 1; valorTeste<10;valorTeste++){
                Entrada testePosicao = new Entrada(posicao.getPosX(),
                        posicao.getPosY(),
                        valorTeste);
                HashSet<Repetição> repeticoesLinhas = incidenciasLaterais(tabuleiro,testePosicao);
                HashSet<Repetição> repeticoesQuadrantes = incidenciasQuadrante(tabuleiro,testePosicao);
                repeticoesTotal.addAll(repeticoesLinhas);
                repeticoesTotal.addAll(repeticoesQuadrantes);
            }
            for( Repetição valor:repeticoesTotal ){
                valoresIncidentes.add(valor.SIncidencia.getValor());
            }
            List<Integer> valoresPossiveis = new ArrayList<>();
            for(int a = 1; a <= 9; a++) {
                if (!valoresIncidentes.contains(a)) {
                    valoresPossiveis.add(a);
                }
            }
            return valoresPossiveis;
        
    }
    public static boolean checaVitoria(Tabuleiro tabuleiro){
        for(int x =0;x<9;x++){
            for(int y =0;y<9;y++){
                int valor =tabuleiro.getSquareValue(x, y);
                if(valor==0){
                    return false;
                }
            }
        }
       return Repetições(tabuleiro).isEmpty();
    }
}
