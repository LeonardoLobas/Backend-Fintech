package com.example.coinmappingapp.model;

import java.time.LocalDate;

public class Despesa {
    private Long id;
    private String nome;
    private Double valor;
    private String descricao;
    private LocalDate dataInclusao;
    private TipoDespesa tipoDespesa;
    private User user;

    public Despesa() {}

    public Despesa(Long id, String nome, Double valor, String descricao, LocalDate dataInclusao, TipoDespesa tipoDespesa, User user) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
        this.tipoDespesa = tipoDespesa;
        this.user = user;
    }

    public Despesa(String nome, Double valor, String descricao, LocalDate dataInclusao, TipoDespesa tipoDespesa, User user) {
        this(null, nome, valor, descricao, dataInclusao, tipoDespesa, user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", dataInclusao=" + dataInclusao;
    }
}
