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
        return lstGdcbVendas == null ? 0 : lstGdcbVendas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbVenda venda = (GdcbVenda) lstGdcbVendas.get(rowIndex);
        if (columnIndex == 0) {
            return venda.getGdcbIdItemVenda();
        } else if (columnIndex == 1) {
            return venda.getGdcbProdutos() != null ? venda.getGdcbProdutos().getGdcbNomeProduto() : "";
        } else if (columnIndex == 2) {
            return venda.getGdcbVenda()!= null ? venda.getGdcbVenda().getGdcbVenda() : "";
        } else if (columnIndex == 3) {
            return venda.getGdcbQuantidade();
        } else if (columnIndex == 4) {
            return venda.getGdcbValorTotal();
        } else if (columnIndex == 5) {
            return venda.getGdcbDesconto(); 
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Produto:";
        } else if (columnIndex == 2) {
            return "Vendedor";
        } else if (columnIndex == 3) {
            return "Quant:";
        } else if (columnIndex == 4) {
            return "Valor Total";
        } else if (columnIndex == 5) {
            return "Desconto"; 
        }
        return "";
    }
}