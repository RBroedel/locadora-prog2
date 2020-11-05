
package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import locadora.entity.Item;
import locadora.entity.Cliente;
import locadora.entity.Colecao;
import locadora.entity.Aluguel;
import locadora.menu.ClienteMenu;
import locadora.menu.ItemMenu;
import locadora.menu.ColecaoMenu;
import locadora.menu.AluguelMenu;

public class Application {

	public static void main(String[] arguments) {
		int opt = 0;
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteMenu clienteMenu = new ClienteMenu();
		List<Item> itens = new ArrayList<Item>();
		ItemMenu itemMenu = new ItemMenu();
		List<Colecao> colecoes = new ArrayList<Colecao>();
		ColecaoMenu colecaoMenu = new ColecaoMenu();
		List<Aluguel> aluguel = new ArrayList<Aluguel>();
		AluguelMenu aluguelMenu = new AluguelMenu();

		Scanner sc1 = new Scanner(System.in);

		do {
			System.out.println( "1 - sair; 2 - Cadastrar Cliente; 3 - Cadastrar Colecao; 4 - Cadastrar Livro; 6 - Aluguel de Item" );
			opt = sc1.nextInt();

			switch (opt) {
				case 2:
					try {
						clienteMenu.cadastraCliente(clientes);
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;
				
				case 3: 
					try {
						colecaoMenu.cadastraColecao(colecoes);
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;
				case 6:
					try {
						aluguelMenu.aluguelBussines(aluguel, clientes, itens);
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;
				case 4: 
					try {
						if (itemMenu.cadastroItem( itens, colecoes ) == true){
							System.out.println("Item cadastrado com sucesso!");
						} else {
							System.out.println("Item não foi cadastrado");
						}
					} catch (Exception e){
						System.out.println(e.getLocalizedMessage());
					}
					break;
				default:
					break;
			}

		} while( opt != 1 );
	}
}
