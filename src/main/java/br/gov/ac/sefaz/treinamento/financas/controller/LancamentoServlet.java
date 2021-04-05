package br.gov.ac.sefaz.treinamento.financas.controller;

import br.gov.ac.sefaz.treinamento.financas.dao.Lancamentos;
import br.gov.ac.sefaz.treinamento.financas.entities.LancamentoFinanceiro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/Lancamento")
public class LancamentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        response.getWriter().append("Ação: ").append(acao);

        switch (acao) {
            case "listAll":
                listaTodos(request, response);
                break;
            default:
                break;
        }

        //response.getWriter().append("Acao: ").append(acao);
    }

    private void listaTodos(HttpServletRequest request, HttpServletResponse response) {

        try {
            List<LancamentoFinanceiro> listaLan = new ArrayList<>();
            listaLan.addAll(Lancamentos.listAll());

            request.setAttribute("lancamentos", listaLan);
            RequestDispatcher dispatcher =  request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
            //response.getWriter().append("List: ").append(listaLan.toString());

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
