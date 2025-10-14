package view;

import bean.GdcbVenda;
import bean.GdcbVendasProdutos; 
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dominique
 */
public class ControllerVendas extends AbstractTableModel {
    private List<GdcbVendasProdutos> lstItensVenda; 

    public void setList(List<GdcbVendasProdutos> lstItensVenda) {
        this.lstItensVenda = lstItensVenda;
        fireTableDataChanged();
    }
    
    public GdcbVendasProdutos getBean(int rowIndex) {
        return lstItensVenda.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstItensVenda == null ? 0 : lstItensVenda.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (lstItensVenda == null || lstItensVenda.isEmpty()) {
            return "";
        }
        
        GdcbVendasProdutos itemVenda = lstItensVenda.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return itemVenda.getGdcbVenda() != null ? 
                       itemVenda.getGdcbVenda().getGdcbIdVenda() : "";
            case 1:
                return itemVenda.getGdcbProdutos() != null ? 
                       itemVenda.getGdcbProdutos().getGdcbNomeProduto() : "";
            case 2:
                return itemVenda.getGdcbVenda() != null && 
                       itemVenda.getGdcbVenda().getGdcbFuncionario() != null ? 
                       itemVenda.getGdcbVenda().getGdcbFuncionario().getGdcbNomeFuncionario() : "";
            case 3:
                return itemVenda.getGdcbQuantidade();
            case 4:
                return itemVenda.getGdcbValorTotal();
            case 5:
                return itemVenda.getGdcbDesconto();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Código Venda";
            case 1:
                return "Produto";
            case 2:
                return "Vendedor";
            case 3:
                return "Quantidade";
            case 4:
                return "Valor Total";
            case 5:
                return "Desconto";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
            case 2:
                return String.class;
            case 3:
                return Integer.class; 
            case 4:
            case 5:
                return java.math.BigDecimal.class;
            default:
                return Object.class;
        }
    }
}