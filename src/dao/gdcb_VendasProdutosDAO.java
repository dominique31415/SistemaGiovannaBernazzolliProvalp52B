/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.GdcbProdutos;
import bean.GdcbVenda;
import bean.GdcbVendasProdutos;
import dao.AbstractDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class gdcb_VendasProdutosDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();        
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();        
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();        
        session.delete(object);
        session.getTransaction().commit();        
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVendasProdutos.class);
        criteria.add(Restrictions.eq("idprodutosProdutos", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

      public Object listProutos(GdcbVenda venda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVendasProdutos.class);
        criteria.add(Restrictions.eq("venda", venda));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    
    
    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVendasProdutos.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        gdcb_VendasProdutosDAO usuariosDAO = new gdcb_VendasProdutosDAO();
        usuariosDAO.listAll();
    }
}
