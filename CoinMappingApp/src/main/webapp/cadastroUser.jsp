<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>cadastro</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
  <div class="mt-5 ms-5 me-5">
    <div class="card mb-3">
      <div class="card-header">
        Cadastro de usuario
      </div>

      <c:if test="${not empty mensagem}">
        <div class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem}</div>
      </c:if>

      <c:if test="${not empty erro}">
        <div class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}</div>
      </c:if>

      <div class="card-body">
        <form action="users" method="post">
          <div class="form-group">
            <label for="id-nome">Nome</label>
            <input type="text" name="nome" id="id-nome" class="form-control">
          </div>
          <div class="form-group">
            <label for="id-email">Email</label>
            <input type="email" name="email" id="id-email" class="form-control">
          </div>
          <div class="form-group">
            <label for="id-data_nascimento">Data de Nascimento</label>
            <input type="date" name="data_nascimento" id="id-data_nascimento" class="form-control">
          </div>
          <div class="form-group">
            <label for="id-senha">Senha</label>
            <input type="password" name="senha" id="id-senha" class="form-control">
          </div>
          <div class="form-group">
            <label for="id-senha-confirmar-senha">Confirmar Senha</label>
            <input type="password" name="confirmar-senha" id="id-senha-confirmar-senha" class="form-control">
          </div>
          <input type="submit" value="Salvar" class="btn btn-primary mt-3">
          <a href="index.jsp" class="btn btn-warning mt-3">Voltar a tela inicial</a>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>