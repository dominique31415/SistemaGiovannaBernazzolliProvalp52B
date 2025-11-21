package view;

import bean.GdcbVenda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerVendas extends AbstractTableModel {
    private List<GdcbVenda> lstVendas; 

    public void setList(List<GdcbVenda> lstVendas) {
        this.lstVendas = lstVendas;
        fireTableDataChanged();
    }
    
    public GdcbVenda getBean(int rowIndex) {
        return lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas == null ? 0 : lstVendas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (lstVendas == null || lstVendas.isEmpty()) {
            return "";
        }
        
        GdcbVenda venda = lstVendas.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return venda.getGdcbIdVenda();
            case 1:
                return venda.getGdcbCliente() != null ? 
                       venda.getGdcbCliente().getGdcbNome() : "";
            case 2:
                return venda.getGdcbFuncionario() != null ? 
                       venda.getGdcbFuncionario().getGdcbNomeFuncionario() : "";
            case 3:
                return venda.getGdcbQuantidade();
            case 4:
                return venda.getGdcbValorTotal();
            case 5:
                return venda.getGdcbDataVenda();
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
                return "Cliente";
            case 2:
                return "Vendedor";
            case 3:
                return "Quantidade";
            case 4:
                return "Valor Total";
            case 5:
                return "Data Venda";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 3:
                return Integer.class;
            case 1:
            case 2:
                return String.class;
            case 4:
                return java.math.BigDecimal.class;
            case 5:
                return java.util.Date.class;
            default:
                return Object.class;
        }
    }
}