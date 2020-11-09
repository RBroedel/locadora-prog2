package locadora.entity;

import java.util.List;

import java.time.LocalDate;

public class Aluguel {

	private long id;
	private long idCliente;
	private LocalDate dataAluguel;
	private LocalDate dataDevolucao;
	private Double valor;
	private List<Long> itens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
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

	public void setItens(List<Long> itens) {
		this.itens = itens;
	}

	public LocalDate getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(LocalDate dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}
