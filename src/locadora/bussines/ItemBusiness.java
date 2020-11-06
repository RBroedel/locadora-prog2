package locadora.bussines;

import java.util.List;

import locadora.entity.Colecao;
import locadora.entity.Item;
import locadora.enums.Tipo;

public class ItemBusiness {
    private static final Double VALOR_LIVRO = 50.0;
    private static final Double VALOR_DVD = 30.0;
    private static final Double VALOR_REVISTA = 15.0;

    public boolean cadastraItem(String titulo, Long idColecao, int tipo, List<Item> itens, List<Colecao> colecoes)
            throws Exception {

        if (isItemValido(titulo, idColecao, tipo, colecoes))
            throw new Exception("Dados Inválidos");

        var item = new Item();
        item.setId(getLastId(itens) + 1);
        item.setTitulo(titulo);
        item.setValor(retornaValorItem(tipo));
        item.setTipoItem(tipo);
        item.setEstoque(1L);

        if (idColecao != 0) {
            item.setIdColecao(idColecao);
        }

        itens.add(item);
        return true;
    }

    private boolean isItemValido(String titulo, Long idColecao, int tipo, List<Colecao> colecoes) {
        if (titulo.equals("")) {
            return false;
        }
        if (Tipo.Dvd.getCode() != tipo || Tipo.Livro.getCode() != tipo || Tipo.Revista.getCode() != tipo) {
            return false;
        }
        if (idColecao > colecoes.size() + 1 || idColecao < 0) {
            return false;
        }
        return true;
    }

    private Double retornaValorItem(int tipo) {
        if (Tipo.Dvd.getCode() == tipo) {
            return VALOR_DVD;
        } else if (Tipo.Livro.getCode() == tipo) {
            return VALOR_LIVRO;
        } else if (Tipo.Revista.getCode() == tipo) {
            return VALOR_REVISTA;
        }
        return 0.0;
    }

    private Long getLastId(List<Item> itens) {
        if (itens.size() > 0)
            return itens.get(itens.size() - 1).getId();

        return Long.parseLong("0");
    }

}