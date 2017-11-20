package com.jm.lightweightapp.services;

import com.jm.lightweightapp.services.util.QueryParameter;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(CrudService.class)
//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CrudServiceBean implements CrudService {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public <T> T create(T t) {
        em.persist(t);
        em.flush();
        em.refresh(t);
        return t;
    }

    @Override
    public <T> T update(T t) {
        return em.merge(t);
    }

    @Override
    public <T> void delete(Class<T> type, Object id) {
        Object ref = em.getReference(type, id);
        em.remove(ref);
    }

    @Override
    public <T> T find(Class<T> type, Object id) {
        return em.find(type, id);
    }

    @Override
    public List findByNamedQuery(String namedQueryName) {
        return findWithNamedQueryPaginated(namedQueryName, 0, 0);
    }
    
    @Override
    public List findByNamedQuery(String namedQueryName, 
                                 Map<String, Object> parameters) {
        return findWithNamedQueryPaginated(namedQueryName, parameters, 0, 0);
    }

    @Override
    public List findWithNamedQueryPaginated(String namedQueryName, 
                                            int firstResult, int resultLimit) {
        return findWithNamedQueryPaginated(namedQueryName, 
                                           QueryParameter.emptyParameters(), 
                                           firstResult, resultLimit);
    }
    
    @Override
    public List findWithNamedQueryPaginated(String namedQueryName, 
                                            Map<String, Object> parameters, 
                                            int firstResult, int resultLimit) {
        Query query = em.createNamedQuery(namedQueryName);
        if (firstResult > 0) {
            query.setFirstResult(firstResult);
        }
        if(resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }
    
    @Override
    public Integer countResultsOfNamedQuery(String namedQueryName) {
        return countResultsOfNamedQuery(namedQueryName, 
                                        QueryParameter.emptyParameters());
    }
    
    @Override
    public Integer countResultsOfNamedQuery(String namedQueryName, 
                                            Map<String, Object> parameters) {
        Query query = this.em.createNamedQuery(namedQueryName);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList().size();
    }
    
}
