package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import locadora.entity.Item;
import locadora.entity.Cliente;
import locadora.entity.Colecao;
import locadora.entity.Compra;
import locadora.menu.ClienteMenu;
import locadora.menu.ItemMenu;
import locadora.menu.ColecaoMenu;
import locadora.menu.CompraMenu;

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

		Scanner sc1 = new Scanner(System.in);

		do {
			System.out.println(
					"1 - Sair; 2 - Cadastrar Cliente; 3 - Cadastrar Colecao; 4 - Cadastrar Livro; 5 - Realizar Compras;");
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
						if (itemMenu.cadastraItem(itens, colecoes) == true) {
							System.out.println("Livro cadastrado com sucesso!");

						} else {
							System.out.println("Livro nao foi cadastrado");
						}
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
				default:
					break;
			}

		} while (opt != 1);
	}
}