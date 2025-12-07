/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.GdcbProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dominique
 */
public class gdcb_produtosDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();;
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();;
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();;
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbProdutos.class);
        criteria.add(Restrictions.eq("gdcbIdprodutos", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbProdutos.class);
        criteria.add(Restrictions.like("gdcbNomeProduto", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listValor(double gdcbPreco) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbProdutos.class);
        criteria.add(Restrictions.ge("gdcbPreco",  gdcbPreco ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeValor(String nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbProdutos.class);
        criteria.add(Restrictions.like("gdcbNomeProduto", "%" + nome + "%"));
        criteria.add(Restrictions.ge("gdcbPreco",  valor ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbProdutos.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        gdcb_produtosDAO gdcb_produtosDAO = new gdcb_produtosDAO();
        gdcb_produtosDAO.listAll();
    }
}
