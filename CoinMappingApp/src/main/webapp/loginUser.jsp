<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="./resources/css/bootstrap.css">

  <style>
    .login-card {
      background: #fff;
      padding: 2rem 2.5rem;
      box-shadow: 0 4px 15px rgb(0 0 0 / 0.1);
      border-radius: 0.3rem;
      width: 320px;
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

    .forgot-password {
      font-size: 0.8rem;
      float: right;
      margin-top: 4px;
      color: #0d6efd;
      text-decoration: none;
    }

    .forgot-password:hover {
      text-decoration: underline;
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

    .divider {
      display: flex;
      align-items: center;
      text-align: center;
      margin: 1.5rem 0 1rem 0;
      color: #a8a8a8;
    }

    .divider::before, .divider::after {
      content: '';
      flex: 1;
      border-bottom: 1px solid #a8a8a8;
    }

    .divider:not(:empty)::before {
      margin-right: .75em;
    }

    .divider:not(:empty)::after {
      margin-left: .75em;
    }

    .social-btn {
      width: 48%;
      font-size: 0.9rem;
      font-weight: 600;
      display: flex;
      align-items: center;
      justify-content: center;
      gap: 6px;
    }

    .social-btn-google,
    .social-btn-facebook {
      color: #0d6efd;
      border: 1px solid #0d6efd;
      background-color: transparent;
    }

    .social-btn-google:hover,
    .social-btn-facebook:hover {
      background-color: #0d6efd;
      color: white;
    }

    .register-text {
      font-size: 0.85rem;
      margin-top: 1.5rem;
      color: #555;
    }

    .register-text a {
      color: #0d6efd;
      text-decoration: none;
      font-weight: 600;
    }

    .register-text a:hover {
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
    <h5>Seja Bem-vindo de Volta !</h5>

    <form action="login" method="post">
        <input type="email" class="form-control mb-2" name="email" placeholder="Email" required>
        <input type="password" class="form-control" name="password" placeholder="Password" required>
      <a href="#" class="forgot-password">Esqueceu sua senha?</a>

      <button type="submit" class="btn btn-login w-100">Entrar</button>
    </form>

    <div class="divider">Ou</div>

    <div class="d-flex justify-content-between gap-2">
      <button class="btn social-btn social-btn-google" type="button">
        <i class="bi bi-google"></i> Google
      </button>
      <button class="btn social-btn social-btn-facebook" type="button">
        <i class="bi bi-facebook"></i> Facebook
      </button>
    </div>

    <div class="register-text">
      Ainda não possui uma conta? <a href="./cadastroUser.jsp">Cadastre-se</a>
    </div>
  </div>
</main>

<%@include file="footer.jsp" %>

<!-- Bootstrap JS Bundle -->
<script src="./resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>
