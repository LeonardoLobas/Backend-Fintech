package com.example.coinmappingapp.dao;

import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.Despesa;
import com.example.coinmappingapp.model.Receita;

import java.util.List;

public interface DespesaDao {
    void cadastrar(Despesa despesa) throws DBExeption;
    void atualizar(Despesa despesa) throws DBExeption;
    void remover(Long id) throws DBExeption;
    List<Despesa> listar();
    List<Despesa> listarPorUsuario(Long userId) throws DBExeption;
}
