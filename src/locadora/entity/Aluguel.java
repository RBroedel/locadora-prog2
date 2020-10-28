package locadora.entity;
import java.sql.Date;
import java.util.List;

public class Aluguel {

    private long id;
    private long idCliente;
    private Date dataAluguel;
    private Date dataDevolução;
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
	public Date getDataDevolução() {
		return dataDevolução;
	}
	public void setDataDevolução(Date dataDevolução) {
		this.dataDevolução = dataDevolução;
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

    public Aluguel(long id, long idCliente, Date dataAluguel, Date dataDevolução, Double valor, List<Long> itens) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataAluguel = dataAluguel;
        this.dataDevolução = dataDevolução;
        this.valor = valor;
        this.itens = itens;
    }
    

}
