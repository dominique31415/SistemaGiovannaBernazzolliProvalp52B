package dao;

import bean.GdcbUsuarios;
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
public class gdcb_usuariosDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(GdcbUsuarios.class);
        criteria.add(Restrictions.eq("gdcbIdusuarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GdcbUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        gdcb_usuariosDAO usuariosDAO = new gdcb_usuariosDAO();
        usuariosDAO.listAll();
    }
    
    public Object listLogin(String username, String senha) {
        session.beginTransaction();

        Criteria criteria = session.createCriteria(GdcbUsuarios.class);
        criteria.add(Restrictions.eq("gdcbNome", username));
        criteria.add(Restrictions.eq("gdcbSenha", senha));

        GdcbUsuarios usuario = (GdcbUsuarios) criteria.uniqueResult();

        session.getTransaction().commit();
        return usuario;
    }
}
