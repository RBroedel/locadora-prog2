package locadora.bussines;

import java.util.List;

import locadora.entity.Item;

public class CompraBusiness {

    public boolean comprarItem(Long idCliente, List<Item> items, List<Long> itemsToCompra) {

        Double valor = 0.0;

        for (Item item : items) {
            valor += item.getValor();
        }
        System.out.println("Valor total da lista de produtos é: " + valor);
        return true;
    }
}
