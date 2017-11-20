package com.jm.lightweightapp.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class EntidadeBase implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Version
    private Timestamp dataAlteracao;

    public abstract Long getId();
    
    public Timestamp getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Timestamp dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final EntidadeBase other = (EntidadeBase) obj;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
    
}
