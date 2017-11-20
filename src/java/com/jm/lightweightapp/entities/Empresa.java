package com.jm.lightweightapp.entities;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name=Empresa.FIND_ALL, query="select e from Empresa e"),
    @NamedQuery(name=Empresa.FIND_BY_NOME, query="select e from Empresa e where e.nome like :nome"),
    @NamedQuery(name=Empresa.FIND_BY_CIDADE, query="select e from Empresa e "
                                                 + "where e.endereco.cidade = :cidade")
})
public class Empresa extends EntidadeBase {
    
    public static final String FIND_ALL = "Empresa.findAll";
    public static final String FIND_BY_NOME = "Empresa.findByNome";
    public static final String FIND_BY_CIDADE = "Empresa.findByCidade";
    
    @Id
    @SequenceGenerator(name="EMP_GEN", sequenceName="EMP_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EMP_GEN")
    private Long id;
    
    private String nome;
    
    @Embedded
    private Endereco endereco;
    
    @OneToOne(cascade= CascadeType.ALL)
    private Contato contato;

    public Empresa() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Empresa{id=" + getId() + ", nome=" + nome + '}';
    }

}
