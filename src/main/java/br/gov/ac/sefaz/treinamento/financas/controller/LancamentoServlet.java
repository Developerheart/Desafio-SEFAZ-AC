package br.gov.ac.sefaz.treinamento.financas.controller;

import br.gov.ac.sefaz.treinamento.financas.dao.Lancamentos;
import br.gov.ac.sefaz.treinamento.financas.entities.LancamentoFinanceiro;
import br.gov.ac.sefaz.treinamento.financas.enums.TipoLancamento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static br.gov.ac.sefaz.treinamento.financas.dao.Lancamentos.insertLancamento;

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

            case "Insert":
                //response.getWriter().append("Ação: ").append(acao);
                response.getWriter().append("  ").append(request.getParameter("descricao"));
                insert(request, response);
                break;
            default:
                break;
        }

        //response.getWriter().append("Acao: ").append(acao);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {

      //try {
      //    response.getWriter().append("Ação: ").append(request.getParameter("descricao"));
      //} catch (IOException e) {
      //    e.printStackTrace();
      //}
        //SimpleDateFormat psc = new SimpleDateFormat("dd/MM/yyyy");
        //try {
            //LancamentoFinanceiro lan = new LancamentoFinanceiro(request.getParameter("descricao"),
                    //TipoLancamento.valueOf(request.getParameter("tipoLancamento")),
                    //psc.parse(request.getParameter("vencimento")),
                    //Boolean.valueOf(request.getParameter("status")),
                   // new BigDecimal(request.getParameter("valor")));
           // insertLancamento(lan);
           // RequestDispatcher dispatcher =  request.getRequestDispatcher("index.jsp");
            //dispatcher.forward(request, response);
       // } catch (ParseException | ServletException | IOException e) {
        //    e.printStackTrace();
        }
       // }



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
        response.getWriter().append("oal mundo");
        request.getRequestDispatcher("src/main/webapp/update.jsp");
                //response.getWriter().append("Ação: ").append(acao);
        String nome = request.getParameter("Descrição");
        response.getWriter().append(nome);
        //insert(request, response);

    }
}
