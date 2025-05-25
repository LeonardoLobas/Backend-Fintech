package com.example.coinmappingapp.controller;

import com.example.coinmappingapp.dao.impl.OracleDespesaDao;
import com.example.coinmappingapp.dao.impl.OracleReceitaDao;
import com.example.coinmappingapp.model.Despesa;
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
      /*  try {
            receitaDao = new OracleReceitaDao(); // usa o construtor correto
        } catch (SQLException e) {
            throw new ServletException("Erro ao iniciar DAO", e);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  try {
            String nome = request.getParameter("nome");
            Double valor = Double.valueOf(request.getParameter("valor"));
            String descricao = request.getParameter("descricao");
            LocalDate dataInclusao = LocalDate.now();

            Receita receita = new Receita(nome, valor, descricao, dataInclusao);
            receitaDao.cadastrar(receita);

            // Carrega novamente todas as receitas E despesas
            List<Receita> receitas = receitaDao.listar();
            List<Despesa> despesas = new OracleDespesaDao().listar();

            double totalReceita = receitas.stream().mapToDouble(Receita::getValor).sum();
            double totalDespesa = despesas.stream().mapToDouble(Despesa::getValor).sum();

            request.setAttribute("receitas", receitas);
            request.setAttribute("despesas", despesas);
            request.setAttribute("totalReceita", totalReceita);
            request.setAttribute("totalDespesa", totalDespesa);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }*/
    }

}

