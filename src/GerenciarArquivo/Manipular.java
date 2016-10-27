package GerenciarArquivo;

import Processos.Processo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class Manipular {
 
    public void lerArquivo() {
        try {
            FileReader arq = new FileReader("teste.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            List<Processo> ListaProcesso = new ArrayList();
            Processo processo = null;

            while ((linha = lerArq.readLine()) != null) {
                for(int i=0; i < linha.length(); i++){
                    if(!(",".equals(linha))){

                    }
                }
                ListaProcesso.add(processo);
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }
}