package br.com.fiap.coinmapping.domain.despesa;
import java.time.LocalDate;


public class Despesa {
  private Long id;
  private String nome;
  private Double valor;
  private String descricao;
  private LocalDate dataInclusao;

  public Despesa(Long id, String nome, Double valor, String descricao, LocalDate dataInclusao) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
    this.descricao = descricao;
    this.dataInclusao = dataInclusao;
  }

  public Despesa(String nome, Double valor, String descricao, LocalDate dataInclusao) {
    this.nome = nome;
    this.valor = valor;
    this.descricao = descricao;
    this.dataInclusao = dataInclusao;
  }

  public Despesa(){}

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
}
