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
    body, html {
      height: 100%;
      margin: 0;
    }

    main {
      min-height: 100vh;
      background-color: #fafafa;
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 2rem 1rem;
    }

    .card {
      width: 100%;
      max-width: 500px;
      box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    }
  </style>

</head>
<body>
<%@include file="header.jsp" %>

<main>
  <div class="card">
    <div class="card-header">
      Cadastro de usuário
    </div>

    <c:if test="${not empty mensagem}">
      <div class="alert alert-success m-3">${mensagem}</div>
    </c:if>

    <c:if test="${not empty erro}">
      <div class="alert alert-danger m-3">${erro}</div>
    </c:if>

    <div class="card-body">
      <form action="users" method="post">
        <div class="form-group mb-3">
          <label for="id-nome">Nome</label>
          <input type="text" name="nome" id="id-nome" class="form-control" required>
        </div>
        <div class="form-group mb-3">
          <label for="id-email">Email</label>
          <input type="email" name="email" id="id-email" class="form-control" required>
        </div>
        <div class="form-group mb-3">
          <label for="id-data_nascimento">Data de Nascimento</label>
          <input type="date" name="data_nascimento" id="id-data_nascimento" class="form-control" required>
        </div>
        <div class="form-group mb-3">
          <label for="id-senha">Senha</label>
          <input type="password" name="senha" id="id-senha" class="form-control" required>
        </div>
        <div class="form-group mb-3">
          <label for="id-senha-confirmar-senha">Confirmar Senha</label>
          <input type="password" name="confirmar-senha" id="id-senha-confirmar-senha" class="form-control" required>
        </div>
        <div class="d-flex justify-content-between">
          <input type="submit" value="Salvar" class="btn btn-primary">
          <a href="loginUser.jsp" class="btn btn-warning">Voltar à tela de login</a>
        </div>
      </form>
    </div>
  </div>
</main>

<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>