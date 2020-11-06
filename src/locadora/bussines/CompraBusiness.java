package locadora.bussines;

import java.time.LocalDate;
import java.util.List;

import locadora.entity.Compra;
import locadora.entity.Item;

public class CompraBusiness {

    public boolean comprarItem(Long idCliente, boolean vip, boolean bairroCentro, List<Item> items,
            List<Compra> compras, List<Long> itemsToCompra) {

        var compra = new Compra();
        LocalDate dataCompra = LocalDate.now();

        Double valorTotal = 0.0;

        for (Item item : items) {
            if (itemsToCompra.contains(item.getId())) {
                valorTotal += item.getValor();
            }
        }

        if (vip) {
            valorTotal = valorTotal - (valorTotal * 0.05);
        }

        compra.setId(getLastId(compras) + 1);
        compra.setIdCliente(idCliente);
        compra.setDataCompra(dataCompra);
        compra.setValor(valorTotal);
        compra.setItens(itemsToCompra);

        compras.add(compra);

        System.out.println("Valor total da compra: " + valorTotal);
        return true;
    }

    private Long getLastId(List<Compra> compras) {
        if (compras.size() > 0)
            return compras.get(compras.size() - 1).getId();

        return Long.parseLong("0");
    }
}
