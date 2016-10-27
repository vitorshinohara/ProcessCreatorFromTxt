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
    private LinkedList<Integer> listaES = new LinkedList<Integer>();

    public Processo(int id, int duracao, int prioridade, Estado estado, int tempo, LinkedList<Integer> listaES) {
        this.id = id;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.estado = estado;
        this.tempo = tempo;
        this.listaES = listaES;
    }

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

    public LinkedList<Integer> getListaES() {
        return listaES;
    }

    public void setListaES(LinkedList<Integer> listaES) {
        this.listaES = listaES;
    }

    @Override
    public String toString() {
        return "Processo[" + "ID:" + id + ", Duração:" + duracao + ", Prioridade:" + prioridade + ", Estado:" + estado + ", Tempo:" + tempo + ", Lista de Entrada/Saída:" + listaES + ']';
    }
}
