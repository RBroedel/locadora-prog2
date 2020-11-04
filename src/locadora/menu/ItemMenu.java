package locadora.menu;

import java.util.List;
import java.util.Scanner;

import locadora.bussines.ItemBusiness;
import locadora.entity.Colecao;
import locadora.entity.Item;
import locadora.enums.Tipo;

public class ItemMenu {
    ItemBusiness itemBussines = new ItemBusiness();
    Scanner sc1 = new Scanner(System.in);

    public boolean cadastraItem(List<Item> itens, List<Colecao> colecoes) throws Exception {
        System.out.println("Informa o Titulo: ");
        String titulo = sc1.nextLine();

        System.out.println("Informa o Tipo(1 - Livro; 2 - DVD; 3 - Revista) : ");
        int tipo = sc1.nextInt();
        Long idColecao = 0L;
        if (Tipo.Livro.getCode() == tipo) {
            System.out.println("Informe uma coleção para este livro:");
            System.out.println("0 - nenhuma coleção.");
            colecoes.forEach(colecao -> {
                System.out.println(colecao.getId() + " - " + colecao.getTitulo());
            });
            idColecao = sc1.nextLong();
            sc1.nextLine();
        }

        return itemBussines.cadastraItem(titulo, idColecao, tipo, itens, colecoes);
    }

}