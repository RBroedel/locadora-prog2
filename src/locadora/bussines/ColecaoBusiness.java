package locadora.bussines;

import java.util.List;

import locadora.entity.Colecao;

public class ColecaoBusiness {
    private static final Double VALOR = 200.0;
    public boolean cadastraColecao(String titulo, List<Colecao> colecoes) throws Exception {
        if ( !isColecaoValido(titulo) )
            throw new Exception("Dados inválidos");

        var colecao = new Colecao();
        colecao.setId( getLastId (colecoes) + 1);
        colecao.setTitulo( titulo );
        colecao.setValor( VALOR );

        colecoes.add(colecao);
        return true;
    }

    private boolean isColecaoValido(String titulo){
        if (titulo.equals( "" ))
            return false;

        return true;
    }

    private Long getLastId (List<Colecao> colecoes){
        if (colecoes.size() > 0)
            return colecoes.get(colecoes.size() - 1).getId();

        return Long.parseLong("0");
    }

}