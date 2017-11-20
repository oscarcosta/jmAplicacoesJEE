package com.jm.lightweightapp.controllers;

import com.jm.lightweightapp.controllers.util.JsfUtil;
import com.jm.lightweightapp.controllers.util.PaginationHelper;
import com.jm.lightweightapp.entities.EntidadeBase;
import com.jm.lightweightapp.services.CrudService;
import java.io.Serializable;
import javax.faces.model.DataModel;

public abstract class CrudController<T extends EntidadeBase> implements Serializable {
    
    //@EJB
    //protected CrudService crudService;
    
    protected T entidade;
    protected DataModel items = null;
    protected PaginationHelper pagination;
    
    public T getEntidade() {
        return entidade;
    }
    
    public abstract CrudService getCrudService();
    
    public abstract PaginationHelper getPagination();
    
    public void next() {
        getPagination().nextPage();
        items = getPagination().createPageDataModel();
    }

    public void previous() {
        getPagination().previousPage();
        items = getPagination().createPageDataModel();
    }
    
    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }
    
    public void create() {
        try {
            entidade = getCrudService().create(entidade);
            JsfUtil.addSuccessMessage("CrudEntityCreated", entidade.getClass().getSimpleName());
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "CrudEntityCreatedError", entidade.getClass().getSimpleName());
        }
    }

    public void update() {
        try {
            entidade = getCrudService().update(entidade);
            JsfUtil.addSuccessMessage("CrudEntityUpdated", entidade.getClass().getSimpleName());
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "CrudEntityUpdatedError", entidade.getClass().getSimpleName());
        }
    }

    public String delete() {
        try {
            getCrudService().delete(entidade.getClass(), entidade.getId());
            JsfUtil.addSuccessMessage("CrudEntityDeleted", entidade.getClass().getSimpleName());
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "CrudEntityDeletedError", entidade.getClass().getSimpleName());
        }
        return "List";
    }
    
}
