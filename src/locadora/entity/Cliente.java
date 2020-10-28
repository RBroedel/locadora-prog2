package locadora.entity;

public class Cliente {

	private long id;
	private String nome;
	private String telefone;
	private String bairro;
	private boolean vip;

	public long getId() {
		return id;
	}

	public void setId( long id ) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone( String telefone ) {
		this.telefone = telefone;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro( String bairro ) {
		this.bairro = bairro;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip( boolean vip ) {
		this.vip = vip;
	}

}
