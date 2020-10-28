package locadora.enums;

public enum Tipo {

	Livro( "LIVRO", 1 ), Dvd( "DVD", 2 ), Revista( "REVISTA", 3 );

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
