package locadora.menu;

import java.util.List;
import java.util.Scanner;

import locadora.bussines.ClienteBussines;
import locadora.entity.Cliente;

public class ClienteMenu {

	ClienteBussines clienteBussines = new ClienteBussines();
	Scanner sc1 = new Scanner( System.in );

	public void cadastraCliente( List<Cliente> clientes ) throws Exception {
		System.out.print( "Informe o Nome: " );
		String name = sc1.nextLine();

		System.out.print( "Informe o Telefone: " );
		String telefone = sc1.nextLine();

		System.out.print( "Informe o Bairro do endereço: " );
		String bairro = sc1.nextLine();

		System.out.print( "Informe se o Cliente é VIP (sim/nao): " );
		String vip = sc1.nextLine();

		clienteBussines.cadastraCliente( name, telefone, bairro, vip, clientes );
	}

}
