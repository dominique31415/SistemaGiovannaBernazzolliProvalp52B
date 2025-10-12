/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.GdcbVenda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dominique
 */
public class ControllerVendas extends AbstractTableModel{
     private List lstGdcbVendas;

    public void setList(List lstGdcbVendas) {
        this.lstGdcbVendas = lstGdcbVendas;
    }
    
    public GdcbVenda getBean(int rowIndex) {
        return (GdcbVenda) lstGdcbVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstGdcbVendas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbVenda venda = (GdcbVenda) lstGdcbVendas.get(rowIndex);
        if (columnIndex == 0) {
            return venda.getGdcbIdVenda();
        } else if (columnIndex == 1) {
            return venda.getGdcbCliente() != null ? venda.getGdcbCliente().getGdcbNome() : "";
        } else if (columnIndex == 2) {
            return venda.getGdcbFuncionario() != null ? venda.getGdcbFuncionario().getGdcbNomeFuncionario() : "";
        } else if (columnIndex == 3) {
            return venda.getGdcbDataVenda();
        } else if (columnIndex == 4) {
            return venda.getGdcbValorTotal();
        } else if (columnIndex == 5) {
            return venda.getGdcbAtivo() == 'S' ? "Ativa" : "Cancelada";
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Cliente";
        } else if (columnIndex == 2) {
            return "Vendedor";
        } else if (columnIndex == 3) {
            return "Data Venda";
        } else if (columnIndex == 4) {
            return "Valor Total";
        } else if (columnIndex == 5) {
            return "Status";
        }
        return "";
    }
}
