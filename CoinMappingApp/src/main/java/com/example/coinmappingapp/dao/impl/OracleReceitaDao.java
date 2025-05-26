package com.example.coinmappingapp.dao.impl;

import com.example.coinmappingapp.dao.ConnectionManager;
import com.example.coinmappingapp.dao.ReceitaDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.Receita;
import com.example.coinmappingapp.model.TipoReceita;
import com.example.coinmappingapp.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleReceitaDao implements ReceitaDao {

    @Override
    public void cadastrar(Receita receita) throws DBExeption {
        String sql = "INSERT INTO T_FIN_RECEITAS (ID_RECEITA, NOME_RECEITA, VALOR, DESCRICAO, DATA_INCLUSAO, ID_TIPO_RECEITA, ID_USER) " +
                "VALUES (seq_receita.nextval, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, receita.getNome());
            stmt.setDouble(2, receita.getValor());
            stmt.setString(3, receita.getDescricao());
            stmt.setDate(4, Date.valueOf(receita.getDataInclusao()));
            stmt.setLong(5, receita.getTipoReceita().getId());
            stmt.setLong(6, receita.getUser().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBExeption("Erro ao cadastrar receita", e);
        }
    }

    @Override
    public void atualizar(Receita receita) throws DBExeption {
        String sql = "UPDATE T_FIN_RECEITAS SET NOME_RECEITA = ?, VALOR = ?, DESCRICAO = ? WHERE ID_RECEITA = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, receita.getNome());
            stmt.setDouble(2, receita.getValor());
            stmt.setString(3, receita.getDescricao());
            stmt.setLong(4, receita.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBExeption("Erro ao atualizar receita", e);
        }
    }

    @Override
    public void remover(Long id) throws DBExeption {
        String sql = "DELETE FROM T_FIN_RECEITAS WHERE ID_RECEITA = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBExeption("Erro ao remover receita", e);
        }
    }

    @Override
    public List<Receita> listar() {
        List<Receita> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_FIN_RECEITAS";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("ID_RECEITA");
                String nome = rs.getString("NOME_RECEITA");
                Double valor = rs.getDouble("VALOR");
                String descricao = rs.getString("DESCRICAO");
                LocalDate dataInclusao = rs.getDate("DATA_INCLUSAO").toLocalDate();
                Long idTipoReceita = rs.getLong("ID_TIPO_RECEITA");
                Long idUsuario = rs.getLong("ID_USER");

                TipoReceita tipoReceita = new TipoReceita(idTipoReceita);
                User user = new User(idUsuario);

                Receita receita = new Receita(id, nome, valor, descricao, dataInclusao, tipoReceita, user);
                lista.add(receita);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar receitas", e);
        }

        return lista;
    }

    @Override
    public List<Receita> listarPorUsuario(Long userId) throws DBExeption {
        List<Receita> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_FIN_RECEITAS WHERE ID_USER = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("ID_RECEITA");
                    String nome = rs.getString("NOME_RECEITA");
                    Double valor = rs.getDouble("VALOR");
                    String descricao = rs.getString("DESCRICAO");
                    LocalDate dataInclusao = rs.getDate("DATA_INCLUSAO").toLocalDate();
                    Long idTipoReceita = rs.getLong("ID_TIPO_RECEITA");
                    Long idUsuario = rs.getLong("ID_USER");

                    TipoReceita tipoReceita = new TipoReceita(idTipoReceita);
                    User user = new User(idUsuario);

                    Receita receita = new Receita(id, nome, valor, descricao, dataInclusao, tipoReceita, user);
                    lista.add(receita);
                }
            }

        } catch (SQLException e) {
            throw new DBExeption("Erro ao listar receitas por usuário", e);
        }

        return lista;
    }
}
