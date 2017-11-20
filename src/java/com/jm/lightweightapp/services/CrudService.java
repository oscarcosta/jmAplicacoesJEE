package com.jm.lightweightapp.services;

import java.util.List;
import java.util.Map;

public interface CrudService {

    public <T> T create(T t);

    public <T> T update(T t);

    public <T> void delete(Class<T> type, Object id);
    
    public <T> T find(Class<T> type, Object id);

    public List findByNamedQuery(String namedQueryName);

    public List findByNamedQuery(String namedQueryName, Map<String, Object> parameters);
    
    public List findWithNamedQueryPaginated(String namedQueryName, int firstResult, int resultLimit);

    public List findWithNamedQueryPaginated(String namedQueryName, Map<String, Object> parameters, int firstResult, int resultLimit);
    
    public Integer countResultsOfNamedQuery(String namedQueryName);
    
    public Integer countResultsOfNamedQuery(String namedQueryName, Map<String, Object> parameters);
}
