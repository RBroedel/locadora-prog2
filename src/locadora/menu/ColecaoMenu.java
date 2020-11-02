package locadora.menu;

import java.util.List;
import java.util.Scanner;

import locadora.bussines.ColecaoBusiness;
import locadora.entity.Colecao;

public class ColecaoMenu {
    ColecaoBusiness colecaobussines = new ColecaoBusiness();
    Scanner sc1 = new Scanner (System.in);

    public boolean cadastraColecao( List<Colecao> colecoes ) throws Exception {
        System.out.print("Informa o Titulo da colecao: ");
        String titulo = sc1.nextLine();

        System.out.print("Informe o valor da colecao: ");
        Double valor = sc1.nextDouble();

        return colecaobussines.cadastraColecao (titulo, valor, colecoes);
    }

}
