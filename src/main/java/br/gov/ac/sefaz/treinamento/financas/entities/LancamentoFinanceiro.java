package br.gov.ac.sefaz.treinamento.financas.entities;

import br.gov.ac.sefaz.treinamento.financas.enums.TipoLancamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class LancamentoFinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private TipoLancamento tipoLancamento;
    private Date date;
    private Boolean status;
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LancamentoFinanceiro that = (LancamentoFinanceiro) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(descricao, that.descricao)) return false;
        if (tipoLancamento != that.tipoLancamento) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(status, that.status)) return false;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (tipoLancamento != null ? tipoLancamento.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LancamentoFinanceiro{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", tipoLancamento=" + tipoLancamento +
                ", date=" + date +
                ", status=" + status +
                ", valor=" + valor +
                '}';
    }
}
