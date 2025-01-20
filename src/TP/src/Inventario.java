import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> Itens;
    private List<Receita> receitasCriadas;

    public Inventario() {
        this.Itens = new ArrayList<>();
        this.receitasCriadas = new ArrayList<>();

    }

    public List<Item> getItens() {
        return Itens;
    }

    public void adicionarItem(int idItem, String nome, String nomeIcone, boolean desbloqueado, Raridade raridade) {
        Item item = new Item(idItem, nome, nomeIcone, desbloqueado, raridade);
        this.Itens.add(item);
    }


    public void adicionarItemCraftado(Item craft){
        this.Itens.add(craft);
    }
    public void listarItens() {
        if(this.Itens.isEmpty()){
            System.out.println("Lista de itens vazia.");
        }
        System.out.println("Lista de itens no inventário:");
        for(Item item: this.Itens){
            System.out.printf("Item %d: %s\n", item.getIdItem(), item.getNome());
            System.out.printf("%s\n", item.getRaridade());
        }
    }


    public void adicionarReceita(Receita receita) {
        this.receitasCriadas.add(receita);
    }
    public void criarReceitaInventario(int id, Item prod, int idP1, int idP2){
        Receita temp = new Receita(id, prod, idP1, idP2);
        adicionarReceita(temp);
    }

    //Colocar no Diagrama

    public boolean verificaItem(int id){
        for(Item item: Itens){
            if(item.getIdItem() == id){
                return true;
            }
        }
        return false;
    }
    public void consumirItem(int id){
        for(Item item : this.Itens){
            if(item.getIdItem() == id){
                this.Itens.remove(item);
                return;
            }
        }
    }
    public Receita getReceita(int id){
        for(Receita receita: receitasCriadas){
            if(receita.getIdReceita() == id){
                return receita;
            }
        }
        System.out.println("Id da Receita invalida");
        return null;
    }

}
