package com.jm.lightweightapp.controllers.util;

import com.jm.lightweightapp.util.AppUtil;
import java.util.HashSet;
import java.util.Set;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("DataSetConverter")
public class DataSetConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Set<String> retorno = new HashSet<String>();
        if (!AppUtil.isBlank(value)) {
            String[] elementos = value.split(";");
            for (String elemento : elementos) {
                retorno.add(elemento.trim());
            }
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        StringBuilder retorno = new StringBuilder();
        if (value instanceof Set) {
            Set lista = (Set) value;
            if (!lista.isEmpty()) {
                for (Object elemento : lista) {
                    retorno.append(((String)elemento).trim());
                    retorno.append("; ");
                }
                retorno.delete(retorno.lastIndexOf(";"), retorno.length());
            }
        }
        return retorno.toString();
    }
    
}
