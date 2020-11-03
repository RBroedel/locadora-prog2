package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import locadora.entity.Cliente;
import locadora.menu.ClienteMenu;

public class Application {

	public static void main( String[] arguments ) {
		int opt = 0;
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteMenu clienteMenu = new ClienteMenu();

		Scanner sc1 = new Scanner( System.in );

		do {
			System.out.print( "1 - sair; 2 - Cadastrar Cliente;" );
			opt = sc1.nextInt();

			switch ( opt ) {
				case 2:
					try {
						if( clienteMenu.cadastraCliente( clientes ) )
							System.out.println( "Usuário salvo com sucesso!" );
						else
							System.out.println( "Não foi possível salvar o Usuário!" );
					} catch ( Exception e ) {
						System.out.println( e.getLocalizedMessage() );
					}
					break;
				default:
					break;
			}

		} while( opt != 1 );
	}
}
