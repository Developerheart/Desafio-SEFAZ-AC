<%--
  Created by IntelliJ IDEA.
  User: Leona
  Date: 06/04/2021
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*,java.util.*"%>
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
            <a class="me-3 py-2 text-dark text-decoration-none"
               href="<c:url value="http://localhost:8080/financas/Lancamento?acao=listAll"/>">Listar</a>
        </nav>
    </header>

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center ">
        <h1 class="display-4 fw-normal">Novo Lançamento</h1>
        <p class="fs-5 text-muted">Sistema de controle financeiro de contas a pagar e receber</p>
    </div>

</div>
//action="<c:url value="http://localhost:8080/financas/Lancamento"/>"
<main>
    <form method="post" action="http://localhost:8080/financas/Lancamento">

            <div  id="Descrição" class="form-floating mb-4">
                <input type="text" class="form-control form-control-lg" id="Descrição" placeholder="descricao">
                <label for="Descrição">Descrição</label>
            </div>

            <div class="form-floating mb-4">

                <input type="number" class="form-control" id="status" placeholder="status">
                <label for="status">status (1/0)</label>
            </div>



        <div class="fow g-2 mb-3">
            <div class="form-floating mb-4 ">
                <input type="date" class="form-control" id="vencimento" placeholder="Vencimento">
                <label for="vencimento">Vencimento</label>
            </div>

            <div class="input-group mb-3">
                <label class="input-group-text" for="tipoLancamento">Tipo de Lancamento</label>
                <select class="form-select" id="tipoLancamento">
                    <option selected>Choose...</option>
                    <option value="1">DESPESA</option>
                    <option value="2">RECEITA</option>
                </select>
            </div>


            <div class="form-floating mb-4">

                <input type="number" class="form-control" id="Valor" placeholder="000,00">
                <label for="Valor">Valor</label>
            </div>
            <button type="submit" class="btn btn-primary" >SUBMIT</button>


        </div>

    </form>

</main>

<script src="assets/bootstrap-5b/js/bootstrap.bundle.min.js"></script>

</body>
</html>
