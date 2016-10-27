/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import Processos.Processo;
import java.util.LinkedList;

/**
 *
 * @author vitor
 */
public class ShortestJobFirst extends Thread {

    Thread x;

    LinkedList<Processo> listaPronto = null;
    LinkedList<Processo> listaBloqueado = new LinkedList<>();
    int tempo = 0;

    public void inicializar(LinkedList<Processo> listaProcesso) {
        this.listaPronto = listaProcesso;
    }

    public void escalonar() {
        for (int i = 0; i < 10; i++) {

        }
    }

    public Processo menorTempoExecucao() {
        Processo p = null;

        for (int i = 0; i < this.listaPronto.size(); i++) {
            if (listaPronto.get(i).getDuracao() < p.getDuracao() && listaPronto.get(i).getTempo() <= tempo) {
                p = listaPronto.get(i);
            }
        }

        return p;
    }

    public void run() {
        do {
            this.tempo++;
            System.out.println(tempo);

        } while (true);

    }

    public void start() {
        if (x == null) {
            x = new Thread(x);
            x.start();
        }
        System.out.println("Start");
    }
}
