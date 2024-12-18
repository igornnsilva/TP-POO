import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> Itens;
    private List<Receita> receitasCriadas;

    public Inventario() {
        this.Itens = new ArrayList<>();
        this.receitasCriadas = new ArrayList<>();

    }
    public void adicionarItem(Item item) {
        this.Itens.add(item);
    }
    public void adicionarReceita(Receita receita) {
        this.receitasCriadas.add(receita);
    }
    public void listarItens() {
        for(Item item: this.Itens){
            System.out.printf("Nome %d: %s\n", item.getIdItem(), item.getNome());
            System.out.printf("%s\n", item.getRaridade());
        }
    }


}
