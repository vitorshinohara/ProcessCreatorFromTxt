/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processos;

import java.util.LinkedList;

/**
 *
 * @author a1711199
 */
public class Processo {
    
    private int id;
    private int duracao;
    private int prioridade;
    private Estado estado;
    private int tempo;
    private LinkedList<Integer> linkedList = new LinkedList<Integer>();

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

}
