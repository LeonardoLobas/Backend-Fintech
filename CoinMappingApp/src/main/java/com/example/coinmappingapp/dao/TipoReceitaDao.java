package com.example.coinmappingapp.dao;

import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.TipoReceita;

import java.util.List;

public interface TipoReceitaDao {
    List<TipoReceita> listar() throws DBExeption;

    TipoReceita buscarPorId(Long id) throws DBExeption;
}
