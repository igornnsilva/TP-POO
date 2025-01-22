package principal;

public class Receita extends Item {
    private int idReceita;
    private int idProduto;
    private int idItem1, idItem2;
    private Item Produto;
    public  Receita(){

    }

    public Receita(int idReceita, int idProd, int id1, int id2) {
        this.idReceita = idReceita;
        this.idProduto = idProd;
        this.idItem1 = id1;
        this.idItem2 = id2;
    }
    public int getIdReceita() {
        return idReceita;
    }
    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }
    public int getIdProduto() {
        return this.idProduto;
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


    public void setProduto(Item item){
        this.Produto = item;
    }
    public Item getProduto(){
        return this.Produto;
    }





    public boolean verificarIngredientes(Item item1, Item item2 , Receita receitaAtual){
        if(item1.getIdItem() == receitaAtual.getIdItem1() && item2.getIdItem() == receitaAtual.getIdItem2()){
            return true;
        }
        if(item1.getIdItem() == receitaAtual.getIdItem2() && item2.getIdItem() == receitaAtual.getIdItem1()){
            return true;
        }
        return false;
    }

}
