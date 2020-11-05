package locadora.bussines;

import java.util.List;

import locadora.entity.Item;

public class CompraBusiness {

    public boolean comprarItem(Long idCliente, List<Item> items, List<Long> itemsToCompra) {

        System.out.println(idCliente + " - " + items.toString() + " - " + itemsToCompra.toString());
        return true;
    }

}
