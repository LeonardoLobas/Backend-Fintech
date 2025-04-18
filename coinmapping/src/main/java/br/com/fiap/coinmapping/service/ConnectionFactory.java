package br.com.fiap.coinmapping.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
  private static final String USUARIO = "RM560041";
  private static final String SENHA = "270303";


  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USUARIO, SENHA);
  }
}