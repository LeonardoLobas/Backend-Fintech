<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma", "no-cache");
  response.setDateHeader("Expires", 0);

  HttpSession sessao = request.getSession(false);
  if (sessao == null || sessao.getAttribute("usuarioLogado") == null) {
    response.sendRedirect("loginUser.jsp");
    return;
  }
%>


<!DOCTYPE html>
<html>
<head>
  <title>CoinMapping</title>
  <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>

<main class="p-4" style="background-color: #f9fafb">
  <div class="shadow-sm rounded p-4" style="min-height: 80vh;background-color: #ffffff">
    <h1 class="mb-0"style="color: #008b8b;font-size: 1.5rem;">Visão geral</h1>
    <div class="row g-3 mt-3">

      <div class="col-12 col-md-4">
        <label for="receita" class="form-label fw-semibold" style="color: #157347; font-size: 1.2rem;">Receita</label>
        <div class="input-group mb-2">
          <input type="number" class="form-control" id="receita" placeholder="R$ 0,00">
          <button class="btn btn-success" type="button" id="addReceita">+</button>
        </div>


        <div class="border rounded p-2" style="background-color: #f8f9fa; height: 150px; overflow-y: auto;">
          <h6 class="fw-semibold" style="color: #157347;">Registros Ganhos</h6>
          <ul id="listaReceitas" class="mb-0 list-unstyled small">

          </ul>
        </div>
      </div>


      <div class="col-12 col-md-4">
        <label for="despesa" class="form-label fw-semibold" style="color: #BB2D3B; font-size: 1.2rem;">Despesa</label>
        <div class="input-group mb-2">
          <input type="number" class="form-control" id="despesa" placeholder="R$ 0,00">
          <button class="btn btn-danger" type="button" id="addDespesa">+</button>
        </div>


        <div class="border rounded p-2" style="background-color: #f8f9fa; height: 150px; overflow-y: auto;">
          <h6 class="fw-semibold" style="color: #BB2D3B;">Registros Gastos</h6>
          <ul id="listaDespesas" class="mb-0 list-unstyled small">

          </ul>
        </div>
      </div>


      <div class="col-12 col-md-4">
        <label for="resultado" class="form-label fw-semibold" style="font-size: 1.2rem;">Resultado Previsto</label>
        <input type="text" class="form-control mb-2" id="resultado" placeholder="R$ 0,00" readonly style="background-color: #f1f1f1;">


        <div class="border rounded p-2" style="background-color: #f8f9fa; height: 150px; overflow-y: auto;">
          <h6 class="fw-semibold" style="color: #008b8b;">Objetivos Registrados</h6>
          <ul id="listaObjetivos" class="mb-0 list-unstyled small">

          </ul>
        </div>
      </div>
    </div>

  </div>

</main>

<%@include file="footer.jsp" %>
</body>
</html>
