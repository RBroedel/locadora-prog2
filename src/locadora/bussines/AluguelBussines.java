package locadora.bussines;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import locadora.entity.Aluguel;

public class AluguelBussines {

    public boolean cadastrarAluguel( Long idCliente, boolean vip, boolean bairroCentro, List<Long> itens, List<Aluguel> alugueis) throws Exception{

        var aluguel = new Aluguel();
        Date dataAluguel = new Date();
        Date dataDevolucao = new Date();
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
        LocalDateTime.from(dataDevolucao.toInstant()).plusDays(5);
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
