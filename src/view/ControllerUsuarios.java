/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.GdcbUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerUsuarios extends AbstractTableModel {

    private List lstGdcbUsuarios;

    public void setList(List lstGdcbUsuarios) {
        this.lstGdcbUsuarios = lstGdcbUsuarios;
    }
    
    public GdcbUsuarios getBean(int rowIndex) {
        return (GdcbUsuarios) lstGdcbUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstGdcbUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbUsuarios usuarios = (GdcbUsuarios) lstGdcbUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getGdcbIdusuarios();
        } else if (columnIndex ==1) {
            return usuarios.getGdcbNome();        
        } else if (columnIndex ==2) {
            return usuarios.getGdcbApelido();
        } else if (columnIndex ==3) {
            return usuarios.getGdcbCpf();
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
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
