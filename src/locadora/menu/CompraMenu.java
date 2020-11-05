package locadora.menu;

import java.util.List;
import java.util.Scanner;

import locadora.bussines.CompraBusiness;
import locadora.entity.Cliente;
import locadora.entity.Compra;
import locadora.entity.Item;
import locadora.enums.Tipo;

public class CompraMenu {
    CompraBusiness compraBusiness = new CompraBusiness();
    Scanner sc1 = new Scanner(System.in);

    public void compraItem(List<Compra> compras, List<Cliente> clientes, List<Item> items) {

        clientes.forEach(cliente -> System.out.println(
                cliente.getId() + " " + cliente.getNome() + " " + cliente.getBairro() + " " + cliente.isVip()));
        System.out.println("Escolha o cliente: ");
        Long idCliente = sc1.nextLong();

        int opt = 0;
        do {
            System.out.println("Qual produto você quer comprar?\n1 - Livro\n 2 - DVD\n 3 - Revista\n");
            int tipo = sc1.nextInt();

            if (Tipo.Livro.getCode() == tipo) {
                items.forEach(item -> {
                    if (1 == Tipo.Livro.getCode()) {
                        System.out.println(item.getId().toString() + " - " + item.getTitulo().toString());
                    }
                });
                System.out.println("comprou livro");

            } else if (Tipo.Dvd.getCode() == tipo) {
                items.forEach(item -> {
                    if (2 == Tipo.Dvd.getCode()) {
                        System.out.println(item.getId().toString() + " - " + item.getTitulo().toString());
                    }
                });
                System.out.println("comprou DVD");

            } else if (Tipo.Revista.getCode() == tipo) {
                items.forEach(item -> {
                    if (3 == Tipo.Revista.getCode()) {
                        System.out.println(item.getId().toString() + " - " + item.getTitulo().toString());
                    }
                });
                System.out.println("comprou Revista");
            }
            System.out.println("Deseja comprar mais alguma coisa?\n1 - nao\n2 - sim");
            opt = sc1.nextInt();
        } while (opt != 1);

        sc1 = new Scanner(System.in);
    }
}
