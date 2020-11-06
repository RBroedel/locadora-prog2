
package locadora.menu;

import java.util.List;
import java.util.Scanner;

import locadora.bussines.ItemBusiness;
import locadora.entity.Colecao;
import locadora.entity.Item;
import locadora.enums.Tipo;

public class ItemMenu {
    ItemBusiness itembussines = new ItemBusiness();

    public void cadastroItem(List<Item> itens, List<Colecao> colecoes) throws Exception {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Informa o Titulo: ");
        String titulo = sc1.nextLine();

        System.out.println("Informa o Tipo(1 - Livro; 2 - DVD; 3 - Revista): ");
        int tipo = sc1.nextInt();
        Long idColecao = 0L;

        if (Tipo.LIVRO.getCode() == tipo) {
            System.out.println("Informe uma coleção para este livro:");
            System.out.println("0 - nenhuma coleção.");
            colecoes.forEach(colecao -> {
                System.out.println(colecao.getId() + " - " + colecao.getTitulo());
            });
            idColecao = sc1.nextLong();
        }

        if (itembussines.cadastraItem(titulo, idColecao, tipo, itens, colecoes)) {
            System.out.println("Item cadastrado com sucesso!");
        } else {
            System.out.println("Item não foi cadastrado");
        }

        sc1 = new Scanner(System.in);
    }

}