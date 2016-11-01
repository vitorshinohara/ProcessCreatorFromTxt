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
        if (p.getTipo() == Tipo.Sistema) {
            for (int i = listaBloqueado.size(); i > 0; i--) {
                listaPronto.add(listaBloqueado.getFirst());
                listaBloqueado.removeFirst();
            }
        }

        if (!p.getListaES().isEmpty()) {
            if (tempo == p.getListaES().getFirst()) {
                listaBloqueado.add(p);
                listaPronto.remove(p);
            }
        }

        if (p.getDuracao() > 0) {
            flag = true;
            p.setDuracao(p.getDuracao() - 1);
            if (p.getDuracao() == 0) {
                listaPronto.remove(p);
                System.out.println("[Término] Processo " + p.getId());
                flag = false;
            }
        }
    }
}
