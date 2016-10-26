/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processos;

/**
 *
 * @author a1711199
 */
public enum Estado {
    Pronto("P"),
    Executando("E"),
    Bloqueado("B");
    String texto;

    private Estado(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
    
    
    
}
