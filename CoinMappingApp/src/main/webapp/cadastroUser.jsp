<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Cadastro</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="./resources/css/bootstrap.css">

  <style>
    .login-card {
      background: #fff;
      padding: 2rem 2.5rem;
      box-shadow: 0 4px 15px rgb(0 0 0 / 0.1);
      border-radius: 0.3rem;
      width: 100%;
      max-width: 420px;
      text-align: center;
    }

    .login-card h5 {
      font-weight: 600;
      margin-bottom: 1.5rem;
    }

    .form-control {
      height: 38px;
      font-size: 0.9rem;
    }

    .btn-login {
      background-color: #2d768f;
      border: none;
      font-weight: 600;
      padding: 8px 0;
      margin-top: 1rem;
    }

    .btn-login:hover {
      background-color: #256675;
    }

    .back-login {
      font-size: 0.85rem;
      display: inline-block;
      margin-top: 1rem;
      color: #0d6efd;
      text-decoration: none;
    }

    .back-login:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body class="d-flex flex-column min-vh-100">

<%@include file="header.jsp" %>

<c:if test="${not empty mensagem}">
  <div class="alert alert-success alert-dismissible fade show m-3" role="alert">
      ${mensagem}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Fechar"></button>
  </div>
</c:if>

<c:if test="${not empty erro}">
  <div class="alert alert-danger alert-dismissible fade show m-3" role="alert">
      ${erro}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Fechar"></button>
  </div>
</c:if>

<main class="flex-grow-1 d-flex justify-content-center align-items-center" style="background-color:#fafafa;">
  <div class="login-card">
    <h5>Crie sua conta</h5>

    <form action="users" method="post">
      <input type="text" name="nome" placeholder="Nome" class="form-control mb-2" required>
      <input type="email" name="email" placeholder="Email" class="form-control mb-2" required>
      <input type="date" name="data_nascimento" class="form-control mb-2" required>
      <input type="password" name="senha" placeholder="Senha" class="form-control mb-2" required>
      <input type="password" name="confirmar-senha" placeholder="Confirmar Senha" class="form-control mb-2" required>

      <button type="submit" class="btn btn-login w-100">Cadastrar</button>
    </form>

    <a href="loginUser.jsp" class="back-login">Voltar à tela de login</a>
  </div>
</main>

<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
