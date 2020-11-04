  
package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import locadora.entity.Item;
import locadora.enums.Tipo;
import locadora.entity.Cliente;
import locadora.menu.ClienteMenu;
import locadora.menu.ItemMenu;

public class Application {

	public static void main( String[] arguments ) {
		int opt = 0;
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteMenu clienteMenu = new ClienteMenu();
		List<Item> itens = new ArrayList<Item>();
		ItemMenu itemMenu = new ItemMenu();

		Scanner sc1 = new Scanner( System.in );

		do {
			System.out.println( "1 - sair; 2 - Cadastrar Cliente; 4 - Cadastrar Livro;" );
			opt = sc1.nextInt();

			switch ( opt ) {
				case 2:
					try {
						clienteMenu.cadastraCliente( clientes );
					} catch ( Exception e ) {
						System.out.println( e.getLocalizedMessage() );
					}
					break;
				case 4: 
					try {
						if (itemMenu.cadastraItem(itens) == true){
							System.out.println("Livro cadastrado com sucesso!");
						} else {
							System.out.println("Livro nao foi cadastrado");
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