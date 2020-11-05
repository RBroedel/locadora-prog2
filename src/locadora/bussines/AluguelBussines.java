package locadora.bussines;

import java.time.LocalDate;
import java.util.List;
import locadora.entity.Aluguel;

public class AluguelBussines {

    public boolean cadastrarAluguel( Long idCliente, boolean vip, boolean bairroCentro, List<Long> itens, List<Aluguel> alugueis) throws Exception{

        var aluguel = new Aluguel();
        LocalDate dataAluguel = LocalDate.now();
        LocalDate dataDevolucao = dataAluguel.plusDays(5);
        Double valor = 10.;
        Double valorTotal = valor*itens.size();
        if (vip){
            valorTotal = valorTotal-(valorTotal*0.05);
        };
        if (bairroCentro){
            valorTotal += 10.;
        } else{
            valorTotal += 15.;
        }
        aluguel.setId( getLastId( alugueis ) + 1 ); 
        aluguel.setIdCliente( idCliente );
        aluguel.setDataAluguel(dataAluguel);
        aluguel.setDataDevolucao(dataDevolucao);
        aluguel.setValor(valorTotal);
        aluguel.setItens(itens);

        alugueis.add(aluguel);
        return true;

    }

    private Long getLastId(List<Aluguel> alugueis) {
        if (alugueis.size() > 0)
            return alugueis.get(alugueis.size() - 1).getId();

        return Long.parseLong("0");
    }
}
