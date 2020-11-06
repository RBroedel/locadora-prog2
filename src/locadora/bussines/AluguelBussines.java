package locadora.bussines;

import java.time.LocalDate;
import java.util.List;
import locadora.entity.Aluguel;
import locadora.entity.Item;

public class AluguelBussines {
    private static final Double VALOR = 10.0;

    public boolean cadastrarAluguel(Long idCliente, boolean vip, boolean bairroCentro, List<Long> itensAluguel,
            List<Aluguel> alugueis, boolean isEntregaDomicilio, List<Item> itensEstoque) throws Exception {
        var aluguel = new Aluguel();
        LocalDate dataAluguel = LocalDate.now();
        Double valorTotal = VALOR * itensAluguel.size();
        if (vip) {
            valorTotal = valorTotal - (valorTotal * 0.05);
        }
        if (isEntregaDomicilio) {
            if (bairroCentro) {
                valorTotal += 10.;
            } else {
                valorTotal += 15.;
            }
        }
        for (Item item : itensEstoque) {
            if (itensAluguel.contains(item.getId())) {
                item.setEstoque(item.getEstoque() - 1);
            }
        }
        aluguel.setId(getLastId(alugueis) + 1);
        aluguel.setIdCliente(idCliente);
        aluguel.setDataAluguel(dataAluguel);
        aluguel.setValor(valorTotal);
        aluguel.setItens(itensAluguel);
        System.out.println("Valor total do aluguel: " + valorTotal);

        alugueis.add(aluguel);
        return true;

    }

    public boolean confirmaDevolucao(List<Aluguel> alugueis, Long idAluguel, List<Item> itens) throws Exception {
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
                aluguel.setDataDevolucao(LocalDate.now());
            }
            i++;
        }
        return true;
    }

    private Long getLastId(List<Aluguel> alugueis) {
        if (alugueis.size() > 0)
            return alugueis.get(alugueis.size() - 1).getId();

        return Long.parseLong("0");
    }
}
