package locadora.enums;

public enum Tipo {

	LIVRO( "LIVRO", 1 ), DVD( "DVD", 2 ), REVISTA( "REVISTA", 3 ), TIPO_INVALIDO("INVALIDO", 4);

	private String name;
	private int code;

	Tipo( String name, int code ) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}
}
