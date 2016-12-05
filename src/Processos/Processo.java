package Processos;

import java.util.LinkedList;


/**
 *
 * @author a1711199
 */
public class Processo implements Comparable<Processo> {

    private int id;
    private int duracao;
    private int prioridade;
    private Estado estado;
    private int tempo;
    private Tipo tipo;
    private LinkedList<Integer> listaES = new LinkedList();
    private String caminhoArquivo;
    private int tempoExecucao = 0;

    public Processo(int id, int duracao, int prioridade, Estado estado, int tempo, LinkedList<Integer> listaES, Tipo tipo) {
        this.id = id;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.estado = estado;
        this.tempo = tempo;
        this.listaES = listaES;
        this.tipo = tipo;
    }

    public Processo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
    
    public Processo(){
    
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
    
    
    
    @Override
    public String toString() {
        return "Processo[" + "ID:" + id + ", Duracao:" + duracao + ", Prioridade:" + prioridade + ", Estado:" + estado + ", Tempo:" + tempo + ", Tipo:" + tipo + ", Lista de Entrada e Saída:" + listaES + ']';
    }

    public int compareTo(Processo p) {
        if (this.tempo > p.tempo) {
            return 1;
        }
        if (this.tempo < p.tempo) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

}
