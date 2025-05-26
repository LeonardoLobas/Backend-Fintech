<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  // Evita cache no navegador
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
<%@ include file="header.jsp" %>

<main class="p-4" style="background-color: #f9fafb">
  <div class="shadow-sm rounded p-4" style="min-height: 80vh; background-color: #ffffff">
    <h1 class="mb-0" style="color: #008b8b; font-size: 1.5rem;">Visão geral</h1>
    <div class="row g-3 mt-3">

      <div class="col-12 col-md-4">
        <div class="border rounded p-2 mb-2" style="background-color: #e9f7ef;">
          <h6 class="fw-semibold mb-1" style="color: #157347;">Total de Receitas</h6>
          <p class="mb-0 small">
            <strong style="color: #157347;">R$ <c:out value="${totalReceita}" /></strong>
          </p>
        </div>

        <label for="valorReceita" class="form-label fw-semibold" style="color: #157347; font-size: 1.2rem;">Adicionar receita</label>

        <form action="index" method="post">
          <input type="hidden" name="acao" value="cadastrar" />

          <div class="input-group mb-2">
            <input
                    type="number"
                    min="0"
                    step="0.01"
                    class="form-control"
                    id="valorReceita"
                    name="valor"
                    placeholder="R$ 0,00"
                    required />
            <button class="btn btn-success" type="submit">+</button>
          </div>

          <input
                  type="text"
                  class="form-control mb-2"
                  name="descricao"
                  placeholder="Descrição da receita"
                  required />

          <label for="tipoReceitaId" class="form-label fw-semibold">Tipo de Receita</label>
          <select
                  class="form-select mb-2"
                  name="tipoReceitaId"
                  id="tipoReceitaId"
                  >
            <option value="">Selecione um tipo</option>
            <c:forEach var="tipo" items="${tiposReceita}">
              <option value="${tipo.id}">
                <c:out value="${tipo.nome}" />
              </option>
            </c:forEach>
          </select>

          <input type="hidden" name="nome" value="Receita" />
        </form>

        <!-- Lista de receitas -->
        <div class="border rounded p-2" style="background-color: #f8f9fa; height: 150px; overflow-y: auto;">
          <h6 class="fw-semibold" style="color: #157347;">Registros Ganhos</h6>
          <ul id="listaReceitas" class="mb-0 list-unstyled small">
            <c:forEach var="receita" items="${receitas}">
              <li>
                  ${receita.nome} - R$ ${receita.valor} - ${receita.descricao}

                <!-- Botão Remover -->
                <form action="${pageContext.request.contextPath}/index" method="post" style="display:inline;">
                  <input type="hidden" name="acao" value="remover" />
                  <input type="hidden" name="id" value="${receita.id}" />
                  <button type="submit" class="btn btn-sm btn-danger">x</button>
                </form>

                <!-- Botão Editar (futuro) -->
                <form action="receita" method="get" style="display:inline;">
                  <input type="hidden" name="acao" value="editar" />
                  <input type="hidden" name="id" value="${receita.id}" />
                  <button type="submit" class="btn btn-sm btn-primary">✎</button>
                </form>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>

      <!-- COLUNA DESPESAS -->
      <div class="col-12 col-md-4">
        <div class="border rounded p-2 mb-2" style="background-color: #fdecea;">
          <h6 class="fw-semibold mb-1" style="color: #BB2D3B;">Total de Despesas</h6>
          <p class="mb-0 small">
            <strong style="color: #BB2D3B;">R$ <c:out value="${totalDespesa}" /></strong>
          </p>
        </div>

        <label for="valorDespesa" class="form-label fw-semibold" style="color: #BB2D3B; font-size: 1.2rem;">Adicionar despesa</label>
        <form action="${pageContext.request.contextPath}/despesa" method="post">
          <div class="input-group mb-2">
            <input type="number" min="0" step="0.01" class="form-control" id="valorDespesa" name="valor" placeholder="R$ 0,00" required />
            <button class="btn btn-danger" type="submit">+</button>
          </div>

          <input type="text" class="form-control mb-2" name="descricao" placeholder="Descrição da despesa" required />

          <input type="hidden" name="nome" value="Despesa" />
        </form>

        <div class="border rounded p-2" style="background-color: #f8f9fa; height: 150px; overflow-y: auto;">
          <h6 class="fw-semibold" style="color: #BB2D3B;">Registros Gastos</h6>
          <ul id="listaDespesas" class="mb-0 list-unstyled small">
            <c:forEach var="despesa" items="${despesas}">
              <li>${despesa.nome} - R$ ${despesa.valor} - ${despesa.descricao}</li>
            </c:forEach>
          </ul>
        </div>
      </div>

      <!-- COLUNA RESULTADO PREVISTO / OBJETIVOS -->
      <div class="col-12 col-md-4">
        <label for="resultado" class="form-label fw-semibold" style="font-size: 1.2rem;">Resultado Previsto</label>
        <input type="text" class="form-control mb-2" id="resultado" placeholder="R$ 0,00" readonly style="background-color: #f1f1f1;" />

        <div class="border rounded p-2" style="background-color: #f8f9fa; height: 150px; overflow-y: auto;">
          <h6 class="fw-semibold" style="color: #008b8b;">Objetivos Registrados</h6>
          <ul id="listaObjetivos" class="mb-0 list-unstyled small">
            <!-- Se quiser, depois você adiciona objetivos aqui -->
          </ul>
        </div>
      </div>
    </div>
  </div>
</main>

<%@ include file="footer.jsp" %>

<script>
  // Calcula o resultado previsto automaticamente
  document.addEventListener('DOMContentLoaded', function() {
    const totalReceita = parseFloat('${totalReceita}') || 0;
    const totalDespesa = parseFloat('${totalDespesa}') || 0;
    const resultado = totalReceita - totalDespesa;

    document.getElementById('resultado').value = 'R$ ' + resultado.toFixed(2).replace('.', ',');
  });
</script>

</body>
</html>