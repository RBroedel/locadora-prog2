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

        System.out.println("Qual produto você quer comprar?\n1 - Livro\n 2 - DVD\n 3 - Revista\n");
        int tipo = sc1.nextInt();

        if (Tipo.Livro.getCode() == tipo) {

            items.forEach(item -> {
                if (item.getTipo() == Tipo.Livro) {
                    System.out.println(item.getId() + " - " + item.getTitulo());
                }
            });

            System.out.println("comprou livro");

        } else if (Tipo.Dvd.getCode() == tipo) {
            items.forEach(item -> {
                if (item.getTipo() == Tipo.Dvd) {
                    System.out.println(item.getId() + " - " + item.getTitulo());
                }
            });

            System.out.println("comprou DVD");

        } else if (Tipo.Revista.getCode() == tipo) {
            items.forEach(item -> {
                if (item.getTipo() == Tipo.Revista) {
                    System.out.println(item.getId() + " - " + item.getTitulo());
                }
            });

            System.out.println("comprou Revista");
        }
        sc1 = new Scanner(System.in);
    }
}
