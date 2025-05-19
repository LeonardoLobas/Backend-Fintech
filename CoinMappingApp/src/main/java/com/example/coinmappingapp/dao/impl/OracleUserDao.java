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
    public void cadastrar(User user) throws DBExeption {

        PreparedStatement stmt = null;
       conexao = ConnectionManager.getInstance().getConnection();

        String sql = "insert into T_FIN_USER (ID_USUARIO, NOME_COMPLETO, EMAIL, IDADE_NASC, DATA_CRIACAO, SENHA) values (seq_usuario.nextval, ?, ?, ?, ?, ?) ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, user.getNome());                 // NOME_COMPLETO
            stmt.setString(2, user.getEmail());                // EMAIL
            stmt.setDate(3, Date.valueOf(user.getDataNascimento())); // IDADE_NASC
            stmt.setDate(4, Date.valueOf(user.getDataCriacao()));    // DATA_CRIACAO
            stmt.setString(5, user.getSenha());                // SENHA
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
