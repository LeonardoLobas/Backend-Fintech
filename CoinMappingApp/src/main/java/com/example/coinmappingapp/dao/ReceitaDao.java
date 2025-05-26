package com.example.coinmappingapp.dao;

import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.Receita;
import java.util.List;

public interface ReceitaDao {
    void cadastrar(Receita receita) throws DBExeption;
    void atualizar(Receita receita) throws DBExeption;
    void remover(Long id) throws DBExeption;
    List<Receita> listar();
    List<Receita> listarPorUsuario(Long userId) throws DBExeption;
}
