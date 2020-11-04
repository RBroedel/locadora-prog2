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
    Scanner sc1 = new Scanner(System.in);

    public void aluguelBussines(List<Aluguel> alugueis, List<Cliente> clientes, List<Item> itens) throws Exception {

        clientes.forEach(cliente -> System.out.print(cliente.getId() + " - " + cliente.getNome()));
        System.out.print("Escolha o cliente:");
        Long idCliente = sc1.nextLong();
        boolean vip = false;
        boolean bairroCentro = false;
        for (Cliente cliente : clientes) {
            if (idCliente == cliente.getId() && cliente.isVip()) {
                vip = true;
            }    
            if (idCliente == cliente.getId() && cliente.getBairro().equals("centro")){
                bairroCentro = true;
            }        
        }

        List<Long> itemLista = new ArrayList<Long>();

        int opt = 1;
        while (opt == 1) {
            itens.forEach(item -> {
                if (item.getEstoque() != 0)
                    System.out.print(item.getId() + " - " + item.getTitulo());
            });
            System.out.print("Escolha o item: ");
            long itemInput = sc1.nextLong();

            itemLista.add(itemInput);
            System.out.print("Deseja adicionar outro item? 1 - Sim 2 - Nao");
            opt = sc1.nextInt();
            itens.forEach(item -> {
                if (item.getId() == itemInput) {
                    item.reduzEstoque();
                }
            });
        }

        if (aluguelBussines.cadastrarAluguel(idCliente, vip, bairroCentro, itemLista, alugueis))
            System.out.println("Aluguel salvo com sucesso!");
        else
            System.out.println("Não foi possível salvar o Aluguel!");

    }

}