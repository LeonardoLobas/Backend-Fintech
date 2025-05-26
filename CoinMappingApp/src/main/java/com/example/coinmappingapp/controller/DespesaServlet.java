package com.example.coinmappingapp.controller;

import com.example.coinmappingapp.dao.impl.OracleDespesaDao;
import com.example.coinmappingapp.dao.impl.OracleReceitaDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.Despesa;
import com.example.coinmappingapp.model.Receita;
import com.example.coinmappingapp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/despesa")
public class DespesaServlet extends HttpServlet {
    private OracleDespesaDao despesaDao;
    private OracleReceitaDao receitaDao;

    @Override
    public void init() {
        System.out.println(">>>> Inicializando DespesaServlet");
        despesaDao = new OracleDespesaDao();
        receitaDao = new OracleReceitaDao();
    }

    private void carregarDados(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException, DBExeption {
        try {
            List<Despesa> despesas = despesaDao.listarPorUsuario(user.getId());
            List<Receita> receitas = receitaDao.listarPorUsuario(user.getId());

            double totalDespesa = despesas.stream().mapToDouble(Despesa::getValor).sum();
            double totalReceita = receitas.stream().mapToDouble(Receita::getValor).sum();

            request.setAttribute("despesas", despesas);
            request.setAttribute("receitas", receitas);
            request.setAttribute("totalDespesa", totalDespesa);
            request.setAttribute("totalReceita", totalReceita);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println(">>>> ERRO no carregarDados do DespesaServlet: " + e.getMessage());
            throw new ServletException("Erro ao carregar dados", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>> doPost DespesaServlet recebido");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("usuarioLogado");

        if (user == null) {
            response.sendRedirect("loginUser.jsp");
            return;
        }

        String acao = request.getParameter("acao");
        System.out.println(">>>> Ação recebida: " + acao);

        try {
            if ("cadastrar".equals(acao)) {
                String nome = request.getParameter("nome");
                Double valor = Double.parseDouble(request.getParameter("valor"));
                String descricao = request.getParameter("descricao");

                if (valor < 0) {
                    throw new IllegalArgumentException("O valor da despesa não pode ser negativo.");
                }

                LocalDate dataInclusao = LocalDate.now();
                Despesa despesa = new Despesa(nome, valor, descricao, dataInclusao, user);

                despesaDao.cadastrar(despesa);
                System.out.println(">>>> Despesa cadastrada com sucesso");

            } else if ("remover".equals(acao)) {
                Long id = Long.parseLong(request.getParameter("id"));
                despesaDao.remover(id);
                System.out.println(">>>> Despesa removida com sucesso");
            }

            carregarDados(request, response, user);
        } catch (Exception e) {
            System.err.println(">>>> ERRO no doPost do DespesaServlet: " + e.getMessage());
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>> doGet DespesaServlet recebido");

        HttpSession sessao = request.getSession(false);
        if (sessao == null || sessao.getAttribute("usuarioLogado") == null) {
            response.sendRedirect("loginUser.jsp");
            return;
        }

        User user = (User) sessao.getAttribute("usuarioLogado");
        String acao = request.getParameter("acao");

        try {
            if ("remover".equals(acao)) {
                Long id = Long.parseLong(request.getParameter("id"));
                despesaDao.remover(id);
                System.out.println(">>>> Despesa removida com sucesso");
            }

            carregarDados(request, response, user);
        } catch (Exception e) {
            System.err.println(">>>> ERRO no doGet do DespesaServlet: " + e.getMessage());
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
