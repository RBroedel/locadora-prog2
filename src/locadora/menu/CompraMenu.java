package locadora.menu;

import java.util.ArrayList;
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
        List<Long> itemsToCompra = new ArrayList<Long>();

        do {
            System.out.println("Qual produto você quer comprar?\n 1 - Livro\n 2 - DVD\n 3 - Revista\n");
            int inputTipo = sc1.nextInt();

            // TIPO LIVRO
            if (Tipo.LIVRO.getCode() == inputTipo) {
                items.forEach(item -> {
                    if (item.getTipo().getCode() == Tipo.LIVRO.getCode() && item.getEstoque() > 0
                            && !itemsToCompra.contains(new ArrayList<Long>().add(item.getId()))) {
                        System.out.println("ID: " + item.getId() + " - Título do LIVRO: " + item.getTitulo()
                                + " - Tem no estoque: " + item.getEstoque());
                    }
                });

                int optComprar = 0;
                do {
                    System.out.println("Digite o ID do LIVRO que quer comprar e dê um Enter: ");
                    Long idCompra = sc1.nextLong();
                    itemsToCompra.add(idCompra);
                    items.forEach(item -> {
                        if (item.getId() == idCompra) {
                            item.setEstoque(item.getEstoque() - 1);
                        }
                        ;
                    });
                    System.out.println("Deseja comprar outro Livro?\n 1 - sim\n 2 - nao");
                    optComprar = sc1.nextInt();
                } while (optComprar != 2);

                if (compraBusiness.comprarItem(idCliente, items, itemsToCompra)) {
                    System.out.println("LIVRO comprado com sucesso!");
                } else {
                    System.out.println("LIVRO não foi comprado");
                }
            }
            // TIPO DVD
            else if (Tipo.DVD.getCode() == inputTipo) {
                items.forEach(item -> {
                    if (item.getTipo().getCode() == Tipo.DVD.getCode() && item.getEstoque() > 0
                            && !itemsToCompra.contains(new ArrayList<Long>().add(item.getId()))) {
                        System.out.println("ID: " + item.getId() + " - Título do DVD: " + item.getTitulo()
                                + " - Tem no estoque: " + item.getEstoque());
                    }
                });

                int optComprar = 0;
                do {
                    System.out.println("Digite o ID do DVD que quer comprar e dê um Enter: ");
                    Long idCompra = sc1.nextLong();
                    itemsToCompra.add(idCompra);
                    items.forEach(item -> {
                        if (item.getId() == idCompra) {
                            item.setEstoque(item.getEstoque() - 1);
                        }
                        ;
                    });
                    System.out.println("Deseja comprar outro DVD?\n 1 - sim\n 2 - nao");
                    optComprar = sc1.nextInt();
                } while (optComprar != 2);

                if (compraBusiness.comprarItem(idCliente, items, itemsToCompra)) {
                    System.out.println("DVD comprado com sucesso!");
                } else {
                    System.out.println("DVD não foi comprado");
                }
            }
            // TIPO REVISTA
            else if (Tipo.REVISTA.getCode() == inputTipo) {
                items.forEach(item -> {
                    if (item.getTipo().getCode() == Tipo.REVISTA.getCode() && item.getEstoque() > 0
                            && !itemsToCompra.contains(new ArrayList<Long>().add(item.getId()))) {
                        System.out.println("ID: " + item.getId() + " - Título do REVISTA: " + item.getTitulo()
                                + " - Tem no estoque: " + item.getEstoque());
                    }
                });

                int optComprar = 0;
                do {
                    System.out.println("Digite o ID do REVISTA que quer comprar e dê um Enter: ");
                    Long idCompra = sc1.nextLong();
                    itemsToCompra.add(idCompra);
                    items.forEach(item -> {
                        if (item.getId() == idCompra) {
                            item.setEstoque(item.getEstoque() - 1);
                        }
                        ;
                    });
                    System.out.println("Deseja comprar outro REVISTA?\n 1 - sim\n 2 - nao");
                    optComprar = sc1.nextInt();
                } while (optComprar != 2);

                if (compraBusiness.comprarItem(idCliente, items, itemsToCompra)) {
                    System.out.println("REVISTA comprado com sucesso!");
                } else {
                    System.out.println("REVISTA não foi comprado");
                }
            }
            System.out.println("Deseja comprar mais alguma compra?\n1 - nao\n2 - sim");
            opt = sc1.nextInt();

        } while (opt != 1);

        sc1 = new Scanner(System.in);
    }
}