package com.example.coinmappingapp.dao.impl;

import com.example.coinmappingapp.dao.ConnectionManager;
import com.example.coinmappingapp.dao.TipoDespesaDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.TipoDespesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleTipoDespesa implements TipoDespesaDao {

    @Override
    public List<TipoDespesa> listar() throws DBExeption {
        List<TipoDespesa> tipos = new ArrayList<>();
        String sql = "SELECT * FROM T_TIPO_DESPESA";

        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TipoDespesa tipo = new TipoDespesa();
                tipo.setId(rs.getLong("ID_TIPO_DESPESA"));
                tipo.setNome(rs.getString("NOME_TIPO_DESPESA"));
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao listar tipos de despesa", e);
        }

        return tipos;
    }

    @Override
    public TipoDespesa buscarPorId(Long id) throws DBExeption {
        String sql = "SELECT ID_TIPO_DESPESA, NOME_TIPO_DESPESA FROM T_TIPO_DESPESA WHERE ID_TIPO_DESPESA = ?";
        TipoDespesa tipoDespesa = null;

        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("NOME_TIPO_DESPESA");
                    tipoDespesa = new TipoDespesa(id, nome);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao buscar tipo de despesa por ID", e);
        }

        return tipoDespesa;
    }
}
