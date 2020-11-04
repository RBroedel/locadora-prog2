package locadora.bussines;

import java.util.List;

import locadora.entity.Item;

public class ItemBusiness {
    private static final Double VALOR = 30.0;
    public boolean cadastraItem(String titulo, List<Item> itens) throws Exception {
        if ( !isItemValido(titulo) )
            throw new Exception("Dados inválidos");

        var Item = new Item();
        //Item.setId( getLastId (id) + 1);
        Item.setTitulo( titulo );
        Item.setValor( VALOR );

        itens.add(Item);
        return true;
    }

    private boolean isItemValido(String titulo){
        if (titulo.equals( "" ))
            return false;

        return true;
    }

    private Long getLastId (List<Item> itens){
        if (itens.size() > 0)
            return itens.get(itens.size() - 1).getId();

        return Long.parseLong("0");
    }

}