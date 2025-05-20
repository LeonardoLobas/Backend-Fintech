<%@ page session="false" %>
<%
  String currentPage = request.getRequestURI();
  String contextPath = request.getContextPath();

  boolean isLoginPage = currentPage.contains("loginUser.jsp");
  boolean isCadastroPage = currentPage.contains("cadastroUser.jsp");
  boolean isRoot = currentPage.equals(contextPath) || currentPage.equals(contextPath + "/");
%>

<header>
  <nav class="navbar navbar-expand-lg" style="background-color: #008b8b;">
    <div class="container-fluid">
      <a class="navbar-brand text-white" href="./index.jsp">
        <img src="./resources/images/Logo.svg" alt="Logo" class="d-inline-block align-text-top">
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav">
          <% if (!isLoginPage && !isCadastroPage && !isRoot) { %>
          <li class="nav-item ms-5">
            <a class="nav-link text-white" href="./loginUser.jsp">Login</a>
          </li>
          <li class="nav-item ms-5">
            <a class="btn btn-light" href="./cadastroUser.jsp">Comece a gerenciar</a>
          </li>
          <% } %>
        </ul>
      </div>
    </div>
  </nav>
</header>
