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
    public LinkedList<DadosGUI> dados = new LinkedList();
    int quantun;
    int tempo = 0;    

    public LinkedList<DadosGUI> inicializar(LinkedList<Processo> x) {
        this.listaProcesso = x;
        Processo pSistema = new Processo();
        pSistema.setTipo(Tipo.Sistema);
        pSistema.setDuracao(0);
        listaPronto.add(pSistema);
        escalonar(4);

        return dados;
    }

    public void escalonar(int quantun) {
        this.quantun = quantun;
        do {
            verificaListaProcessos();

            if (!listaPronto.isEmpty()) {
                executar();
            } else {
                tempo++;
            }
        } while (listaPronto.size() > 1);
    }

    public void verificaListaProcessos() {
        if (!listaProcesso.isEmpty()) {
            if (listaProcesso.getFirst().getTempo() == tempo) {

                listaPronto.add(listaProcesso.getFirst());
                //System.out.println("[" + tempo + "][Chegada] Processo " + listaProcesso.getFirst().getId());
                dados.add(new DadosGUI(listaProcesso.getFirst().getId(), tempo, "Chegada", listaProcesso.getFirst().getPrioridade(), listaProcesso.getFirst().getDuracao(), "Usuário"));

                listaProcesso.removeFirst();
            }
        }
    }

    private void executar() {
        int i = 0;
        boolean ES = false;

        if (listaPronto.size() > 1) {
            if (listaPronto.getFirst().getTipo().equals(Tipo.Sistema)) {
                executarProcessoSistema();
            }
        }

        while (listaPronto.getFirst().getDuracao() > 0 && i < quantun && listaPronto.getFirst().getTipo().equals(Tipo.Usuario)) {

            for (int j = 0; j < listaPronto.getFirst().getListaES().size(); j++) {
                    if (listaPronto.getFirst().getListaES().get(j) == tempo) {
                        dados.add(new DadosGUI(listaPronto.getFirst().getId(), tempo, "Bloqueado", listaPronto.getFirst().getPrioridade(), listaPronto.getFirst().getDuracao(), "Usuário"));

                        listaPronto.getFirst().getListaES().remove(j);

                        listaBloqueado.add(listaPronto.getFirst());
                        listaPronto.removeFirst();
                        ES = true;
                        break;
                    }
                }
            

            if (ES) {
                ES = false;
                break;
            }

            if (listaPronto.getFirst().getDuracao() == 0) {
                break;
            }

            listaPronto.getFirst().setDuracao(listaPronto.getFirst().getDuracao() - 1);
            i++;
            //System.out.println("[" + tempo + "][Executando] Processo " + listaPronto.getFirst().getId());
            dados.add(new DadosGUI(listaPronto.getFirst().getId(), tempo, "Executando", listaPronto.getFirst().getPrioridade(), listaPronto.getFirst().getDuracao(), "Usuário"));
            tempo++;
            verificaListaProcessos();
        }

        i = 0;

        if (listaPronto.getFirst().getDuracao() == 0 && listaPronto.getFirst().getTipo().equals(Tipo.Usuario)) {
            //System.out.println("[" + tempo + "][Termino] Processo " + listaPronto.getFirst().getId());
            dados.add(new DadosGUI(listaPronto.getFirst().getId(), tempo, "Término", listaPronto.getFirst().getPrioridade(), listaPronto.getFirst().getDuracao(), "Usuário"));

            listaPronto.removeFirst();

        } else {
            listaPronto.addLast(listaPronto.getFirst());
            listaPronto.removeFirst();
        }
    }

    private void executarProcessoSistema() {
        tempo++;
        verificaListaProcessos();
        System.out.println("[" + tempo + "][Executando] Processo do SISTEMA.");
        dados.add(new DadosGUI(this.tempo, "Executando", "Sistema"));

        for (int j = listaBloqueado.size(); j > 0; j--) {
            listaPronto.add(listaBloqueado.getFirst());
            listaBloqueado.removeFirst();
        }

        listaPronto.add(listaPronto.getFirst());
        listaPronto.removeFirst();

        tempo++;
        verificaListaProcessos();
    }
}
