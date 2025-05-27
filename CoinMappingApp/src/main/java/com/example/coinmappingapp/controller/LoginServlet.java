
package com.example.coinmappingapp.controller;

import com.example.coinmappingapp.dao.UserDao;
import com.example.coinmappingapp.factory.DaoFactory;
import com.example.coinmappingapp.model.User;
import com.example.coinmappingapp.util.CriptografiaUtils;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getUserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("password");

        try {
            String senhaCriptografada = CriptografiaUtils.criptografia(senha);

            User user = dao.buscarPorEmailESenha(email,senhaCriptografada);
            if (user != null) {

                OracleTipoReceita tiporeceitaDao = new OracleTipoReceita();
                OracleTipoDespesa tipoDespesaDao = new OracleTipoDespesa();


                List<TipoReceita> tiposReceita = tiporeceitaDao.listar();
                List<TipoDespesa> tiposDespesa = tipoDespesaDao.listar();

                req.setAttribute("tiposReceita", tiposReceita);
                req.setAttribute("tiposDespesa", tiposDespesa);



                req.getSession().setAttribute("usuarioLogado", user);
                resp.sendRedirect("index.jsp");
            } else {
                req.setAttribute("erro", "E-mail ou senha inválidos.");
                req.getRequestDispatcher("loginUser.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao processar Login");
            req.getRequestDispatcher("loginUser.jsp").forward(req, resp);
        }
    }
}
