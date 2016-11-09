package Main;

import Escalonador.Prioridade;
import Escalonador.RoundRobin;
import Escalonador.ShortestJobFirst;
import GerenciarArquivo.Manipular;

/**
 *
 * @author a1711199
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manipular manipular = new Manipular();
        manipular.lerArquivo();
        //TempoTotal tempoTotal = new TempoTotal(manipular.getLinkedList());

//        ShortestJobFirst sjf = new ShortestJobFirst();
//        sjf.iniciar(manipular.getLinkedList());

//        Prioridade prio = new Prioridade();
//        prio.inicializar(manipular.getLinkedList());

        RoundRobin rr = new RoundRobin();
        rr.inicializar(manipular.getLinkedList());
    }
}
