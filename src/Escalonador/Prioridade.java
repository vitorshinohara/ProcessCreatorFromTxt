
package Escalonador;

import Processos.Processo;
import Processos.Tipo;
import java.util.LinkedList;

/**
 *
 * @author elivelton
 */
public class Prioridade {
    LinkedList<Processo> listaProcesso = null;
    LinkedList<Processo> listaPronto = new LinkedList();
    LinkedList<Processo> listaBloqueado = new LinkedList();
    private boolean flag = false;
    int tempo = 0;

    public void inicializar(LinkedList<Processo> listaProcesso){
        this.listaProcesso = listaProcesso;
        escalonar();
    }
    
    public void escalonar() {
        Processo processo = null;

        do {         
            verificaListaProcessos();
            if(flag){
                processo = prioridade();
                flag = false;
            }
            
            while (!flag) {                
                executar(processo);
                tempo++;
            }

            tempo++;
        } while (!(listaProcesso.isEmpty() && listaPronto.isEmpty()));
    }
    
    public Processo prioridade() {
        Processo p = listaPronto.get(0);
        int maior = listaPronto.get(0).getPrioridade();

        for (int i = 0; i < this.listaPronto.size(); i++) {
            if (listaPronto.get(i).getPrioridade() < p.getPrioridade()) {
                maior = listaPronto.get(i).getDuracao();
                p = listaPronto.get(i);
            }
        }

        return p;
    }

    public void executar(Processo p) {
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
            flag = false;
            p.setDuracao(p.getDuracao() - 1);
            if (p.getDuracao() == 0) {
                listaPronto.remove(p);
                System.out.println("[Término] Processo " + p.getId());
                flag = true;
            }
        }
    }

    public void verificaListaProcessos() {
        if (!listaProcesso.isEmpty()) {
            if (listaProcesso.getFirst().getTempo() == tempo) {
                listaPronto.add(listaProcesso.getFirst());
                System.out.println("[Chegada] Processo " + listaProcesso.getFirst().getId());
                listaProcesso.removeFirst();
                flag = true;
            }
        }
    }
}