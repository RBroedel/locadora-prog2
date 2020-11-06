package locadora.bussines;

import java.time.LocalDate;
import java.util.List;
import locadora.entity.Aluguel;
import locadora.entity.Item;


public class AluguelBussines {
    private static final Double VALOR = 10.0;

    public boolean cadastrarAluguel(Long idCliente, boolean vip, boolean bairroCentro, List<Long> itens,
            List<Aluguel> alugueis, boolean isEntregaDomicilio) throws Exception {
        var aluguel = new Aluguel();
        LocalDate dataAluguel = LocalDate.now();
        LocalDate dataDevolucao = dataAluguel.plusDays(5);
        Double valorTotal = VALOR * itens.size();
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
        aluguel.setId(getLastId(alugueis) + 1);
        aluguel.setIdCliente(idCliente);
        aluguel.setDataAluguel(dataAluguel);
        aluguel.setDataDevolucao(dataDevolucao);
        aluguel.setValor(valorTotal);
        aluguel.setItens(itens);

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
                alugueis.remove(i);
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
