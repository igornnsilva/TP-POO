import java.util.ArrayList;
import java.util.List;

public class Receita extends Item {
    private int idReceita;
    private Item produto;
    private int idItem1, idItem2;

    public  Receita(){

    }

    public Receita(int idReceita, Item produto, int id1, int id2) {
        this.idReceita = idReceita;
        this.produto = produto;
        this.idItem1 = id1;
        this.idItem2 = id2;
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

    public void setItemLista(int id1, int id2){
        this.idItem1 = id1;
        this.idItem2 = id2;

    }
    public int getIdItem1() {
        return idItem1;
    }
    public int getIdItem2() {
        return idItem2;
    }




    public boolean verificarIngredientes(Inventario inventario, Receita receitaAtual){
        boolean P1 = false;
        boolean P2 = false;
        for(Item item: inventario.getItens()){
            if(item.getIdItem() == receitaAtual.idItem1){
                P1 = true;

            } else if(item.getIdItem() == receitaAtual.idItem2){
                P2 = true;
            }
            if(P1 && P2){
                return true;
            }
        }
        return false;
    }

}
