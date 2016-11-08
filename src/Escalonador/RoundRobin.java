package Escalonador;

import Processos.Processo;
import Processos.Tipo;
import java.util.LinkedList;

/**
 *
 * @author vitor
 */
public class RoundRobin {

    LinkedList<Processo> listaPronto = new LinkedList();
    LinkedList<Processo> listaBloqueado = new LinkedList();
    LinkedList<Processo> listaProcesso = new LinkedList();
    int quantun;
    int tempo = 0;

    public void inicializar(LinkedList<Processo> x) {
        this.listaProcesso = x;
        Processo pSistema = new Processo();
        pSistema.setTipo(Tipo.Sistema);

    }

    public void escalonar(int quantun) {
        this.quantun = quantun;
        do {
            verificaListaProcessos();

            if (!listaPronto.isEmpty()) {
                executar();
            }

        } while (!(listaProcesso.isEmpty() && listaPronto.isEmpty()));

    }

    public void verificaListaProcessos() {
        if (!listaProcesso.isEmpty()) {
            if (listaProcesso.getFirst().getTempo() == tempo) {

                listaPronto.add(listaProcesso.getFirst());
                System.out.println("[Chegada] Processo " + listaProcesso.getFirst().getId());
                listaProcesso.removeFirst();

            }
        }
    }

    public void executar() {
        int i = 0;
        if (listaPronto.getFirst().getTipo().equals(Tipo.Sistema)) {
            for (int j = listaBloqueado.size(); j > 0; j--) {
                listaPronto.add(listaBloqueado.getFirst());
                listaBloqueado.removeFirst();
            }
        }

        while (listaPronto.getFirst().getTempo() > 0 && i < quantun) {

            if (!listaPronto.getFirst().getListaES().isEmpty()) {
                if (listaPronto.getFirst().getListaES().getFirst() == tempo) {
                    listaBloqueado.add(listaPronto.getFirst());
                    listaPronto.removeFirst();
                    break;
                }
            }

            listaPronto.getFirst().setDuracao(listaPronto.getFirst().getDuracao() - 1);
            tempo++;
            i++;
            verificaListaProcessos();

        }
        i = 0;
        if (listaPronto.getFirst().getDuracao() <= 0) {
            listaPronto.removeFirst();
        } else {
            listaPronto.addLast(listaPronto.getFirst());
            listaPronto.removeFirst();
        }
    }

    public void bloquear(Processo p) {
        listaBloqueado.add(p);
        listaPronto.remove(p);
        p.getListaES().remove(p.getListaES().getFirst());
    }
}
