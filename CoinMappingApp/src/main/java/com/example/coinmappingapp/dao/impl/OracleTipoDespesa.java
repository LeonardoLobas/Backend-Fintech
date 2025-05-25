package com.example.coinmappingapp.dao.impl;

import com.example.coinmappingapp.dao.ConnectionManager;
import com.example.coinmappingapp.dao.TipoDespesaDao;
import com.example.coinmappingapp.model.TipoDespesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleTipoDespesa implements TipoDespesaDao {
    Connection conexao;
    @Override
    public List<TipoDespesa> listar() {

        List<TipoDespesa> lista = new ArrayList<TipoDespesa>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "select * from T_TIPO_DESPESA";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("ID_DESPESA");
                String nome = rs.getString("NOME_DESPESA");
                TipoDespesa tipoDespesa = new TipoDespesa(id, nome);
                lista.add(tipoDespesa);
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
