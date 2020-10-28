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
						clienteMenu.cadastraCliente( clientes );
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
