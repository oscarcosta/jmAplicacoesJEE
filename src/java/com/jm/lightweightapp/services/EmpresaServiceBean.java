package com.jm.lightweightapp.services;

import com.jm.lightweightapp.entities.Empresa;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EmpresaServiceBean implements CrudService {

    @EJB
    private CrudServiceBean crudServiceBean;
    
    @Override
    public <T> T create(T t) {
        return crudServiceBean.create(t);
    }

    @Override
    public <T> T update(T t) {
        return crudServiceBean.update(t);
    }

    @Override
    public <T> void delete(Class<T> type, Object id) {
        crudServiceBean.delete(type, id);
    }

    @Override
    public <T> T find(Class<T> type, Object id) {
        return crudServiceBean.find(type, id);
    }
    
    public Empresa find(long id) {
        return find(Empresa.class, id);
    }

    @Override
    public List findByNamedQuery(String namedQueryName) {
        return crudServiceBean.findByNamedQuery(namedQueryName);
    }

    @Override
    public List findByNamedQuery(String namedQueryName, Map<String, Object> parameters) {
        return crudServiceBean.findByNamedQuery(namedQueryName, parameters);
    }

    @Override
    public List findWithNamedQueryPaginated(String namedQueryName, int firstResult, int resultLimit) {
        return crudServiceBean.findWithNamedQueryPaginated(namedQueryName, firstResult, resultLimit);
    }

    @Override
    public List findWithNamedQueryPaginated(String namedQueryName, Map<String, Object> parameters, int firstResult, int resultLimit) {
        return crudServiceBean.findWithNamedQueryPaginated(namedQueryName, parameters, firstResult, resultLimit);
    }

    @Override
    public Integer countResultsOfNamedQuery(String namedQueryName) {
        return crudServiceBean.countResultsOfNamedQuery(namedQueryName);
    }

    @Override
    public Integer countResultsOfNamedQuery(String namedQueryName, Map<String, Object> parameters) {
        return crudServiceBean.countResultsOfNamedQuery(namedQueryName, parameters);
    }

}
