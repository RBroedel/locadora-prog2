package locadora.bussines;

import java.util.List;

import locadora.entity.Colecao;

public class ColecaoBusiness {
    public void cadastraColecao(String titulo, Double valor, List<Colecao> colecoes) throws Exception {
        if ( !isColecaoValido(titulo, valor) )
            throw new Exception("Dados inválidos");

        var colecao = new Colecao();
        colecao.setId( getLastId (colecoes) + 1);
        colecao.setTitulo( titulo );
        colecao.setValor( valor );

        colecoes.add(colecao);
    }

    private boolean isColecaoValido(String titulo, Double valor){
        if (titulo.equals( "" ))
            return false;
        if (valor.equals( "" ))
            return false;

        return true;
    }

    private Long getLastId (List<Colecao> colecoes){
        if (colecoes.size() > 0)
            return colecoes.get(colecoes.size() - 1).getId();

        return Long.parseLong("0");
    }

}