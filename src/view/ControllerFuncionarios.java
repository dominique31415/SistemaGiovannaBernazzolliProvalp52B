/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.GdcbFuncionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *

 */
public class ControllerFuncionarios extends AbstractTableModel {

    private List lstGdcbFuncionario;

    public void setList(List lstGdcbFuncionario) {
        this.lstGdcbFuncionario = lstGdcbFuncionario;
    }
    
    public GdcbFuncionario getBean(int rowIndex) {
        return (GdcbFuncionario) lstGdcbFuncionario.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstGdcbFuncionario.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbFuncionario funcionarios = (GdcbFuncionario) lstGdcbFuncionario.get(rowIndex);
        if (columnIndex == 0) {
            return funcionarios.getGdcbIdfuncionario();
        } else if (columnIndex == 1) {
            return funcionarios.getGdcbNomeFuncionario();
        } else if (columnIndex == 2) {
            return funcionarios.getGdcbCpfFuncionario();
        } else if (columnIndex == 3) {
            return funcionarios.getGdcbEmailFuncionario();
        } else if (columnIndex == 4) {
            return funcionarios.getGdcbCargo();
        } else if (columnIndex == 5) {
            return funcionarios.getGdcbClt().equals("S") ? "CLT" : "PJ";
        } else if (columnIndex == 6) {
            return funcionarios.getGdcbDataNascimentoFuncionario();
        } else if (columnIndex == 7) {
            return funcionarios.getGdcbAtivo().equals("S") ? "Ativo" : "Inativo";
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Nome";
        } else if (columnIndex == 2) {
            return "CPF";
        } else if (columnIndex == 3) {
            return "E-mail";
        } else if (columnIndex == 4) {
            return "Cargo";
        } else if (columnIndex == 5) {
            return "Regime";
        } else if (columnIndex == 6) {
            return "Data Nasc.";
        } else if (columnIndex == 7) {
            return "Status";
        }else if (columnIndex == 8) {
            return "Ativo";
        }
        return "";
    }
}