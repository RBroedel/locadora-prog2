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

    public void compraItem(List<Compra> compras, List<Cliente> clientes, List<Item> items) throws Exception {

        boolean vip = false;
        boolean bairroCentro = false;
        boolean isValid = false;
        boolean hasEstoque = false;

        if (clientes.isEmpty()) {
            throw new Exception("Sem cliente cadastrado!");
        }

        if (items.isEmpty()) {
            throw new Exception("Lista de itens vazia!");
        }

        clientes.forEach(cliente -> System.out
                .println(cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getBairro()));
        System.out.println("Escolha o cliente digitando o id: ");
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
            throw new Exception("Cliente invalido.");
        }

        System.out.println("Entregar em domicilio? ( 1 - Sim; 2 - Nao )");
        int entrega = sc1.nextInt();
        boolean isEntregaDomicilio;
        if (entrega == 1) {
            isEntregaDomicilio = true;
        } else if (entrega == 2) {
            isEntregaDomicilio = false;
        } else {
            throw new Exception("Opcao invalida.");
        }

        int opt = 1;
        List<Long> itensToCompra = new ArrayList<Long>();
        while (opt == 1) {
            System.out.println("Informa o tipo digitando o id: ( 1 - Livro; 2 - DVD; 3 - Revista ):");
            int tipo = sc1.nextInt();
            if (tipo < 1 || tipo > 3) {
                throw new Exception("Tipo invalido!");
            }

            hasEstoque = false;
            for (Item item : items) {
                if (!itensToCompra.contains(item.getId()) && item.getTipo().getCode() == tipo
                        && item.getEstoque() > 0) {
                    hasEstoque = true;
                    System.out.println(item.getId() + " - " + item.getTitulo());
                }
            }
            if (hasEstoque) {
                System.out.println("Escolha o item digitando seu id: ");
                long itemInput = sc1.nextLong();
                isValid = false;
                for (Item item : items) {
                    if (item.getId().equals(itemInput) && item.getEstoque() > 0 && item.getTipo().getCode() == tipo) {
                        itensToCompra.add(itemInput);
                        isValid = true;
                        if (!item.getIdColecao().equals(0L) && item.getTipo().equals(Tipo.LIVRO)) {
                            for (Item item2 : items) {
                                if (item2.getIdColecao().equals(item.getIdColecao())
                                        && !itensToCompra.contains(item2.getId())) {
                                    itensToCompra.add(item2.getId());
                                }
                            }
                        }
                    }
                }

                if (!isValid) {
                    System.out.println("Item indisponivel.");
                }
            } else {
                System.out.println("Não ha itens nessa categoria!");
            }

            System.out.println("Deseja adicionar outro item? ( 1 - Sim; 2 - Nao) ");
            opt = sc1.nextInt();
            if (opt < 1 || opt > 2) {
                throw new Exception("Opção invalida!");
            }

        }
        if (itensToCompra.isEmpty()) {
            throw new Exception("Nao ha itens nessa Compra");
        }

        if (compraBusiness.comprarItem(idCliente, vip, bairroCentro, items, compras, itensToCompra,
                isEntregaDomicilio)) {
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Nao foi possivel realizar a Compra!");
        }

        sc1 = new Scanner(System.in);

    }
}