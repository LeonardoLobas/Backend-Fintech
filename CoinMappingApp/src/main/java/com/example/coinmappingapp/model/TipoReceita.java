package com.example.coinmappingapp.model;

public class TipoReceita {
    private Long id;
    private String nome;

    public TipoReceita(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoReceita(Long idTipoReceita) {
        this.id = idTipoReceita;
    }

    public TipoReceita() {}

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
