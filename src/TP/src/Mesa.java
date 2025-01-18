import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private List<Item> itensAtuais;
    private Item itemFinal; //verificar a usabilidade desse atributo

    public Mesa() {
        itensAtuais = new ArrayList<>();
    }

    public void craftarReceita(Receita receita, Inventario inventario) {
        if (receita == null || inventario == null ) {
            throw new IllegalArgumentException("Os parâmetros não podem ser nulos.");
        }

        if (!inventario.verificaItem(receita.getIdItem1()) || !inventario.verificaItem(receita.getIdItem2())) {
            System.out.println("Um ou mais produtos não estão no inventário.");
            return;
        }

        if (receita.verificarIngredientes(inventario, receita)) {
            this.itemFinal = receita.getProduto();
            inventario.consumirItem(receita.getIdItem1());
            inventario.consumirItem(receita.getIdItem2());
            inventario.adicionarItemCraftado(this.itemFinal);
        }

        System.out.println("Combinação de produtos não craftável.");
    }
}
