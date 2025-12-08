/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.GdcbCliente;
import bean.GdcbCliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author 
 */
public class ControllerConsultasClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
        this.fireTableDataChanged();
        
    }
    
    public GdcbCliente getBean(int rowIndex) {
        return (GdcbCliente) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbCliente usuarios = (GdcbCliente) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getGdcbIdcliente();
        } else if (columnIndex ==1) {
            return usuarios.getGdcbNome();        
        } else if (columnIndex ==2) {
            return usuarios.getGdcbDataNascimento();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Data Nascimento";
        } 
        return "";
    }
}
