/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import Processos.Processo;
import java.util.LinkedList;

/**
 *
 * @author vitor
 */
public class ShortestJobFirst {
    
    LinkedList<Processo> listaPronto = null;
    LinkedList<Processo> listaBloqueado = new LinkedList<Processo>();
    int tempo = 0;
    

    public void inicializar(LinkedList<Processo> listaProcesso){
        this.listaPronto = listaProcesso;
    }
    
    
    
}
