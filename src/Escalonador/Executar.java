/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import Processos.Processo;
import Processos.Tipo;
import java.util.LinkedList;

/**
 *
 * @author elivelton
 */
public class Executar {
    public void executar(Processo p, LinkedList<Processo> listaBloqueado, LinkedList<Processo> listaPronto, int tempo, boolean flag) {
        System.out.println("Entrei!");
        if (p.getTipo().equals(Tipo.Sistema)) {
            if (!listaBloqueado.isEmpty()) {
                for (int i = listaBloqueado.size(); i > 0; i--) {
                    listaPronto.add(listaBloqueado.getFirst());
                    listaBloqueado.removeFirst();
                    System.out.println("Entrei!");
                }
            }
        }

        if (!p.getListaES().isEmpty()) {
            if (tempo == p.getListaES().getFirst()) {
                listaBloqueado.add(p);
                listaPronto.remove(p);
            }
        }

        if (p.getDuracao() > 0) {
            p.setDuracao(p.getDuracao() - 1);
            System.out.println("[" + tempo + "][Executando] Processo " + p.getId());
            if (p.getDuracao() == 0) {
                listaPronto.remove(p);
                System.out.println("[" + (tempo + 1) + "][Término] Processo " + p.getId());
                flag = true;
            }
        }
    }
}
