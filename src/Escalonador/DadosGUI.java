/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

/**
 *
 * @author vitor
 */
public class DadosGUI {
    private int idProcesso;
    private int tempo;
    private String acao;
    private int prioridade;
    private int tempoRestante;
    private String tipo;

    public DadosGUI(int idProcesso, int tempo, String acao, int prioridade, int tempoRestante, String tipo) {
        this.idProcesso = idProcesso;
        this.tempo = tempo;
        this.acao = acao;
        this.prioridade = prioridade;
        this.tempoRestante = tempoRestante;
        this.tipo = tipo;
    }

    public DadosGUI(int tempo, String acao, String tipo) {
        this.tempo = tempo;
        this.acao = acao;
        this.tipo = tipo;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public int getTempo() {
        return tempo;
    }

    public String getAcao() {
        return acao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}