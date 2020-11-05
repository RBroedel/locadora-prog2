package locadora.menu;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

import locadora.bussines.AluguelBussines;
import locadora.entity.Aluguel;
import locadora.entity.Cliente;
import locadora.entity.Item;

public class AluguelMenu {

    AluguelBussines aluguelBussines = new AluguelBussines();

    public void aluguel(List<Aluguel> alugueis, List<Cliente> clientes, List<Item> itens) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        List<Long> itensAluguel = new ArrayList<Long>();
        int opt = 1;
        boolean vip = false;
        boolean bairroCentro = false;
        boolean isValid = false;

        clientes.forEach(cliente -> System.out.print(cliente.getId() + " - " + cliente.getNome() + "\n"));
        System.out.print("\nEscolha o cliente: ");
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
            throw new Exception("\nCliente inválido.");
        }

        System.out.print("\nÉ para entregar em domicilio? 1 - sim; 2 - nao \n");
        Long entrega = sc1.nextLong();
        if (entrega < 1 || entrega > 2) {
            throw new Exception("\nOpcao invalida!");
        }

        while (opt == 1) {
            itens.forEach(item -> {
                if (item.getEstoque() != 0)
                    System.out.print(item.getId().toString() + " - " + item.getTitulo().toString() + "\n");
            });
            System.out.print("\nEscolha o item: ");
            long itemInput = sc1.nextLong();
            isValid = false;
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
            System.out.print("\nDeseja adicionar outro item? 1 - Sim 2 - Nao\n");
            opt = sc1.nextInt();
        }
        if (itensAluguel.size() == 0) {
            throw new Exception("\nNão há itens nesse aluguel");
        }
        if (aluguelBussines.cadastrarAluguel(idCliente, vip, bairroCentro, itensAluguel, alugueis, entrega))
            System.out.println("\nAluguel salvo com sucesso!");
        else
            System.out.println("\nNão foi possível salvar o Aluguel!");
        sc1 = new Scanner(System.in);
    }

    public void devolucao(List<Aluguel> alugueis, List<Cliente> clientes, List<Item> itens) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        LocalDate date = LocalDate.now();

        System.out.print("\nAlugueis: \n");
        for (Aluguel aluguel : alugueis) {
            System.out.print(aluguel.getId() + " - ");
            for (Cliente cliente : clientes) {
                if (aluguel.getIdCliente() == cliente.getId()) {
                    System.out.print(cliente.getNome() + " - ");
                }
            }
            Double valor = aluguel.getValor();
            if (aluguel.getDataDevolucao().compareTo(date) < 0) {
                valor = aluguel.getValor() + (aluguel.getItens().size() * 5);
            }

            System.out.print(aluguel.getDataAluguel() + " - " + aluguel.getDataDevolucao() + " - R$ " + valor);

        }

        System.out.print("\n Escolha qual aluguel está sendo devolvido: ");
        Long idAluguel = sc1.nextLong();

        for (Aluguel aluguel : alugueis) {
            int i = 0;
            if (idAluguel == aluguel.getId()) {
                for (Long itemAluguel : aluguel.getItens()) {
                    for (Item itemEstoque : itens) {
                        if (itemAluguel == itemEstoque.getId()) {
                            itemEstoque.setEstoque(itemEstoque.getEstoque() + 1);
                        }
                    }
                }
                alugueis.remove(i);
            }
            i++;
        }
        sc1 = new Scanner(System.in);

    }
}