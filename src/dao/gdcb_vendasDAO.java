package dao;

import bean.GdcbVenda;
import bean.GdcbCliente;
import bean.GdcbFuncionario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.MatchMode;

/**
 *
 * @author Dominique
 */
public class gdcb_vendasDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(object);
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

    // CORRIGIDO: Usando join com cliente
    public Object listNomeCliente(String nomeC) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        
        // Fazendo join com a tabela de clientes
        criteria.createAlias("gdcbCliente", "cliente");
        criteria.add(Restrictions.like("cliente.gdcbNome", "%" + nomeC + "%"));
        
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // CORRIGIDO: Usando join com funcionário
    public Object listNomeFuncionario(String nomeF) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        
        // Fazendo join com a tabela de funcionários
        criteria.createAlias("gdcbFuncionario", "funcionario");
        criteria.add(Restrictions.like("funcionario.gdcbNome", "%" + nomeF + "%"));
        
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

    // CORRIGIDO: Usando joins para cliente e funcionário
    public Object listNomeCFValor(String nomeC, String nomeF, double gdcbValorTotal) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        
        // Joins com cliente e funcionário
        criteria.createAlias("gdcbCliente", "cliente");
        criteria.createAlias("gdcbFuncionario", "funcionario");
        
        criteria.add(Restrictions.like("cliente.gdcbNome", "%" + nomeC + "%"));
        criteria.add(Restrictions.like("funcionario.gdcbNome", "%" + nomeF + "%"));
        criteria.add(Restrictions.ge("gdcbValorTotal", gdcbValorTotal));
        
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // NOVO: Método para cliente E funcionário (sem valor)
    public Object listNomeClienteFuncionario(String nomeC, String nomeF) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        
        criteria.createAlias("gdcbCliente", "cliente");
        criteria.createAlias("gdcbFuncionario", "funcionario");
        
        criteria.add(Restrictions.like("cliente.gdcbNome", "%" + nomeC + "%"));
        criteria.add(Restrictions.like("funcionario.gdcbNome", "%" + nomeF + "%"));
        
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // NOVO: Método para cliente E valor (sem funcionário)
    public Object listNomeClienteValor(String nomeC, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        
        criteria.createAlias("gdcbCliente", "cliente");
        
        criteria.add(Restrictions.like("cliente.gdcbNome", "%" + nomeC + "%"));
        criteria.add(Restrictions.ge("gdcbValorTotal", valor));
        
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // NOVO: Método para funcionário E valor (sem cliente)
    public Object listNomeFuncionarioValor(String nomeF, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbVenda.class);
        
        criteria.createAlias("gdcbFuncionario", "funcionario");
        
        criteria.add(Restrictions.like("funcionario.gdcbNome", "%" + nomeF + "%"));
        criteria.add(Restrictions.ge("gdcbValorTotal", valor));
        
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        gdcb_vendasDAO gdcb_vendasDAO = new gdcb_vendasDAO();
        gdcb_vendasDAO.listAll();
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