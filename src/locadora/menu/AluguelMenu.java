package locadora.menu;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import locadora.bussines.AluguelBussines;
import locadora.entity.Aluguel;
import locadora.entity.Cliente;
import locadora.entity.Item;

public class AluguelMenu {

    AluguelBussines aluguelBussines = new AluguelBussines();

    public void aluguelBussines(List<Aluguel> alugueis, List<Cliente> clientes, List<Item> itens) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        clientes.forEach(cliente -> System.out.print(cliente.getId() + " - " + cliente.getNome()));
        System.out.print("\nEscolha o cliente:");
        Long idCliente = sc1.nextLong();
        boolean vip = false;
        boolean bairroCentro = false;
        boolean isValid = false;

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
            throw new Exception("Cliente inválido.");
        }

        List<Long> itensAluguel = new ArrayList<Long>();

        int opt = 1;
        while (opt == 1) {
            itens.forEach(item -> {
                if (item.getEstoque() != 0)
                    System.out.print(item.getId().toString() + " - " + item.getTitulo().toString());
            });
            System.out.print("\nEscolha o item: ");
            long itemInput = sc1.nextLong();
            for (Item item : itens) {
                if (item.getId() == itemInput && item.getEstoque() > 0) {
                    itensAluguel.add(itemInput);
                    item.setEstoque(item.getEstoque() - 1);
                    isValid = true;
                }
            }
            if (!isValid) {
                System.out.print("\nItem Indisponível.");
            }
            System.out.print("Deseja adicionar outro item? 1 - Sim 2 - Nao");
            opt = sc1.nextInt();
        }

        if (aluguelBussines.cadastrarAluguel(idCliente, vip, bairroCentro, itensAluguel, alugueis))
            System.out.println("\nAluguel salvo com sucesso!");
        else
            System.out.println("Não foi possível salvar o Aluguel!");
        sc1 = new Scanner(System.in);
    }
}