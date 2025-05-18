<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Investimentos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <style>
    .bg-green { background-color: #e8f5e9; color: #2e7d32; }
    .bg-red { background-color: #ffebee; color: #c62828; }
    .dropdown-menu { min-width: 200px; }
    .table-hover tbody tr:hover { background-color: #f1f1f1; }
    .highlight-positive { color: #2e7d32; }
    .highlight-negative { color: #c62828; }
    .custom-icon-btn { border: none; background: transparent; }
  </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-teal p-3">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Fintech</a>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item"><a class="nav-link" href="#">Visão Geral</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Análises Gráficas</a></li>
          <li class="nav-item"><a class="nav-link active" href="#">Investimentos</a></li>
        </ul>
        <div class="dropdown">
          <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" data-bs-toggle="dropdown">
            <img src="https://randomuser.me/api/portraits/men/1.jpg" alt="Foto" width="32" height="32" class="rounded-circle me-2">
            <strong>Darrell Steward</strong>
          </a>
          <ul class="dropdown-menu dropdown-menu-end">
            <li><a class="dropdown-item" href="#">Editar Perfil</a></li>
            <li><a class="dropdown-item" href="#">Logout</a></li>
          </ul>
        </div>
      </div>
    </div>
  </nav>

  <div class="container mt-4">
    <h4 class="text-teal">Investimentos</h4>
    <div class="row g-3 align-items-center mb-3">
      <div class="col-md-3">
        <select class="form-select">
          <option selected>Todos Investimentos</option>
          <option>Tipo de Investimento</option>
        </select>
      </div>
      <div class="col-md-3">
        <div class="dropdown">
          <button class="btn btn-outline-secondary dropdown-toggle w-100" type="button" data-bs-toggle="dropdown">Ordenar por</button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Data Realizada</a></li>
            <li><a class="dropdown-item" href="#">Melhores resultados</a></li>
            <li><a class="dropdown-item" href="#">Piores resultados</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md-4">
        <input type="text" class="form-control" placeholder="Busque por investimentos...">
      </div>
      <div class="col-md-2 text-end">
        <button class="btn btn-outline-secondary me-1"><i class="fas fa-chart-bar"></i></button>
        <button class="btn btn-outline-primary"><i class="fas fa-plus"></i></button>
      </div>
    </div>

    <div class="table-responsive">
      <table class="table table-hover text-center">
        <thead class="table-light">
          <tr>
            <th>Data</th>
            <th>Tipo</th>
            <th>Valor Aplicado</th>
            <th>Valor Atual</th>
            <th>Resultado</th>
            <th>Variação</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>01/07/2024</td>
            <td>Tipo Invest.</td>
            <td>R$ 2.000,00</td>
            <td class="highlight-positive">R$ 2.300,00</td>
            <td class="highlight-positive">R$ 300,00</td>
            <td class="highlight-positive">15,00%</td>
            <td>
              <div class="dropdown">
                <button class="custom-icon-btn" data-bs-toggle="dropdown"><i class="fas fa-ellipsis-v"></i></button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Excluir investimento</a></li>
                  <li><a class="dropdown-item" href="#">Editar investimento</a></li>
                  <li><a class="dropdown-item" href="#">Mais informações</a></li>
                </ul>
              </div>
            </td>
          </tr>
          <tr>
            <td>25/12/2024</td>
            <td>Tipo Invest.</td>
            <td>R$ 1.700,00</td>
            <td class="highlight-positive">R$ 1.800,00</td>
            <td class="highlight-positive">R$ 100,00</td>
            <td class="highlight-positive">5,88%</td>
            <td>...</td>
          </tr>
          <tr>
            <td>24/02/2024</td>
            <td>Tipo Invest.</td>
            <td>R$ 5.000,00</td>
            <td class="highlight-negative">R$ 4.300,00</td>
            <td class="highlight-negative">-R$ 700,00</td>
            <td class="highlight-negative">-15,00%</td>
            <td>...</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="d-flex justify-content-between mt-4">
      <div class="p-2 bg-green rounded"><strong>Resultados</strong>: R$ 2.300,00</div>
      <div class="p-2 bg-red rounded">R$ 1.000,00</div>
    </div>

    <div class="mt-4">
      <p>Não sabe onde aplicar seu dinheiro? <a href="#">Clique aqui e descubra</a></p>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>