package com.example.coinmappingapp.model;

public class TipoDespesa {
    private Long id;
    private String nome;

    public TipoDespesa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoDespesa() {}

    public TipoDespesa(Long idTipoDespesa) {
        this.id = idTipoDespesa;
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
}
