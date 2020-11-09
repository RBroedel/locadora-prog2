package locadora.menu;

import java.util.List;
import java.util.Scanner;

import locadora.bussines.ColecaoBusiness;
import locadora.entity.Colecao;

public class ColecaoMenu {
    ColecaoBusiness colecaobussines = new ColecaoBusiness();

    public void cadastraColecao(List<Colecao> colecoes) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Informa o Titulo da colecao: ");
        String titulo = sc1.nextLine();

        if (colecaobussines.cadastraColecao(titulo, colecoes)) {
            System.out.println("Colecao cadastrada com sucesso!");
        } else {
            System.out.println("Colecao nao foi cadastrada com sucesso");
        }

        sc1 = new Scanner(System.in);
    }

}
