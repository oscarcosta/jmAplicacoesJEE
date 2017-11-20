package com.jm.lightweightapp.entities;

import javax.persistence.*;

@Entity
public class Contato extends EntidadeBase {
    
    @Id
    @SequenceGenerator(name="CON_GEN", sequenceName="CON_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CON_GEN")
    private Long id;
    
    private String nome;
    
    private String email;
    
    private String cargo;

    @OneToOne(mappedBy="contato")
    private Empresa empresa;

    public Contato() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    @Override
    public String toString() {
        return "Contato{id=" + getId() + ", nome=" + nome + '}';
    }

}
