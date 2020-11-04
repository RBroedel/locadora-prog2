  
package locadora.menu;

import java.util.List;
import java.util.Scanner;

import locadora.bussines.ItemBusiness;
import locadora.entity.Item;
import locadora.enums.Tipo;

public class ItemMenu {
    ItemBusiness Itembussines = new ItemBusiness();
    Scanner sc1 = new Scanner (System.in);

    public boolean cadastraItem( List<Item> itens ) throws Exception {
        System.out.println("Informa o Titulo: ");
		String titulo = sc1.nextLine();

		System.out.println("Informa o Tipo(1 - Livro; 2 - DVD; 3 - Revista) : ");
        int tipo = sc1.nextInt();

        return Itembussines.cadastraItem (titulo, itens);
    }

}