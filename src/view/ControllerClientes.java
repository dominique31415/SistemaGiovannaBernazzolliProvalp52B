/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.GdcbCliente;
import bean.GdcbUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tools.Util;

/**
 *
 * @author Marcos
 */
public class ControllerClientes extends AbstractTableModel {

    private List lstGdcbClientes;

    public void setList(List lstGdcbUsuarios) {
        this.lstGdcbClientes = lstGdcbUsuarios;
    }

    public GdcbCliente getBean(int rowIndex) {
        return (GdcbCliente) lstGdcbClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstGdcbClientes.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbCliente clientes = (GdcbCliente) lstGdcbClientes.get( rowIndex);
        if (columnIndex == 0) {
            return clientes.getGdcbIdcliente();
        } else if (columnIndex == 1) {
            return clientes.getGdcbNome();
        } else if (columnIndex == 2) {
            return clientes.getGdcbNome();
        } else if (columnIndex == 3) {
            return clientes.getGdcbCpf();
        } else if (columnIndex == 4) {
            return clientes.getGdcbRg();
        } else if (columnIndex == 5) {
            return Util.dateToStr(clientes.getGdcbDataNascimento());
        } else if (columnIndex == 6) {
            return clientes.getGdcbEmail();
        } else if (columnIndex == 7) {
            return clientes.getGdcbCep();
        } else if (columnIndex == 8) {
            return clientes.getGdcbNumeroCasa();
        } else if (columnIndex == 9) {
            return clientes.getGdcbNomeRua();
        } else if (columnIndex == 10) {
            return clientes.getGdcbBairro();
        } else if (columnIndex == 11) {
            return clientes.getGdcbCidade();
        } else if (columnIndex == 12) {
            return clientes.getGdcbNumeroCelular();
        } else if (columnIndex == 13) {
            return clientes.getGdcbEscolaridade();
        } else if (columnIndex == 14) {
            return clientes.getGdcbCursoAtual();
        } else if (columnIndex == 15) {
            return clientes.getGdcbSexo();
        } else if (columnIndex == 16) {
            return clientes.getGdcbAtivo() == 'S' ? "Ativo" : "Inativo";
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
            return "Apelido";
        } else if (columnIndex == 3) {
            return "CPF";
        } else if (columnIndex == 4) {
            return "RG";
        } else if (columnIndex == 5) {
            return "Data Nasc.";
        } else if (columnIndex == 6) {
            return "E-mail";
        } else if (columnIndex == 7) {
            return "CEP";
        } else if (columnIndex == 8) {
            return "Número";
        } else if (columnIndex == 9) {
            return "Rua";
        } else if (columnIndex == 10) {
            return "Bairro";
        } else if (columnIndex == 11) {
            return "Cidade";
        } else if (columnIndex == 12) {
            return "Celular";
        } else if (columnIndex == 13) {
            return "Escolaridade";
        } else if (columnIndex == 14) {
            return "Curso";
        } else if (columnIndex == 15) {
            return "Sexo";
        } else if (columnIndex == 16) {
            return "Status";
        }
        return "";
    }
}
