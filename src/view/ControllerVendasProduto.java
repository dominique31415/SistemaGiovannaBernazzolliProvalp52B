/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.GdcbVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos
 */
public class ControllerVendasProduto extends AbstractTableModel {

    private List lstGdcbVendasProdutos;

    public void setList(List lstGdcbVendasProdutos) {
        this.lstGdcbVendasProdutos = lstGdcbVendasProdutos;

        this.fireTableDataChanged();
    }

    public GdcbVendasProdutos getBean(int rowIndex) {
        return (GdcbVendasProdutos) lstGdcbVendasProdutos.get(rowIndex);
    }

    public void addBean(GdcbVendasProdutos vendasProdutos) {
        lstGdcbVendasProdutos.add(vendasProdutos);
        this.fireTableDataChanged();
    }

    public void removeBean(int rowIndex) {
        lstGdcbVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstGdcbVendasProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    GdcbVendasProdutos vendasProdutos = (GdcbVendasProdutos) lstGdcbVendasProdutos.get(rowIndex);
    if (columnIndex == 0) {
        return vendasProdutos.getGdcbProdutos().getGdcbIdprodutos();
    } else if (columnIndex == 1) {
        return vendasProdutos.getGdcbProdutos().getGdcbNomeProduto();
    } else if (columnIndex == 2) {
        return vendasProdutos.getGdcbQuantidade();
    } else if (columnIndex == 3) {
        return vendasProdutos.getGdcbValorUnitario();
    } else if (columnIndex == 4) {
        return vendasProdutos.getGdcbValorUnitario() * vendasProdutos.getGdcbQuantidade();
    }
    return "";
}

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Produto";
        } else if (columnIndex == 2) {
            return "Quantidade";
        } else if (columnIndex == 3) {
            return "Valor Unitário";
        } else if (columnIndex == 4) {
            return "Total";
        }
        return "";
    }
}
