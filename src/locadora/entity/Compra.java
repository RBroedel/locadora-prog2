package locadora.entity;

import java.time.LocalDate;
import java.util.List;

public class Compra {
    private Long id;
    private Long idCliente;
    private LocalDate dataCompra;
    private Double valor;
    private List<Long> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Long> getItens() {
        return itens;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setItens(List<Long> itens) {
        this.itens = itens;
    }

}
