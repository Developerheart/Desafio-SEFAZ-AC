<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="assets/bootstrap-5b/css/bootstrap.min.css" rel="stylesheet">


    <title>Sistema Finanças</title>
</head>
<body>
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check" viewBox="0 0 16 16">
        <title>Check</title>
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
    </symbol>
</svg>

<div class="container py-3">


    <header class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center text-dark text-decoration-none">
            <img src="https://img1.gratispng.com/20180319/wge/kisspng-money-funding-finance-bank-money-flat-money-png-5ab065ad9cba40.127760641521509805642.jpg"
                 width="28" alt="logo">
            <span class="fs-4">Sistema de finanças</span>
        </a>

        <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
            <a class="me-3 py-2 text-dark text-decoration-none" href="#">Listar</a>
        </nav>
    </header>

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
        <h1 class="display-4 fw-normal">Lançamentos</h1>
        <p class="fs-5 text-muted">Sistema de controle financeiro de contas a pagar e receber</p>
    </div>

    <main>

        <h2 class="display-6 text-center mb-4">Controle financeiro</h2>
        <button class="btn btn-primary" type="submit">Novo lançamento</button>
        <div class="table-responsive">
            <table class="table text-center">
                <thead>
                <tr>
                    <th style="width: 30%;">Lançamento</th>
                    <th style="width: 22%;">Vencimento</th>
                    <th style="width: 15%;">Status</th>
                    <th style="width: 20%;">Valor</th>
                    <th style="width: 22%;">Ações</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="text-start">Conta de luz</td>
                    <td class="text-start">10/04/20021</td>
                    <td class="text-start">EFETIVADO</td>
                    <td class="text-start">102,25</td>
                    <td class="text-start">
                        <button type="button" class="btn btn-primary btn-sm">Editar</button>
                        <button type="button" class="btn btn-secondary btn-sm">Remover</button>
                    </td>
                </tr>
                <tbody>
                <tr>
                    <td class="text-start" colspan="4">Totais</td>
                    <td>1000,10</td>
                </tr>
                <tr>
                    <td class="text-start" colspan="4">Receita</td>
                    <td>1000,10</td>
                </tr>
                <tr>
                    <td class="text-start" colspan="4">SALDO</td>
                    <td>0,00</td>
                </tr>
                </tbody>

            </table>
        </div>
    </main>
</div>


<script src="assets/bootstrap-5b/js/bootstrap.bundle.min.js"></script>

</body>
</html>
