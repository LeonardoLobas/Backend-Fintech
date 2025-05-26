package com.example.coinmappingapp.dao.impl;

import com.example.coinmappingapp.dao.ConnectionManager;
import com.example.coinmappingapp.dao.UserDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleUserDao implements UserDao {
    private Connection conexao;

    @Override
    public User buscarPorEmailESenha(String email, String senha) throws DBExeption {
        PreparedStatement stmt = null;
        conexao = ConnectionManager.getInstance().getConnection();
        User user = null;

        String sql = "SELECT * FROM T_FIN_USER WHERE EMAIL = ? AND SENHA = ?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            java.sql.ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getString("NOME_COMPLETO"),
                        rs.getString("EMAIL"),
                        rs.getDate("IDADE_NASC").toLocalDate(),
                        rs.getDate("DATA_CRIACAO").toLocalDate(),
                        rs.getString("SENHA")
                );
                // Setando o ID do usuário
                user.setId(rs.getLong("ID_USUARIO"));
            }
        } catch (SQLException e) {
            throw new DBExeption("Erro ao buscar usuário", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public void cadastrar(User user) throws DBExeption {
        PreparedStatement stmt = null;
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "insert into T_FIN_USER (ID_USUARIO, NOME_COMPLETO, EMAIL, IDADE_NASC, DATA_CRIACAO, SENHA) values (seq_usuario.nextval, ?, ?, ?, ?, ?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, user.getNome());                     // NOME_COMPLETO
            stmt.setString(2, user.getEmail());                    // EMAIL
            stmt.setDate(3, Date.valueOf(user.getDataNascimento())); // IDADE_NASC
            stmt.setDate(4, Date.valueOf(user.getDataCriacao()));    // DATA_CRIACAO
            stmt.setString(5, user.getSenha());                    // SENHA
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBExeption("Erro ao cadastrar usuário", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
