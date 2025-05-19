package com.example.coinmappingapp.controller;

import com.example.coinmappingapp.dao.UserDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.factory.DaoFactory;
import com.example.coinmappingapp.model.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet("/users")
public class UserServelet extends HttpServlet {
    private UserDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getUserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("confirmar-senha");
        LocalDate dataNascimento = LocalDate.parse(req.getParameter("data_nascimento"));

        try {
            if (nome == null || email == null || senha == null || confirmaSenha == null || dataNascimento == null) {
                req.setAttribute("erro", "Todos os campos devem ser preenchidos.");
                req.getRequestDispatcher("cadastroUser.jsp").forward(req, resp);
                return;
            }

            if (!senha.equals(confirmaSenha)) {
                req.setAttribute("erro", "Senhas não coincidem.");
                req.getRequestDispatcher("cadastroUser.jsp").forward(req, resp);
                return;
            }

            User user = new User(nome, email, dataNascimento, LocalDate.now(), senha);

            dao.cadastrar(user);

            System.out.println("Cadastrado com sucesso!");
            req.setAttribute("mensagem", "Usuario Cadastrado");
        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar usuario");
        } catch (Exception e) {
            req.setAttribute("erro", "Por favor, valide os dados");
        }


        req.getRequestDispatcher("cadastroUser.jsp").forward(req, resp);
    }


}
