package com.example.coinmappingapp.dao;

import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.TipoDespesa;

import java.util.List;

public interface TipoDespesaDao {
    List<TipoDespesa> listar() throws DBExeption;

    TipoDespesa buscarPorId(Long id) throws DBExeption;
}
