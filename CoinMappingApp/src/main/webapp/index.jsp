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
  <title>JSP - Hello World</title>
  <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>

<main>
  <h1>Pagina Home</h1>
</main>

<%@include file="footer.jsp" %>
</body>
</html>
