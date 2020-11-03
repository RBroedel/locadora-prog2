package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import locadora.entity.Cliente;
import locadora.entity.Colecao;
import locadora.menu.ClienteMenu;
import locadora.menu.ColecaoMenu;

public class Application {

	public static void main( String[] arguments ) {
		int opt = 0;
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteMenu clienteMenu = new ClienteMenu();
		List<Colecao> colecoes = new ArrayList<Colecao>();
		ColecaoMenu colecaoMenu = new ColecaoMenu();

		Scanner sc1 = new Scanner( System.in );

		do {
			System.out.println( "1 - sair; 2 - Cadastrar Cliente; 3 - Cadastrar Colecao;" );
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
				case 3: 
					try {
						if (colecaoMenu.cadastraColecao(colecoes) == true){
							System.out.println("Colecao cadastrada com sucesso!");
						} else {
							System.out.println("Colecao nao foi cadastrada com sucesso");
						}
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;
				default:
					break;
			}

		} while( opt != 1 );
	}
}
