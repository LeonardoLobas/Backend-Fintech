package com.example.coinmappingapp.controller;

import com.example.coinmappingapp.dao.impl.OracleReceitaDao;
import com.example.coinmappingapp.model.Receita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/receita")
public class ReceitaServlet extends HttpServlet {
    private OracleReceitaDao receitaDao;

    @Override
    public void init() throws ServletException {
        try {
            receitaDao = new OracleReceitaDao(); // usa o construtor correto
        } catch (SQLException e) {
            throw new ServletException("Erro ao iniciar DAO", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));

        Receita receita = new Receita(null, nome, valor, descricao, LocalDate.now());


        try {
            receitaDao.cadastrar(receita);
            List<Receita> receitas = receitaDao.listar();
            double totalReceitas = receitas.stream()
                    .mapToDouble(Receita::getValor)
                    .sum();

            request.setAttribute("receitas", receitas);
            request.setAttribute("totalReceitas", totalReceitas);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erro ao cadastrar receita", e);
        }
    }
}

