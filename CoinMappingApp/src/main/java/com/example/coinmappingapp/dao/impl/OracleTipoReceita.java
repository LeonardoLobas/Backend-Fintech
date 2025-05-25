package com.example.coinmappingapp.dao.impl;

import com.example.coinmappingapp.dao.ConnectionManager;
import com.example.coinmappingapp.dao.TipoReceitaDao;
import com.example.coinmappingapp.model.TipoReceita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OracleTipoReceita implements TipoReceitaDao {
    Connection conexao;

    @Override
    public List<TipoReceita> listar() {
        List<TipoReceita> lista = new ArrayList<TipoReceita>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "select * from T_tipo_receita";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("ID_RECEITA");
                String nome = rs.getString("NOME_RECEITA");
                TipoReceita tipoReceita = new TipoReceita(id, nome);
                lista.add(tipoReceita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}
