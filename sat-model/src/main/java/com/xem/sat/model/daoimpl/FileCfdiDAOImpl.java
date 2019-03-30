package com.xem.sat.model.daoimpl;

import com.xem.sat.model.dao.FileCfdiDAO;
import com.xem.sat.model.dto.FileCfdi;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */

@Repository("fileCfdiDAO")
@Transactional
public class FileCfdiDAOImpl implements FileCfdiDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public boolean create(FileCfdi fileCfdi) {

        sessionFactory.getCurrentSession()
                      .persist(fileCfdi);            

        return true;
    }
    
    @Override
    public boolean update(FileCfdi fileCfdi) {
          
        sessionFactory.getCurrentSession()
                      .update(fileCfdi);             
        return true;
    }

    @Override
    public boolean delete(FileCfdi fileCfdi) {
    
            fileCfdi.setActive(false);            
            sessionFactory.getCurrentSession()
                          .update(fileCfdi);            
        return true;
    }
    
    @Override
    public List<FileCfdi> getActiveActivities() {
        String query = "FROM FileCfdi WHERE active = 'Y'";
        return sessionFactory.getCurrentSession()
                .createQuery(query, FileCfdi.class)
                .getResultList();
    }

    @Override
    public List<FileCfdi> getAllActivities() {
        String query = "FROM FileCfdi";
        return sessionFactory.getCurrentSession()
                .createQuery(query, FileCfdi.class)
                .getResultList();
    }       
    
    @Override
    public FileCfdi getFileCfdiById(int id) {
        String query = "FROM FileCfdi WHERE fileCfdiId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, FileCfdi.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
