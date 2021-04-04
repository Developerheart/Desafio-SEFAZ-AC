package br.gov.ac.sefaz.treinamento.financas.dao;


import br.gov.ac.sefaz.treinamento.financas.entities.LancamentoFinanceiro;
import br.gov.ac.sefaz.treinamento.financas.enums.TipoLancamento;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LancamentoInsert {

    private static Connection conn;

    public static void insertLancamento(LancamentoFinanceiro lancamentoFinanceiro){

        try {
            conn = ConnectionFactory.criaConnection();
            String sqlToInsert =  "INSERT INTO treinamento.lancamentos (descricao, tipo_lancamento, vencimento, status, valor) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlToInsert);
            ps.setString(1, lancamentoFinanceiro.getDescricao());
            ps.setString(2, String.valueOf(lancamentoFinanceiro.getTipoLancamento().ordinal()));
            ps.setDate(3 , new java.sql.Date(lancamentoFinanceiro.getDate().getTime()));
            ps.setBoolean(4, lancamentoFinanceiro.getStatus());
            ps.setBigDecimal(5, lancamentoFinanceiro.getValor());
            ps.execute();
            System.out.println("Adicionado com sucesso");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat psc = new SimpleDateFormat("yyyy/MM/dd");
        LancamentoFinanceiro lan = new LancamentoFinanceiro("ARROZ", TipoLancamento.DESPESA, psc.parse("2021/04/08"), false, new BigDecimal("1000.20"));

        insertLancamento(lan);


    }
}
