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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/receita")
public class ReceitaServlet extends HttpServlet {
    private OracleReceitaDao receitaDao;

    @Override
    public void init() {
        System.out.println(">>>> Inicializando ReceitaServlet");
        receitaDao = new OracleReceitaDao();
    }

    private void carregarDados(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException, DBExeption {
        System.out.println(">>>> Início do método carregarDados para usuário ID: " + user.getId());

        try {
            // Carregando receitas
            List<Receita> receitas = receitaDao.listarPorUsuario(user.getId());
            System.out.println(">>>> Receitas carregadas: " + receitas.size());

            // Carregando despesas
            List<Despesa> despesas = new OracleDespesaDao().listarPorUsuario(user.getId());
            System.out.println(">>>> Despesas carregadas: " + despesas.size());


            // Calculando totais
            double totalReceita = receitas.stream().mapToDouble(Receita::getValor).sum();
            double totalDespesa = despesas.stream().mapToDouble(Despesa::getValor).sum();

            System.out.println(">>>> Total receita: " + totalReceita + ", Total despesa: " + totalDespesa);

            // Setando atributos na request
            request.setAttribute("receitas", receitas);
            request.setAttribute("despesas", despesas);
            request.setAttribute("totalReceita", totalReceita);
            request.setAttribute("totalDespesa", totalDespesa);

            System.out.println(">>>> Atributos setados na request, redirecionando para index.jsp");

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            System.err.println(">>>> ERRO GERAL no carregarDados: " + e.getMessage());
            e.printStackTrace();
            throw new ServletException("Erro ao carregar dados", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>> doPost recebido");

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


                System.out.println(">>>> Dados recebidos - Nome: " + nome + ", Valor: " + valor + ", Descrição: " + descricao + ", TipoReceitaId: " );


                LocalDate dataInclusao = LocalDate.now();


                Receita receita = new Receita(nome, valor, descricao, dataInclusao, user);

                receitaDao.cadastrar(receita);
                System.out.println(">>>> Receita cadastrada com sucesso");

            } else if ("remover".equals(acao)) {
                Long id = Long.parseLong(request.getParameter("id"));
                System.out.println(">>>> Removendo receita com ID: " + id);
                receitaDao.remover(id);
                System.out.println(">>>> Receita removida com sucesso");
            }

            carregarDados(request, response, user);

        } catch (Exception e) {
            System.err.println(">>>> ERRO no doPost: " + e.getMessage());
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>> doGet recebido");
        HttpSession sessao = request.getSession(false);
        if (sessao == null || sessao.getAttribute("usuarioLogado") == null) {
            System.out.println(">>>> Sessão inválida ou usuário não logado no doGet");
            response.sendRedirect("loginUser.jsp");
            return;
        }

        User user = (User) sessao.getAttribute("usuarioLogado");
        String acao = request.getParameter("acao");
        System.out.println(">>>> Usuário logado: ID = " + user.getId() + ", ação: " + acao);

        try {
            if ("remover".equals(acao)) {
                Long id = Long.valueOf(request.getParameter("id"));
                System.out.println(">>>> Removendo receita com ID: " + id);
                receitaDao.remover(id);
                System.out.println(">>>> Receita removida com sucesso");
            }

            carregarDados(request, response, user);
        } catch (DBExeption e) {
            System.err.println(">>>> ERRO no doGet: " + e.getMessage());
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

}