package locadora.bussines;

import java.util.List;

import locadora.entity.Cliente;

public class ClienteBussines {

	public void cadastraCliente( String nome, String telefone, String bairro, String vip, List<Cliente> clientes ) throws Exception {
		if( !isClienteValido( nome, telefone, bairro, vip ) )
			throw new Exception( "Dados inválidos." );

		var cliente = new Cliente();
		cliente.setId( getLastId( clientes ) + 1 );
		cliente.setNome( nome );
		cliente.setTelefone( telefone );
		cliente.setBairro( bairro );
		cliente.setVip( vip.equals( "sim" ) ? true : false );

		clientes.add( cliente );
	}

	private boolean isClienteValido( String nome, String telefone, String bairro, String vip ) {
		if( nome.equals( "" ) )
			return false;

		if( telefone.equals( "" ) )
			return false;

		if( bairro.equals( "" ) )
			return false;

		if( vip.equals( "" ) || !vip.equals( "sim" ) || vip.equals( "nao" ) )
			return false;

		return true;
	}

	private Long getLastId( List<Cliente> clientes ) {
		if( clientes.size() > 0 )
			return clientes.get( clientes.size() - 1 ).getId();

		return Long.parseLong( "0" );
	}

}
