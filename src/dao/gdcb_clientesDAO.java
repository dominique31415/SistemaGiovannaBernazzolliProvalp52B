package dao;

import bean.GdcbCliente;
import bean.GdcbUsuarios;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author u05084603105
 */
public class gdcb_clientesDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(GdcbCliente.class);
        criteria.add(Restrictions.eq("gdcbIdcliente", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbCliente.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbCliente.class); 
        criteria.add(Restrictions.like("gdcbNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listData(Date gdcbDataNascimento) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbCliente.class); 
        criteria.add(Restrictions.ge("gdcbDataNascimento", gdcbDataNascimento));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeData(String nome, Date gdcbDataNascimento) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbCliente.class); 
        criteria.add(Restrictions.like("gdcbNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("gdcbDataNascimento", gdcbDataNascimento));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    
    public static void main(String[] args) {
        gdcb_clientesDAO gdcb_clientesDAO = new gdcb_clientesDAO();
        gdcb_clientesDAO.listAll();
    }
}
