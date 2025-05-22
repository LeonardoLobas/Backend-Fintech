package com.example.coinmappingapp.controller;

import com.example.coinmappingapp.dao.impl.OracleDespesaDao;
import com.example.coinmappingapp.model.Despesa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/despesa")
public class DespesaServlet extends HttpServlet {
    private OracleDespesaDao despesaDao;

    @Override
    public void init() throws ServletException {
        try {
            despesaDao = new OracleDespesaDao();
        } catch (SQLException e) {
            throw new ServletException("Erro ao conectar com o banco de dados", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome");
            Double valor = Double.valueOf(req.getParameter("valor"));
            String descricao = req.getParameter("descricao");

            Despesa despesa = new Despesa(nome, valor, descricao, LocalDate.now());
            despesaDao.cadastrar(despesa);

            List<Despesa> despesas = despesaDao.listar();
            double total = despesas.stream().mapToDouble(Despesa::getValor).sum();

            req.setAttribute("despesas", despesas);
            req.setAttribute("totalDespesa", total);

            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new ServletException("Erro ao processar despesa", e);
        }
    }
}
