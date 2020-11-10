
package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import locadora.entity.Aluguel;
import locadora.entity.Cliente;
import locadora.entity.Colecao;
import locadora.entity.Compra;
import locadora.entity.Item;
import locadora.menu.AluguelMenu;
import locadora.menu.ClienteMenu;
import locadora.menu.ColecaoMenu;
import locadora.menu.CompraMenu;
import locadora.menu.ItemMenu;
public class Application {

	public static void main(String[] arguments) {
		int opt = 0;
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteMenu clienteMenu = new ClienteMenu();
		List<Item> itens = new ArrayList<Item>();
		ItemMenu itemMenu = new ItemMenu();
		List<Colecao> colecoes = new ArrayList<Colecao>();
		ColecaoMenu colecaoMenu = new ColecaoMenu();
		List<Compra> compras = new ArrayList<Compra>();
		CompraMenu compraMenu = new CompraMenu();
		List<Aluguel> aluguel = new ArrayList<Aluguel>();
		AluguelMenu aluguelMenu = new AluguelMenu();

		Scanner sc1 = new Scanner(System.in);

		do {
			System.out.println(
					"1 - Sair; 2 - Cadastrar Cliente; 3 - Cadastrar Colecao; 4 - Cadastrar Item; 5 - Realizar Compras; 6 - Aluguar de Item; 7 - Devolver Item");
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
				case 4:
					try {
						itemMenu.cadastroItem(itens, colecoes);
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;
				case 5:
					try {
						compraMenu.compraItem(compras, clientes, itens);
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;
				case 6:
					try {
						aluguelMenu.aluguel(aluguel, clientes, itens);
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;
				case 7:
					try {
						aluguelMenu.devolucao(aluguel, clientes, itens);
					} catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;

				default:
					break;
			}
			sc1 = new Scanner(System.in);
		} while (opt != 1);
	}
}
