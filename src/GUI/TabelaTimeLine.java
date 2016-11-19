/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Escalonador.DadosGUI;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author elivelton
 */
public class TabelaTimeLine extends AbstractTableModel{
    private LinkedList<DadosGUI> linhas = new LinkedList();
    private int qtdLinhas = 0;
    
    public void TabelaTimeLine(LinkedList<DadosGUI> dados){
        qtdLinhas = dados.size();
        adicionar(dados);
    }

    @Override
    public int getRowCount() {
        return qtdLinhas;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DadosGUI processo = linhas.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return processo.getTempo();
            }
            case 1:{
                return processo.getTipo();
            }
            case 2:{
                return processo.getAcao();
            }
            case 3:{
                return processo.getIdProcesso();
            }
            case 4:{
                return processo.getPrioridade();
            }
            case 5:{
                return processo.getTempoRestante();
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
                return "Tipo Processo";
            case 2:
                return "Ação";
            case 3:
                return "Processo";
            case 4:
                return "Prioridade";
            case 5:
                return "Tempo Restante";
            default:
                return "";
        }
    }

    public void adicionar(LinkedList<DadosGUI> dados){
        fireTableRowsUpdated(0, dados.size());
        for(int i=0; i < dados.size(); i++){
            linhas.add(dados.get(i));

            fireTableRowsInserted(linhas.size()-1, linhas.size()-1);
            fireTableRowsUpdated(linhas.size()-1, linhas.size()-1);
        }
        
    }
}