import java.util.List;

public class Receita {
    private int idReceita;
    private Item produto;
    private List <Item> listaItem;

    public Receita(int idReceita, Item produto, List<Item> listaItem) {
        this.idReceita = idReceita;
        this.produto = produto;
        this.listaItem = listaItem;
    }
    public int getIdReceita() {
        return idReceita;
    }
    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }
    public Item getProduto() {
        return produto;
    }
    public void setProduto(Item produto) {
        this.produto = produto;
    }
    public List<Item> getListaItem() {
        return listaItem;
    }
    public void setItemLista(Item produto) {
        this.listaItem.add(produto);
    }


}
