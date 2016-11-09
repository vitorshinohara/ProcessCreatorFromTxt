/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Escalonador.ShortestJobFirst;
import Processos.Processo;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author elivelton
 */
public class TabelaTimeLine extends AbstractTableModel{
    private LinkedList<Processo> linhas = null;
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Processo processo = linhas.get(rowIndex);
        switch(columnIndex){
            case 0:{
                //return tempo
            }
            case 1:{
                //return acao;
            }
            case 2:{
                return processo.getId();
            }
            case 3:{
                return processo.getPrioridade();
            }
            case 4:{
                return processo.getDuracao();
            }
            default:{
                return " ";
            }
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch(coluna) {
            case 0:
                return "Tempo";
            case 1:
                return "Ação";
            case 2:
                return "Processo";
            case 3:
                return "Prioridade";
            case 4:
                return "Tempo Restante";
            default:
                return "";
        }
    }
    
    public void adicionar(Processo p, int algoritmo, LinkedList<Processo> listaProcesso){
        switch(algoritmo){
            case 1:{
                ShortestJobFirst sjf = new ShortestJobFirst();
                sjf.iniciar(listaProcesso);
            }
            case 2:{
                
            }
            case 3:{
                
            }
            case 4:{
                
            }
        }
    }
}
