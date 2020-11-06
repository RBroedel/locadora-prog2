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
    int gambiarra;

    public void compraItem(List<Compra> compras, List<Cliente> clientes, List<Item> items) throws Exception {

        boolean vip = false;
        boolean bairroCentro = false;
        boolean isValid = false;

        if (clientes.isEmpty()) {
            System.out.println("Sem cliente cadastrado!");
        } else {

            clientes.forEach(cliente -> System.out.println(
                    cliente.getId() + " " + cliente.getNome() + " " + cliente.getBairro() + " " + cliente.isVip()));
            System.out.println("Escolha o cliente: ");
            Long idCliente = sc1.nextLong();

            for (Cliente cliente : clientes) {
                if (idCliente == cliente.getId() && cliente.isVip()) {
                    vip = true;
                }
                if (idCliente == cliente.getId() && cliente.getBairro().toLowerCase().equals("centro")) {
                    bairroCentro = true;
                }
                if (idCliente == cliente.getId()) {
                    isValid = true;
                }
            }
            if (!isValid) {
                throw new Exception("Cliente Inválido!");
            }

            int opt = 0;
            List<Long> itemsToCompra = new ArrayList<Long>();
            do {
                System.out.println("Qual produto você quer comprar?\n 1 - Livro\n 2 - DVD\n 3 - Revista\n");
                int inputTipo = sc1.nextInt();
                // TIPO LIVRO
                if (Tipo.LIVRO.getCode() == inputTipo) {
                    items.forEach(item -> {
                        if (item.getTipo().getCode() == Tipo.LIVRO.getCode() && item.getEstoque() > 0
                                && !itemsToCompra.contains(item.getId())) {
                            System.out.println("ID: " + item.getId() + " - Título do LIVRO: " + item.getTitulo()
                                    + " - Tem no estoque: " + item.getEstoque());
                        }
                    });
                    int optComprar = 0;

                    do {
                        System.out.println("Digite o ID do LIVRO que quer comprar e dê um Enter: ");
                        Long idCompra = sc1.nextLong();

                        items.forEach(item -> {
                            if (item.getEstoque() == 1) {
                                gambiarra++;
                            }
                            if (item.getId() == idCompra) {
                                if (item.getEstoque() > 0) {
                                    gambiarra--;
                                    itemsToCompra.add(idCompra);
                                    item.setEstoque(item.getEstoque() - 1);
                                }
                            }
                        });
                        if (gambiarra == 0) {
                            System.out.println("Sem Livros no Estoque!");
                            optComprar = 2;
                        } else {
                            System.out.println("Deseja comprar outro LIVRO?\n 1 - sim\n 2 - nao");
                            optComprar = sc1.nextInt();
                        }
                    } while (optComprar != 2);
                    if (compraBusiness.comprarItem(idCliente, vip, bairroCentro, items, compras, itemsToCompra)) {
                        System.out.println("LIVRO comprado com sucesso!");
                    } else {
                        System.out.println("LIVRO não foi comprado");
                    }
                }
                // TIPO DVD
                else if (Tipo.DVD.getCode() == inputTipo) {
                    items.forEach(item -> {
                        if (item.getTipo().getCode() == Tipo.DVD.getCode() && item.getEstoque() > 0
                                && !itemsToCompra.contains(item.getId())) {
                            System.out.println("ID: " + item.getId() + " - Título do DVD: " + item.getTitulo()
                                    + " - Tem no estoque: " + item.getEstoque());
                        }
                    });
                    int optComprar = 0;

                    do {
                        System.out.println("Digite o ID do DVD que quer comprar e dê um Enter: ");
                        Long idCompra = sc1.nextLong();

                        items.forEach(item -> {
                            if (item.getEstoque() == 1) {
                                gambiarra++;
                            }
                            if (item.getId() == idCompra) {
                                if (item.getEstoque() > 0) {
                                    gambiarra--;
                                    itemsToCompra.add(idCompra);
                                    item.setEstoque(item.getEstoque() - 1);
                                }
                            }
                        });
                        if (gambiarra == 0) {
                            System.out.println("Sem DVDs no Estoque!");
                            optComprar = 2;
                        } else {
                            System.out.println("Deseja comprar outro DVD?\n 1 - sim\n 2 - nao");
                            optComprar = sc1.nextInt();
                        }
                    } while (optComprar != 2);
                    if (compraBusiness.comprarItem(idCliente, vip, bairroCentro, items, compras, itemsToCompra)) {
                        System.out.println("DVD comprado com sucesso!");
                    } else {
                        System.out.println("DVD não foi comprado");
                    }
                }
                // TIPO REVISTA
                else if (Tipo.REVISTA.getCode() == inputTipo) {
                    items.forEach(item -> {
                        if (item.getTipo().getCode() == Tipo.REVISTA.getCode() && item.getEstoque() > 0
                                && !itemsToCompra.contains(item.getId())) {
                            System.out.println("ID: " + item.getId() + " - Título do REVISTA: " + item.getTitulo()
                                    + " - Tem no estoque: " + item.getEstoque());
                        }
                    });
                    int optComprar = 0;

                    do {
                        System.out.println("Digite o ID do REVISTA que quer comprar e dê um Enter: ");
                        Long idCompra = sc1.nextLong();

                        items.forEach(item -> {
                            if (item.getEstoque() == 1) {
                                gambiarra++;
                            }
                            if (item.getId() == idCompra) {
                                if (item.getEstoque() > 0) {
                                    gambiarra--;
                                    itemsToCompra.add(idCompra);
                                    item.setEstoque(item.getEstoque() - 1);
                                }
                            }
                        });
                        if (gambiarra == 0) {
                            System.out.println("Sem REVISTAs no Estoque!");
                            optComprar = 2;
                        } else {
                            System.out.println("Deseja comprar outro REVISTA?\n 1 - sim\n 2 - nao");
                            optComprar = sc1.nextInt();
                        }
                    } while (optComprar != 2);
                    if (compraBusiness.comprarItem(idCliente, vip, bairroCentro, items, compras, itemsToCompra)) {
                        System.out.println("REVISTA comprado com sucesso!");
                    } else {
                        System.out.println("REVISTA não foi comprado");
                    }
                }
                System.out.println("Deseja comprar mais algum item?\n 1 - nao\n 2 - sim");
                opt = sc1.nextInt();
            } while (opt != 1);
            sc1 = new Scanner(System.in);
        }
    }
}