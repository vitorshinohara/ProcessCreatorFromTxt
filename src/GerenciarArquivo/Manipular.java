package GerenciarArquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
 
public class Manipular {
 
  public void lerArquivo() {

    try {
      FileReader arq = new FileReader("teste.txt");
      
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
      
      int id;

      while (linha != null) {
        System.out.printf("%s\n", linha);
 
        linha = lerArq.readLine(); // lê da segunda até a última linha
        
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
  }
}