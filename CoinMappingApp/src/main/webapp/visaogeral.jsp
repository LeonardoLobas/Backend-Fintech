<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Visão Geral - Fintech</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .saldo-positivo { color: green; }
    .saldo-negativo { color: red; }
    .categoria-card { border-radius: 10px; color: white; padding: 10px; margin-bottom: 10px; }
    .bg-orange { background-color: #f39c12; }
    .bg-blue { background-color: #2980b9; }
    .bg-red { background-color: #c0392b; }
    .dropdown-menu-end { right: 0; left: auto; }
  </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-teal" style="background-color: #00796B;">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Fintech</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" href="#">Visão Geral</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Análises Gráficas</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Investimentos</a></li>
      </ul>
      <div class="dropdown">
        <a class="btn btn-outline-light dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
          Darrell Steward
        </a>
        <ul class="dropdown-menu dropdown-menu-end">
          <li><a class="dropdown-item" href="#">Editar Perfil</a></li>
          <li><a class="dropdown-item" href="#">Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container mt-4">
    <h3 class="text-primary">Visão Geral</h3>
    <div class="row mb-3">
      <div class="col-md-4">
        <div class="card border-success">
          <div class="card-body">
            <h5 class="card-title text-success">Receita</h5>
            <h3>R$ 3.000,00 <button class="btn btn-success btn-sm">+</button></h3>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card border-danger">
          <div class="card-body">
            <h5 class="card-title text-danger">Despesas</h5>
            <h3>R$ 1.000,00 <button class="btn btn-danger btn-sm">+</button></h3>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card border-primary">
          <div class="card-body">
            <h5 class="card-title">Resultado previsto (saldo)</h5>
            <h3 class="text-success">R$ 2.000,00 <span class="text-success">↑</span></h3>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6">
        <h5>Registro de Ganhos</h5>
        <table class="table table-bordered">
          <thead><tr><th>Tipo</th><th>Data</th><th>Valor</th></tr></thead>
          <tbody>
            <tr><td>Salário</td><td>22/08/2024</td><td>R$ 2.500,00</td></tr>
            <tr><td>Dividendo</td><td>24/08/2024</td><td>R$ 500,00</td></tr>
          </tbody>
        </table>
      </div>
      <div class="col-md-6">
        <h5>Registro de Gastos</h5>
        <table class="table table-bordered">
          <thead><tr><th>Categoria</th><th>Data</th><th>Valor</th></tr></thead>
          <tbody>
            <tr><td>Academia</td><td>21/08/2024</td><td>R$ 120,00</td></tr>
            <tr><td>Moradia</td><td>15/08/2024</td><td>R$ 700,00</td></tr>
            <tr><td>Transporte</td><td>22/08/2024</td><td>R$ 180,00</td></tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6">
        <h5>Últimos investimentos</h5>
        <table class="table table-bordered">
          <thead><tr><th>Tipo</th><th>Valor Aplicado</th><th>Data Aplicação</th></tr></thead>
          <tbody>
            <tr><td>Tesouro Direto</td><td>R$ 1.000,00</td><td>22/09/2024</td></tr>
            <tr><td>Poupança</td><td>R$ 2.000,00</td><td>24/08/2024</td></tr>
            <tr><td>Fundo Tesouro IPCA</td><td>R$ 1.000,00</td><td>22/09/2024</td></tr>
          </tbody>
        </table>
      </div>
      <div class="col-md-6">
        <h5>Objetivos Registrados</h5>
        <div class="categoria-card bg-orange">Próxima Viagem <span class="float-end">22/10/2024<br>R$ 3.000,00</span></div>
        <div class="categoria-card bg-blue">Computador Novo <span class="float-end">05/06/2025<br>R$ 5.000,00</span></div>
        <div class="categoria-card bg-red">Monitor Novo <span class="float-end">10/10/2025<br>R$ 2.500,00</span></div>
        <p class="mt-2">Valor Reservado: <strong>R$ 2.500,00</strong> <button class="btn btn-dark btn-sm">+</button></p>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
