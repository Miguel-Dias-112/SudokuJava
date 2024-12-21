/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author migue
 */
class Repeticao{
   Insertions pIncidencia;
   Insertions SIncidencia;
   Repeticao(Insertions primeira, Insertions segunda){
       this.pIncidencia=primeira;
       this.SIncidencia=segunda;
   }
}
public class TableChecker {
   
    private List<Repeticao> checaLateral( TableSquare[][] Tabuleiro){
        List<Repeticao> incidencias= new ArrayList();
        for(int coluna=0;coluna<9;coluna++){
            for(int linhaPivo=0; linhaPivo<9;linhaPivo++){
                int valorLinha = Tabuleiro[linhaPivo][coluna].getValor();
                int valorColuna = Tabuleiro[coluna][linhaPivo].getValor();
                for(int linha=linhaPivo+1; linha<9;linha++){
                    int valorLinhaPivo = Tabuleiro[linha][coluna].getValor();
                    int valorColunaPivo = Tabuleiro[coluna][linha].getValor();
                    if(linhaPivo!=linha && valorLinha!=0 && valorLinha==valorLinhaPivo){
                        Insertions posição = new Insertions(linha,coluna);
                        Insertions posiçãoSegunda = new Insertions(linhaPivo,coluna);
                        Repeticao repetição = new Repeticao(posição,posiçãoSegunda);
                        incidencias.add(repetição);
                    }
                    if(linhaPivo!=linha && valorColuna!=0 && valorColuna==valorColunaPivo){
                        Insertions posição = new Insertions(linha,coluna);
                        Insertions posiçãoSegunda = new Insertions(linhaPivo,coluna);
                        Repeticao repetição = new Repeticao(posição,posiçãoSegunda);
                        incidencias.add(repetição);
                    }
                }
            }
        }
        
        return incidencias;
    }    
    private List<Repeticao> checaQuadrantes(TableSquare[][] tabuleiro) {
        List<Repeticao> incidencias = new ArrayList<>();

            // Percorre os quadrantes 3x3
            for (int linhaInicio = 0; linhaInicio < 9; linhaInicio += 3) {
                for (int colunaInicio = 0; colunaInicio < 9; colunaInicio += 3) {
                    List<Repeticao> quadranteIncidencias = checaQuadrante(tabuleiro, linhaInicio, colunaInicio);
                    incidencias.addAll(quadranteIncidencias);
                }
            }

            return incidencias;
    }
    private List<Repeticao> checaQuadrante(TableSquare[][] tabuleiro, int linhaInicio, int colunaInicio) {
        List<Repeticao> incidencias = new ArrayList<>();
        boolean[] numeros = new boolean[10]; // Para rastrear números de 1 a 9
        Insertions[] posicoes = new Insertions[10]; // Para guardar a posição do número

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int linhaAtual = linhaInicio + i;
                int colunaAtual = colunaInicio + j;
                int valor = tabuleiro[linhaAtual][colunaAtual].getValor();

                if (valor != 0) {
                    if (numeros[valor]) {
                        // Repeticao detectada
                        incidencias.add(new Repeticao(posicoes[valor], new Insertions(linhaAtual, colunaAtual)));
                    } else {
                        numeros[valor] = true;
                        posicoes[valor] = new Insertions(linhaAtual, colunaAtual);
                    }
                }
            }
        }

        return incidencias;
    }
    // Método para encontrar a intersecção entre repetições de linhas e quadrantes
    public List<Repeticao> imprimeRepetições(TableSquare[][] tabuleiro) {
        List<Repeticao> repeticoesLinhas = checaLateral(tabuleiro);
        List<Repeticao> repeticoesQuadrantes = checaQuadrantes(tabuleiro);
        List<Repeticao> intersecao = new ArrayList<>();
        Set<String> verificados = new HashSet<>(); // Para garantir que não haja repetições na intersecção

      
          System.out.println("[*]=====Repeticoes");

        for(Repeticao repeticao : repeticoesLinhas){
            int posX=repeticao.pIncidencia.posX;
            int posY=repeticao.pIncidencia.posY;
            int pos2X=repeticao.SIncidencia.posX;
            int pos2Y=repeticao.SIncidencia.posY;
            System.out.println("A posicao ("+posX+","+posY+") repete com ("+pos2X+","+pos2Y+")");
        }
          System.out.println("[*]=====Repeticoes");

        return intersecao;
    }
}
