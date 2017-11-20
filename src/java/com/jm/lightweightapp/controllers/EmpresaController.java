package com.jm.lightweightapp.controllers;

import com.jm.lightweightapp.controllers.util.JsfUtil;
import com.jm.lightweightapp.controllers.util.PaginationHelper;
import com.jm.lightweightapp.entities.Contato;
import com.jm.lightweightapp.entities.Empresa;
import com.jm.lightweightapp.entities.Endereco;
import com.jm.lightweightapp.services.CrudService;
import com.jm.lightweightapp.services.EmpresaServiceBean;
import com.jm.lightweightapp.util.AppUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "empresaController")
@ViewScoped
public class EmpresaController extends CrudController<Empresa> {
    
    @EJB
    private EmpresaServiceBean empresaServiceBean;
    
    @Override
    public CrudService getCrudService() {
        return (CrudService) empresaServiceBean;
    }

    @PostConstruct
    public void init() {
        String id = JsfUtil.getRequestParameter("id");
        if (AppUtil.isBlank(id)) {
            entidade = new Empresa();
            entidade.setContato(new Contato());
            entidade.setEndereco(new Endereco());
        } else {
            entidade = empresaServiceBean.find(Long.parseLong(id));
        }
    }

    public Empresa getEmpresa() {
        return entidade;
    }
    
    @Override
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(5) {

                @Override
                public int getItemsCount() {
                    return empresaServiceBean.countResultsOfNamedQuery(Empresa.FIND_ALL);
                }

                @Override
                public DataModel createPageDataModel() {
                    List lista = empresaServiceBean.findWithNamedQueryPaginated(Empresa.FIND_ALL, 
                                                                                getPageFirstItem(), 
                                                                                getPageSize());
                    return new ListDataModel(lista);
                }
            };
        }
        return pagination;
    }

    public SelectItem[] getListaEmpresas() {
        return JsfUtil.getSelectItems(empresaServiceBean.findByNamedQuery(Empresa.FIND_ALL), true);
    }

    @FacesConverter(forClass = Empresa.class)
    public static class EmpresaControllerConverter implements Converter {
        
        private Long getKey(String value) {
            Long key = Long.valueOf(value);
            return key;
        }

        private String getStringKey(Long value) {
            return value.toString();
        }

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmpresaController controller = (EmpresaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empresaController");
            return controller.empresaServiceBean.find(getKey(value));
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Empresa) {
                Empresa o = (Empresa) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EmpresaController.class.getName());
            }
        }
    }

}
