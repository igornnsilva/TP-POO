package principal;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private List<Item> itensAtuais;
    private Item itemFinal;

    public Mesa() {
        itensAtuais = new ArrayList<>();
    }

    public void craftarReceita(Receita receita, Inventario inventario, Item item1, Item item2) {
        if (receita == null || inventario == null ) {
            throw new IllegalArgumentException("Os parâmetros não podem ser nulos.");
        }

        if (!inventario.verificaItem(receita.getIdItem1()) || !inventario.verificaItem(receita.getIdItem2())) {
            System.out.println("Um ou mais produtos não estão no inventário.");
            return;
        }

        if (receita.verificarIngredientes(item1, item2, receita)) {
            this.itemFinal = inventario.getItem(receita.getIdProduto());
            inventario.desboloquearItem(this.itemFinal.getIdItem());
            return;
        }

        System.out.println("Combinação de produtos não craftável.");
    }




    public void craftItem(Inventario inventario, int id1, int id2){
        if ( inventario == null ) {
            throw new IllegalArgumentException("Os parâmetros não podem ser nulos.");
        }
        for(Receita receita: inventario.getReceitasCriadas()){
            if(receita.getIdItem1() == id1 && receita.getIdItem2() == id2 || (receita.getIdItem1() == id2 && receita.getIdItem2() == id1)){
                this.itemFinal = inventario.getItem(receita.getIdProduto());
                System.out.println("Craftando.....");
                System.out.println("Craftado com sucesso!");
                inventario.desboloquearItem(this.itemFinal.getIdItem());
                return;
            }

        }
        this.itemFinal = null;
    }


    public Item getItemFinal() {
        return this.itemFinal;
    }
}
