package view;

import bean.GdcbVenda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

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
        if (lstVendas == null) {
            return 0;
        }
        return lstVendas.size();
    }

    @Override
    public int getColumnCount() {
        return 4; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbVenda venda = (GdcbVenda) lstVendas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return venda.getGdcbIdVenda();
            case 1:
                return venda.getGdcbCliente();
            case 2:
                return venda.getGdcbFuncionario();
            case 3:
                return venda.getGdcbValorTotal();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Código";
            case 1:
                return "Nome Cliente";
            case 2:
                return "Nome Funcionário";
            case 3:
                return "Valor Total";
            default:
                return "";
        }
    }
}