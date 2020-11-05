package locadora.menu;

import java.util.List;
import java.util.Scanner;

import locadora.bussines.ClienteBussines;
import locadora.entity.Cliente;

public class ClienteMenu {

	ClienteBussines clienteBussines = new ClienteBussines();

	public void cadastraCliente(List<Cliente> clientes) throws Exception {
		Scanner sc1 = new Scanner(System.in);

		System.out.print("Informe o Nome: ");
		String name = sc1.nextLine();

		System.out.print("Informe o Telefone: ");
		String telefone = sc1.nextLine();

		System.out.print("Informe o Bairro do endereço: ");
		String bairro = sc1.nextLine();

		System.out.print("Informe se o Cliente é VIP (sim / nao): ");
		String vip = sc1.nextLine();

		if (clienteBussines.cadastraCliente(name, telefone, bairro, vip, clientes)) {
			System.out.println("Usuário salvo com sucesso!");
		} else {
			System.out.println("Não foi possível salvar o Usuário!");
		}

		sc1 = new Scanner( System.in );
	}

}
