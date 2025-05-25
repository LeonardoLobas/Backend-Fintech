package com.example.coinmappingapp.controller;

import com.example.coinmappingapp.dao.impl.OracleDespesaDao;
import com.example.coinmappingapp.dao.impl.OracleReceitaDao;
import com.example.coinmappingapp.model.Despesa;
import com.example.coinmappingapp.model.Receita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/despesa")
public class DespesaServlet extends HttpServlet {

   /* private OracleDespesaDao despesaDao;*/

    @Override
    public void init() throws ServletException {
       /* try {
            despesaDao = new OracleDespesaDao();
        } catch (SQLException e) {
            throw new ServletException("Erro ao conectar ao banco", e);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* try {
            String nome = request.getParameter("nome");
            Double valor = Double.valueOf(request.getParameter("valor"));
            String descricao = request.getParameter("descricao");

            if (valor < 0) {
                request.setAttribute("erro", "O valor da despesa não pode ser negativo.");
            } else {
                LocalDate dataInclusao = LocalDate.now();
                Despesa despesa = new Despesa(nome, valor, descricao, dataInclusao);
                despesaDao.cadastrar(despesa);
            }


            List<Despesa> despesas = despesaDao.listar();
            List<Receita> receitas = new OracleReceitaDao().listar();

            double totalDespesa = despesas.stream().mapToDouble(Despesa::getValor).sum();
            double totalReceita = receitas.stream().mapToDouble(Receita::getValor).sum();

            request.setAttribute("despesas", despesas);
            request.setAttribute("receitas", receitas);
            request.setAttribute("totalDespesa", totalDespesa);
            request.setAttribute("totalReceita", totalReceita);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Erro ao cadastrar despesa", e);
        }*/
    }

    @Override
    public void destroy() {
        /*try {
            despesaDao.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
