package com.example.coinmappingapp.dao.impl;

import com.example.coinmappingapp.dao.ConnectionManager;
import com.example.coinmappingapp.dao.TipoReceitaDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.TipoReceita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleTipoReceita implements TipoReceitaDao {

    @Override
    public List<TipoReceita> listar() throws DBExeption {
        List<TipoReceita> tipos = new ArrayList<>();
        String sql = "SELECT * FROM T_TIPO_RECEITA";

        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TipoReceita tipo = new TipoReceita();
                tipo.setId(rs.getLong("ID_RECEITA"));
                tipo.setNome(rs.getString("NOME_RECEITA"));
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao listar tipos de receita", e);
        }

        return tipos;
    }

    @Override
    public TipoReceita buscarPorId(Long id) throws DBExeption {
        String sql = "SELECT ID_RECEITA, NOME_RECEITA FROM T_TIPO_RECEITA WHERE ID_RECEITA = ?";
        TipoReceita tipoReceita = null;

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("NOME_RECEITA");
                    tipoReceita = new TipoReceita(id, nome);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao buscar tipo de receita por ID", e);
        }

        return tipoReceita;
    }
}