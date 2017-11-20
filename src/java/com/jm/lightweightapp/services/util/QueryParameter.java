package com.jm.lightweightapp.services.util;

import java.util.HashMap;
import java.util.Map;

public class QueryParameter {

    private Map<String, Object> parameters = null;

    private QueryParameter(String name, Object value) {
        this.parameters = new HashMap<String, Object>();
        this.parameters.put(name, value);
    }

    public static QueryParameter with(String name, Object value) {
        return new QueryParameter(name, value);
    }
    
    public QueryParameter and(String name, Object value) {
        this.parameters.put(name, value);
        return this;
    }

    public Map<String, Object> parameters() {
        return this.parameters;
    }
    
    public static Map<String, Object> emptyParameters() {
        return new HashMap<String, Object>();
    }
    
}
