package com.jm.lightweightapp.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String tipoLogradouro;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    public Endereco() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if ((this.tipoLogradouro == null) ? (other.tipoLogradouro != null) : !this.tipoLogradouro.equals(other.tipoLogradouro)) {
            return false;
        }
        if ((this.logradouro == null) ? (other.logradouro != null) : !this.logradouro.equals(other.logradouro)) {
            return false;
        }
        if (this.numero != other.numero && (this.numero == null || !this.numero.equals(other.numero))) {
            return false;
        }
        if ((this.complemento == null) ? (other.complemento != null) : !this.complemento.equals(other.complemento)) {
            return false;
        }
        if ((this.cidade == null) ? (other.cidade != null) : !this.cidade.equals(other.cidade)) {
            return false;
        }
        if ((this.estado == null) ? (other.estado != null) : !this.estado.equals(other.estado)) {
            return false;
        }
        if ((this.cep == null) ? (other.cep != null) : !this.cep.equals(other.cep)) {
            return false;
        }
        if ((this.pais == null) ? (other.pais != null) : !this.pais.equals(other.pais)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.tipoLogradouro != null ? this.tipoLogradouro.hashCode() : 0);
        hash = 41 * hash + (this.logradouro != null ? this.logradouro.hashCode() : 0);
        hash = 41 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 41 * hash + (this.complemento != null ? this.complemento.hashCode() : 0);
        hash = 41 * hash + (this.cidade != null ? this.cidade.hashCode() : 0);
        hash = 41 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 41 * hash + (this.cep != null ? this.cep.hashCode() : 0);
        hash = 41 * hash + (this.pais != null ? this.pais.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Endereco{tipoLogradouro=" + tipoLogradouro + ", logradouro=" + logradouro + ", numero=" + numero + '}';
    }
    
}
