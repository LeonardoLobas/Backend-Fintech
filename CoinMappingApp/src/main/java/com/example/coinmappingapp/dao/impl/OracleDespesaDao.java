package com.example.coinmappingapp.dao.impl;

import com.example.coinmappingapp.dao.ConnectionManager;
import com.example.coinmappingapp.dao.DespesaDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.Despesa;
import com.example.coinmappingapp.model.TipoDespesa;
import com.example.coinmappingapp.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleDespesaDao implements DespesaDao {

    @Override
    public void cadastrar(Despesa despesa) throws DBExeption {
        String sql = "INSERT INTO T_FIN_DESPESAS (ID_DESPESA, NOME_DESPESA, VALOR, DESCRICAO, DATA_INCLUSAO, ID_USER, ID_TIPO_DESPESA) " +
                "VALUES (seq_despesa.nextval, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, despesa.getNome());
            stmt.setDouble(2, despesa.getValor());
            stmt.setString(3, despesa.getDescricao());
            stmt.setDate(4, Date.valueOf(despesa.getDataInclusao()));
            stmt.setLong(5, despesa.getUser().getId());
            stmt.setLong(6, despesa.getTipoDespesa().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBExeption("Erro ao cadastrar despesa", e);
        }
    }

    @Override
    public void atualizar(Despesa despesa) throws DBExeption {
        String sql = "UPDATE T_FIN_DESPESAS SET NOME_DESPESA = ?, VALOR = ?, DESCRICAO = ? WHERE ID_DESPESA = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, despesa.getNome());
            stmt.setDouble(2, despesa.getValor());
            stmt.setString(3, despesa.getDescricao());
            stmt.setLong(4, despesa.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBExeption("Erro ao atualizar despesa", e);
        }
    }

    @Override
    public void remover(Long id) throws DBExeption {
        String sql = "DELETE FROM T_FIN_DESPESAS WHERE ID_DESPESA = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBExeption("Erro ao remover despesa", e);
        }
    }

    @Override
    public List<Despesa> listar() {
        List<Despesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_FIN_DESPESAS";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("ID_DESPESA");
                String nome = rs.getString("NOME_DESPESA");
                Double valor = rs.getDouble("VALOR");
                String descricao = rs.getString("DESCRICAO");
                LocalDate dataInclusao = rs.getDate("DATA_INCLUSAO").toLocalDate();
                Long idTipoDespesa = rs.getLong("ID_TIPO_DESPESA");
                Long idUsuario = rs.getLong("ID_USER");

                TipoDespesa tipoDespesa = new TipoDespesa(idTipoDespesa);
                User user = new User(idUsuario);

                Despesa despesa = new Despesa(id, nome, valor, descricao, dataInclusao, tipoDespesa, user);
                lista.add(despesa);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar despesas", e);
        }

        return lista;
    }

    @Override
    public List<Despesa> listarPorUsuario(Long userId) throws DBExeption {
        List<Despesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_FIN_DESPESAS WHERE ID_USER = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("ID_DESPESA");
                    String nome = rs.getString("NOME_DESPESA");
                    Double valor = rs.getDouble("VALOR");
                    String descricao = rs.getString("DESCRICAO");
                    LocalDate dataInclusao = rs.getDate("DATA_INCLUSAO").toLocalDate();
                    Long idTipoDespesa = rs.getLong("ID_TIPO_DESPESA");
                    Long idUsuario = rs.getLong("ID_USER");

                    TipoDespesa tipoDespesa = new TipoDespesa(idTipoDespesa);
                    User user = new User(idUsuario);

                    Despesa despesa = new Despesa(id, nome, valor, descricao, dataInclusao, tipoDespesa, user);
                    lista.add(despesa);
                }
            }

        } catch (SQLException e) {
            throw new DBExeption("Erro ao listar despesas por usuário", e);
        }

        return lista;
    }
}
