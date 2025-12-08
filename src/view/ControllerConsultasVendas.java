/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.GdcbVenda;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author 
 */
public class ControllerConsultasVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
        
    }
    
    public GdcbVenda getBean(int rowIndex) {
        return (GdcbVenda) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbVenda venda = (GdcbVenda) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return venda.getGdcbIdVenda();
        } else if (columnIndex ==1) {
            return venda.getGdcbCliente();        
        } else if (columnIndex ==2) {
            return venda.getGdcbFuncionario();
        } else if (columnIndex ==4) {
            return venda.getGdcbValorTotal();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome Cliente";         
        } else if ( columnIndex == 2) {
            return "Nome Funcionário";
        } else if ( columnIndex == 3) {
            return "Valor Total";
        } 
        return "";
    }
}
