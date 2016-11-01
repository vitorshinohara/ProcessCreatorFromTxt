package GerenciarArquivo;

import Processos.Estado;
import Processos.Processo;
import Processos.Tipo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manipular {

    LinkedList<Processo> listaProcessos = new LinkedList();

    public void lerArquivo() {
        String linha;                                                           // Cria variável para armazenar a linha do arquivo a ser lido
        String id;
        String duracao;
        String prioridade;
        String tempo;

        try {
            FileReader reader = new FileReader("teste.txt");
            BufferedReader leitor = new BufferedReader(reader);
            StringTokenizer st = null;

            while ((linha = leitor.readLine()) != null) {
                st = new StringTokenizer(linha, " ");                           // Define token de separação.
                id = st.nextToken();                                            // Pega o ID e armazena na variável
                duracao = st.nextToken();                                       // Pega a duração e armazena na variável
                prioridade = st.nextToken();                                    // Pega a prioridade e armazena na variável
                tempo = st.nextToken();                                         // Pega o tempo de chegada e armazena na variável

                LinkedList<Integer> listaES = new LinkedList();        // Cria a lista de Entrada e Saída.

                while (st.hasMoreTokens()) {
                    listaES.add(Integer.parseInt(st.nextToken()));              // Caso exista, adiciona os elementos na lista de Entrada e Saída
                }

                criaProcesso(id, duracao, prioridade, tempo, listaES);          // Cria o processo e adiciona na lista
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Manipular.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.sort(listaProcessos); // Ordena a lista por ordem de chegada

    }

    public void criaProcesso(String idStr, String duracaoStr, String prioridadeStr, String tempoStr, LinkedList<Integer> lista) {
        int id = Integer.parseInt(idStr);                                       // Faz as conversões
        int duracao = Integer.parseInt(duracaoStr);
        int prioridade = Integer.parseInt(prioridadeStr);
        int tempo = Integer.parseInt(tempoStr);
        Tipo tipo = Tipo.Usuario;
        Processo p = new Processo(id, duracao, prioridade, Estado.Pronto, tempo, lista, tipo);
        this.listaProcessos.add(p);
    }

    public LinkedList<Processo> getLinkedList() {
        return this.listaProcessos;
    }
}
