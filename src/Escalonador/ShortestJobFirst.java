package Escalonador;

import Processos.Processo;
import Processos.Tipo;
import java.util.LinkedList;

/**
 *
 * @author vitor
 */
public class ShortestJobFirst {

    private boolean flag = false;
    LinkedList<Processo> listaProcesso = new LinkedList();
    LinkedList<Processo> listaPronto = new LinkedList();
    LinkedList<Processo> listaBloqueado = new LinkedList();
    int tempo = 0;
    Processo pSistema = new Processo();

    public void iniciar(LinkedList<Processo> listaProcesso) {
        this.listaProcesso = listaProcesso; // Lista de processos retirados do arquivo ordenados por ordem de chegada.
        pSistema.setTipo(Tipo.Sistema);
        escalonar();
    }

    public void escalonar() {
        Processo p_Executar;

        do {

            verificaListaProcessos();
            if(flag == false && tempo %10 == 0){
                executar(pSistema);
            }
            
            if (flag == false) {
                if (!listaPronto.isEmpty()) {
                    p_Executar = ShortestJob();
                    flag = true;

                    while (flag) {
                        System.out.println("[" + tempo + "] [Executando] processo " + p_Executar.getId());
                        executar(p_Executar);
                        tempo++;
                        verificaListaProcessos();
                    }
                }
            }

            tempo++;
        } while (!(listaProcesso.isEmpty() && listaPronto.isEmpty()));
        System.out.println("Fim do while");

    }

    public Processo ShortestJob() {
        Processo p = listaPronto.getFirst();

        for (int i = 0; i < listaPronto.size(); i++) {
            if (listaPronto.get(i).getDuracao() < p.getDuracao()) {
                p = listaPronto.get(i);
            }
        }

        return p;
    }

    public void verificaListaProcessos() {
        if (!listaProcesso.isEmpty()) {
            if (listaProcesso.getFirst().getTempo() == tempo) {

                listaPronto.add(listaProcesso.getFirst());
                System.out.println("[" + tempo + "][Chegada] Processo " + listaProcesso.getFirst().getId());
                listaProcesso.removeFirst();

            }
        }
    }

    public void executar(Processo p) {

        if (p.getTipo().equals(Tipo.Sistema)) {
            System.out.println("["+tempo+"][SISTEMA] Executando processo do sistema");
            if (!listaBloqueado.isEmpty()) {
                for (int i = listaBloqueado.size(); i > 0; i--) {
                    listaPronto.add(listaBloqueado.getFirst());
                    listaBloqueado.removeFirst();
                }
            }

        } else if (!p.getListaES().isEmpty()) {
            if (tempo == p.getListaES().getFirst()) {
                listaBloqueado.add(p);
                listaPronto.remove(p);
            }
        } else if (p.getDuracao() > 0) {
            p.setDuracao(p.getDuracao() - 1);

            if (p.getDuracao() == 0) {
                System.out.println("[" + tempo + "] [Termino] Processo " + p.getId());
                listaPronto.remove(p);
                flag = false;
            }
        }

    }
}
