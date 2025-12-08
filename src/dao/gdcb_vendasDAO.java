/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.GdcbVenda;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dominique
 */
public class gdcb_vendasDAO extends AbstractDAO {

    public void insert(GdcbVenda venda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(venda);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
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
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        criteria.add(Restrictions.eq("gdcbIdvendas", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeCliente(String nomeC) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        criteria.add(Restrictions.like("gdcbCliente", "%" + nomeC + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeFuncionario(String nomeF) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        criteria.add(Restrictions.like("gdcbFuncionario", "%" + nomeF + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listValor(double gdcbValorTotal) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        criteria.add(Restrictions.ge("gdcbValorTotal", gdcbValorTotal));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeCFValor(String nomeC, String nomeF, double gdcbValorTotal) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        criteria.add(Restrictions.like("gdcbCliente", "%" + nomeC + "%"));
        criteria.add(Restrictions.like("gdcbFuncionario", "%" + nomeF + "%"));
        criteria.add(Restrictions.ge("gdcbValorTotal", gdcbValorTotal));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        gdcb_vendasDAO gdcb_vendasDAO = new gdcb_vendasDAO();
        gdcb_vendasDAO.listAll();
    }

    @Override
    public void insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public GdcbVenda findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            GdcbVenda venda = (GdcbVenda) session.get(GdcbVenda.class, id);

            if (venda != null) {
                Hibernate.initialize(venda.getGdcbVendasProdutos());
            }
            session.getTransaction().commit();
            return venda;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
