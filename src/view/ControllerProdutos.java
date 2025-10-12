/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.GdcbProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dominique
 */
public class ControllerProdutos extends AbstractTableModel  {
       private List lstGdcbProdutos;

    public void setList(List lstGdcbProdutos) {
        this.lstGdcbProdutos = lstGdcbProdutos;
    }
    
    public GdcbProdutos getBean(int rowIndex) {
        return (GdcbProdutos) lstGdcbProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstGdcbProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GdcbProdutos produtos = (GdcbProdutos) lstGdcbProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return produtos.getGdcbIdprodutos();
        } else if (columnIndex == 1) {
            return produtos.getGdcbNomeProduto();
        } else if (columnIndex == 2) {
            return produtos.getGdcbMarca();
        } else if (columnIndex == 3) {
            return produtos.getGdcbPopularidade();
        } else if (columnIndex == 4) {
            return produtos.getGdcbTipo();
        } else if (columnIndex == 5) {
            return produtos.getGdcbClassificacaoIdade();
        } else if (columnIndex == 6) {
            return produtos.getGdcbPreco();
        } else if (columnIndex == 7) {
            return produtos.getGdcbAutor();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Nome Produto";
        } else if (columnIndex == 2) {
            return "Marca";
        } else if (columnIndex == 3) {
            return "Popularidade";
        } else if (columnIndex == 4) {
            return "Tipo";
        } else if (columnIndex == 5) {
            return "Classificação";
        } else if (columnIndex == 6) {
            return "Preço";
        } else if (columnIndex == 7) {
            return "Autor";
        }
        return "";
    }
}
