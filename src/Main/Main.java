/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GerenciarArquivo.Manipular;
import GerenciarArquivo.TempoTotal;

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
        TempoTotal  calculaTempoTotal = new TempoTotal(manipular.getLinkedList());
    }
    
}
