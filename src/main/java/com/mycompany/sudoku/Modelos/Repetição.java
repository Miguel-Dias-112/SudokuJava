/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku.Modelos;

/**
 *
 * @author migue
 */
public class Repetição{
   public Entrada pIncidencia;
   public Entrada SIncidencia;
   public Repetição(Entrada primeira, Entrada segunda){
       this.pIncidencia=primeira;
       this.SIncidencia=segunda;
   }
  @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se é o mesmo objeto
        if (!(obj instanceof Repetição)) return false; // Verifica o tipo

        Repetição repetição = (Repetição) obj;

        // Comparação simétrica entre as entradas
        return (pIncidencia != null && SIncidencia != null &&
                ((pIncidencia.equals(repetição.pIncidencia) && SIncidencia.equals(repetição.SIncidencia)) ||
                 (pIncidencia.equals(repetição.SIncidencia) && SIncidencia.equals(repetição.pIncidencia))));
    }

@Override
public int hashCode() {
    // Garante consistência com equals, usando uma abordagem simétrica
    int hashP = (pIncidencia != null) ? pIncidencia.hashCode() : 0;
    int hashS = (SIncidencia != null) ? SIncidencia.hashCode() : 0;

    // Soma os hashes e retorna a mesma combinação independentemente da ordem
    return hashP + hashS;
}}