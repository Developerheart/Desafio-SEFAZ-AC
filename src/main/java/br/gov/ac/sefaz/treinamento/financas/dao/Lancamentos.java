package br.gov.ac.sefaz.treinamento.financas.dao;


import br.gov.ac.sefaz.treinamento.financas.entities.LancamentoFinanceiro;
import br.gov.ac.sefaz.treinamento.financas.enums.TipoLancamento;

import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Lancamentos {

    private static Connection conn;

    public static void insertLancamento(LancamentoFinanceiro lancamentoFinanceiro) {

        try {
            conn = ConnectionFactory.criaConnection();
            String sqlToInsert = "INSERT INTO treinamento.lancamentos (descricao, tipo_lancamento, vencimento, status, valor) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlToInsert);
            ps.setString(1, lancamentoFinanceiro.getDescricao());
            ps.setString(2, String.valueOf(lancamentoFinanceiro.getTipoLancamento().ordinal()));
            ps.setDate(3, new java.sql.Date(lancamentoFinanceiro.getDate().getTime()));
            ps.setBoolean(4, lancamentoFinanceiro.getStatus());
            ps.setBigDecimal(5, lancamentoFinanceiro.getValor());
            ps.execute();
            System.out.println("Adicionado com sucesso");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static List<LancamentoFinanceiro> listAll() {

        List<LancamentoFinanceiro> lista = new ArrayList<>();
        try {
            conn = ConnectionFactory.criaConnection();
            String sql = "SELECT * FROM lancamentos";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                LancamentoFinanceiro lan = new LancamentoFinanceiro();
                lan.setId((long) rs.getInt("id"));
                lan.setDescricao(rs.getString("descricao"));
                lan.setTipoLancamento(TipoLancamento.values()[rs.getInt("tipo_lancamento")]);
                lan.setDate(rs.getDate("vencimento"));
                lan.setStatus(rs.getBoolean("status"));
                lan.setValor(rs.getBigDecimal("valor"));
                lista.add(lan);
                System.out.println(lan.toString());
            }
            ps.close();
            rs.close();

            //lista.forEach(l -> System.out.println(l));
            return lista;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fechaConn(conn);
        }
        return lista;
    }


    public static LancamentoFinanceiro searchForId(Long id) {
        try {
            LancamentoFinanceiro lan = new LancamentoFinanceiro();
            conn = ConnectionFactory.criaConnection();
            String sql = "SELECT * FROM lancamentos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                lan.setId((long) rs.getInt("id"));
                lan.setDescricao(rs.getString("descricao"));
                lan.setTipoLancamento(TipoLancamento.values()[rs.getInt("tipo_lancamento")]);
                lan.setDate(rs.getDate("vencimento"));
                lan.setStatus(rs.getBoolean("status"));
                lan.setValor(rs.getBigDecimal("valor"));
                System.out.println(lan.toString());
            }
            ps.close();
            rs.close();
            return lan;

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionFactory.fechaConn(conn);

        }
        return null;
    }

    public static boolean updateLancamento(LancamentoFinanceiro lancamentoFinanceiro) {
        try {

            conn = ConnectionFactory.criaConnection();
            String sql = "update lancamentos set descricao = ?, tipo_lancamento = ?, vencimento = ?, status = ?, valor = ? where id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, lancamentoFinanceiro.getDescricao());
                ps.setString(2, String.valueOf(lancamentoFinanceiro.getTipoLancamento().ordinal()));
                ps.setDate(3, new Date(lancamentoFinanceiro.getDate().getTime()));
                ps.setBoolean(4, lancamentoFinanceiro.getStatus());
                ps.setBigDecimal(5, lancamentoFinanceiro.getValor());
                ps.setLong(6, lancamentoFinanceiro.getId());
                ps.executeUpdate();
                System.out.println("Update feito comsucesso");
                ps.close();
                ConnectionFactory.fechaConn(conn);


            } catch (SQLException e) {
                throw new SQLException(e.getMessage());
            }

            return true;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean removeLan(LancamentoFinanceiro lancamentoFinanceiro) {
        try {
            conn = ConnectionFactory.criaConnection();
            String sql = "DELETE FROM lancamentos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, lancamentoFinanceiro.getId());
            ps.execute();
            ps.close();
            System.out.println("Removido com sucesso");
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }finally {
           ConnectionFactory.fechaConn(conn);
        }
    }

    public static void main(String[] args) throws ParseException {
        //SimpleDateFormat psc = new SimpleDateFormat("yyyy/MM/dd");
        //LancamentoFinanceiro lan = new LancamentoFinanceiro("Conta de Agua", TipoLancamento.DESPESA, psc.parse("2021/04/08"), false, new BigDecimal("1000.20"));
        //insertLancamento(lan);
        //LancamentoFinanceiro lan = new LancamentoFinanceiro();
        //searchForId(2L);
        //lan.setId(2L);
        //before
        //updateLancamento(lan);
        listAll();
        //after
        //removeLan(lan);
        //searchForId(2L);

    }
}
