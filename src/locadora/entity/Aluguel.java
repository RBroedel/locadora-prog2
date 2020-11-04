package locadora.entity;
import java.util.Date;
import java.util.List;

public class Aluguel {

    private long id;
    private long idCliente;
    private Date dataAluguel;
    private Date dataDevolucao;
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
	public Date getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
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

}
