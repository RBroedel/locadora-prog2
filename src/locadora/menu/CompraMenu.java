package locadora.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import locadora.bussines.CompraBusiness;
import locadora.entity.Cliente;
import locadora.entity.Compra;
import locadora.entity.Item;

public class CompraMenu {
    CompraBusiness compraBusiness = new CompraBusiness();
    Scanner sc1 = new Scanner(System.in);

    public void compraItem(List<Compra> compras, List<Cliente> clientes, List<Item> items) throws Exception {

        boolean vip = false;
        boolean bairroCentro = false;
        boolean isValid = false;
        boolean isEstoque = false;

        if (clientes.isEmpty()) {
            throw new Exception("Sem cliente cadastrado!");
        } else {
            clientes.forEach(cliente -> System.out.println(
                    cliente.getId() + " " + cliente.getNome() + " " + cliente.getBairro() + " " + cliente.isVip()));
            System.out.println("Escolha o cliente: ");
            Long idCliente = sc1.nextLong();

            for (Cliente cliente : clientes) {
                if (idCliente == cliente.getId()) {
                    if (cliente.isVip()) {
                        vip = true;
                    }
                    if (cliente.getBairro().equalsIgnoreCase("centro")) {
                        bairroCentro = true;
                    }
                    isValid = true;
                }
            }
            if (!isValid) {
                throw new Exception("Cliente inválido.");
            }
            int opt = 1;
            List<Long> itensToCompra = new ArrayList<Long>();
            while (opt == 1) {
                if (items.size() == 0) {
                    throw new Exception("Lista de itens vazia!");
                } else {

                    System.out.println("Informa o Tipo(1 - Livro; 2 - DVD; 3 - Revista) : )");
                    int tipo = sc1.nextInt();
                    if (tipo < 1 && tipo > 3) {
                        throw new Exception("Tipo inválido!");
                    }
                    isEstoque = false;
                    for (Item item : items) {
                        if (!itensToCompra.contains(item.getId())) {
                            if (item.getTipo().getCode() == tipo) {
                                isEstoque = true;
                                System.out.println(item.getId().toString() + " - " + item.getTitulo().toString());
                            }
                        }
                    }
                    if (isEstoque) {
                        System.out.println("Escolha o item: ");
                        long itemInput = sc1.nextLong();
                        isValid = false;
                        for (Item item : items) {
                            if (item.getId() == itemInput && item.getEstoque() > 0
                                    && item.getTipo().getCode() == tipo) {
                                itensToCompra.add(itemInput);
                                isValid = true;
                                if (item.getIdColecao() != 0 && item.getTipo().getCode() == 1) {
                                    for (Item item2 : items) {
                                        if (item2.getIdColecao() == item.getIdColecao()) {
                                            itensToCompra.add(item2.getId());
                                        }
                                    }
                                }
                            }
                        }

                        if (!isValid) {
                            System.out.println("Item Indisponível.");
                        }
                    } else {
                        System.out.println("Não há itens nessa categoria!");
                    }

                    System.out.println("Deseja adicionar outro item? 1 - Sim 2 - Nao");
                    opt = sc1.nextInt();
                    if (opt < 1 || opt > 2) {
                        throw new Exception("Opção invalida!");
                    }
                }
            }
            if (itensToCompra.size() == 0) {
                throw new Exception("Não há itens nesse Compra");
            }
            if (compraBusiness.comprarItem(idCliente, vip, bairroCentro, items, compras, itensToCompra))
                System.out.println("Compra salvo com sucesso!");
            else
                System.out.println("Não foi possível salvar o Compra!");
            sc1 = new Scanner(System.in);
        }
    }
}
// TIPO LIVRO
// if (Tipo.LIVRO.getCode() == inputTipo) {
// items.forEach(item -> {
// if (item.getTipo().getCode() == Tipo.LIVRO.getCode() && item.getEstoque() > 0
// && !itemsToCompra.contains(item.getId())) {
// System.out.println("ID: " + item.getId() + " - Título do LIVRO: " +
// item.getTitulo()
// + " - Tem no estoque: " + item.getEstoque());
// }
// });
// int optComprar = 0;
//
// do {
// System.out.println("Digite o ID do LIVRO que quer comprar e dê um Enter: ");
// Long idCompra = sc1.nextLong();
//
// items.forEach(item -> {
// if (item.getEstoque() == 1) {
// }
// if (item.getId() == idCompra) {
// if (item.getEstoque() > 0) {
// itemsToCompra.add(idCompra);
// item.setEstoque(item.getEstoque() - 1);
// }
// }
// });
// System.out.println("Deseja comprar outro LIVRO?\n 1 - sim\n 2 - nao");
// optComprar = sc1.nextInt();
//
// } while (optComprar != 2);
// if (compraBusiness.comprarItem(idCliente, vip, bairroCentro, items, compras,
// itemsToCompra)) {
// System.out.println("LIVRO comprado com sucesso!");
// } else {
// System.out.println("LIVRO não foi comprado");
// }
// }
// TIPO DVD