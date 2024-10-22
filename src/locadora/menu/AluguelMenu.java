package locadora.menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        boolean isEstoque = false;

        if (clientes.isEmpty()) {
            throw new Exception("O sistema nao possui clientes!");
        }

        clientes.forEach(cliente -> System.out.println(cliente.getId() + " - " + cliente.getNome()));
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
            throw new Exception("Cliente invalido.");
        }

        System.out.println("Entregar em domicilio? ( 1 - Sim; 2 - Nao )");
        Long entrega = sc1.nextLong();
        boolean isEntregaDomicilio;
        if (entrega == 1) {
            isEntregaDomicilio = true;
        } else if (entrega == 2) {
            isEntregaDomicilio = false;
        } else {
            throw new Exception("Opcao invalida.");
        }

        while (opt == 1) {
            System.out.println("Informa o Tipo: ( 1 - Livro; 2 - DVD; 3 - Revista )");
            int tipo = sc1.nextInt();
            isEstoque = false;
            for (Item item : itens) {
                if (!itensAluguel.contains(item.getId()) && item.getEstoque() > 0) {
                    if (item.getTipo().getCode() == tipo) {
                        System.out.println(item.getId().toString() + " - " + item.getTitulo().toString());
                        isEstoque = true;
                    }
                }
            }
            if (isEstoque) {
                System.out.println("Escolha o item: ");
                long itemInput = sc1.nextLong();
                isValid = false;
                for (Item item : itens) {
                    if (item.getId() == itemInput && item.getEstoque() > 0 && item.getTipo().getCode() == tipo) {
                        itensAluguel.add(itemInput);
                        isValid = true;
                    }
                }
                if (!isValid) {
                    System.out.println("Item indisponivel.");
                }
            } else {
                System.out.println("Nao ha itens dessa categoria disponiveis.");

            }
            System.out.println("Deseja adicionar outro item?( 1 - Sim 2 - Nao )");
            opt = sc1.nextInt();
        }
        if (itensAluguel.size() == 0) {
            throw new Exception("Nao ha itens nesse aluguel");
        }
        if (aluguelBussines.cadastrarAluguel(idCliente, vip, bairroCentro, itensAluguel, alugueis, isEntregaDomicilio,
                itens))
            System.out.println("Aluguel salvo com sucesso!");
        else
            System.out.println("Nao foi possível salvar o Aluguel!");
        sc1 = new Scanner(System.in);
    }

    public void devolucao(List<Aluguel> alugueis, List<Cliente> clientes, List<Item> itens) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        LocalDate date = LocalDate.now();

        boolean hasAlugueisAtivos = false;

        System.out.println("Alugueis: ");
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getDataDevolucao() == null) {
                hasAlugueisAtivos = true;
                System.out.print(aluguel.getId() + " - ");
                for (Cliente cliente : clientes) {
                    if (aluguel.getIdCliente() == cliente.getId()) {
                        System.out.print(cliente.getNome() + " - ");
                    }
                }
                Double valor = aluguel.getValor();
                if (!aluguel.getDataAluguel().plusDays(6).isAfter(date)) {
                    valor = aluguel.getValor() + (aluguel.getItens().size() * 5);
                }
                System.out.println(aluguel.getDataAluguel() + " - R$ " + valor);
            }
        }

        if (!hasAlugueisAtivos) {
            throw new Exception("Sem Alugueis ativos no momento!");
        }

        System.out.println("Escolha qual aluguel esta sendo devolvido: ");
        Long idAluguel = sc1.nextLong();

        boolean isIdValid = false;

        for (Aluguel aluguel : alugueis) {
            if (aluguel.getId().equals(idAluguel)) {
                isIdValid = true;
            }
        }

        if (!isIdValid) {
            throw new Exception("Aluguel invalido!");
        }

        if (aluguelBussines.confirmaDevolucao(alugueis, idAluguel, itens))
            System.out.println("Devolucao realizada com sucesso!");
        else
            System.out.println("Nao foi possível concluir devolucao");
        sc1 = new Scanner(System.in);

    }
}