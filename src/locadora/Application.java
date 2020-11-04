package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import locadora.entity.Cliente;
import locadora.entity.Colecao;
import locadora.entity.Aluguel;
import locadora.menu.ClienteMenu;
import locadora.menu.ColecaoMenu;
import locadora.menu.AluguelMenu;

public class Application {

	public static void main(String[] arguments) {
		int opt = 0;
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteMenu clienteMenu = new ClienteMenu();
		List<Colecao> colecoes = new ArrayList<Colecao>();
		ColecaoMenu colecaoMenu = new ColecaoMenu();
		List<Aluguel> aluguel = new ArrayList<Aluguel>();
		AluguelMenu aluguelMenu = new AluguelMenu();

		Scanner sc1 = new Scanner(System.in);

		do {
			System.out.println("1 - sair; 2 - Cadastrar Cliente; 3 - Cadastrar Colecao;");
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
						aluguelMenu.aluguelBussines();
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
