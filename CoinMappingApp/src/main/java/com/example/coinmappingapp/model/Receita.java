package com.example.coinmappingapp.model;

import java.time.LocalDate;

public class Receita {
    private Long id;
    private String nome;
    private Double valor;
    private String descricao;
    private LocalDate dataInclusao;
    private TipoReceita tipoReceita;
    private User user;

    public Receita() {}

    public Receita(Long id, String nome, Double valor, String descricao, LocalDate dataInclusao, TipoReceita tipoReceita, User user) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
        this.tipoReceita = tipoReceita;
        this.user = user;
    }

    public Receita(String nome, Double valor, String descricao, LocalDate dataInclusao, TipoReceita tipoReceita, User user) {
        this(null, nome, valor, descricao, dataInclusao, tipoReceita, user);
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

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", dataInclusao=" + dataInclusao +
                ", tipoReceita=" + tipoReceita +
                ", user=" + user;
    }
}
