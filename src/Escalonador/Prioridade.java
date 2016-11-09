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
    private boolean flag = true;
    int tempo = 0;

    public void inicializar(LinkedList<Processo> listaProcesso) {
        this.listaProcesso = listaProcesso;
        escalonar();
    }

    public void escalonar() {
        Processo processo = null;
        do {
            verificaListaProcessos();
            if (flag) {
                processo = prioridade();
                if (processo != null) {
                    flag = false;
                }

            }

            while (!flag) {
                if (processo != null) {
                    executar(processo);
                    tempo++;
                }
                verificaListaProcessos();
            }

            tempo++;
        } while (!(listaProcesso.isEmpty() && listaPronto.isEmpty()));
        System.out.println("Fim do while");
    }

    public Processo prioridade() {

        if (!listaPronto.isEmpty()) {
            Processo p = listaPronto.get(0);

            for (int i = 0; i < this.listaPronto.size(); i++) {
                if (listaPronto.get(i).getPrioridade() <= p.getPrioridade()) {
                    p = listaPronto.get(i);
                }
            }

            return p;
        } else {
            return null;
        }
    }

    public void executar(Processo p) {
        if (p.getTipo().equals(Tipo.Sistema)) {

            tempo++;
            verificaListaProcessos();
            System.out.println("[" + tempo + "][Executando] Processo do SISTEMA.");
            DadosGUI dados = new DadosGUI(this.tempo,"Executando","Sistema");
            
            if (!listaBloqueado.isEmpty()) {
                for (int i = listaBloqueado.size(); i > 0; i--) {
                    listaPronto.add(listaBloqueado.getFirst());
                    listaBloqueado.removeFirst();
                    flag = true;
                }

                tempo++;
                verificaListaProcessos();
            }

        } else if (!p.getListaES().isEmpty()) {
            for (int i = 0; i < p.getListaES().size(); i++) {
                if (tempo == p.getListaES().get(i)) {
                    System.out.println("[" + tempo + "] [Bloqueado] Processo " + p.getId());
                    
                    listaBloqueado.add(p);
                    listaPronto.remove(p);
                    flag = true;
                    p.getListaES().remove(i);
                }
            }

        } else if (p.getDuracao() > 0) {
            p.setDuracao(p.getDuracao() - 1);
            System.out.println("[" + tempo + "][Executando] Processo " + p.getId());
            DadosGUI dados = new DadosGUI(p.getId(),tempo,"Executando",p.getPrioridade(),p.getDuracao(),"Usuário");
            if (p.getDuracao() == 0) {
                listaPronto.remove(p);
                
                System.out.println("[" + (tempo + 1) + "][Término] Processo " + p.getId());
                DadosGUI dadosGUI = new DadosGUI(p.getId(),tempo,"Término",p.getPrioridade(),p.getDuracao(),"Usuário");
                
                flag = true;
            }
        }
    }

    public void verificaListaProcessos() {
        if (!listaProcesso.isEmpty()) {
            if (listaProcesso.getFirst().getTempo() == tempo) {
                listaPronto.add(listaProcesso.getFirst());
                System.out.println("[" + tempo + "][Chegada] Processo " + listaProcesso.getFirst().getId());
                DadosGUI dadosGUI = new DadosGUI(listaProcesso.getFirst().getId(),tempo,"Chegada",listaProcesso.getFirst().getPrioridade(),listaProcesso.getFirst().getDuracao(),"Usuário");
                listaProcesso.removeFirst();
                flag = true;
            }
        }
    }
}
