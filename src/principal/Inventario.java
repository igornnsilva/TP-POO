package principal;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> Itens;
    private List<Receita> receitasCriadas;
    private List<Nivel> niveis;

    public Inventario() {
        this.Itens = new ArrayList<>();
        this.receitasCriadas = new ArrayList<>();
        this.niveis = new ArrayList<>();
    }
    public Inventario(List<Item> lItem, List <Receita> lReceita){
        this.Itens = lItem;
        this.receitasCriadas = lReceita;
    }

    public List<Item> getItens() {
        return Itens;
    }

    public void addItem(Item item){
        this.Itens.add(item);
    }

    public List <Receita> getReceitasCriadas(){
        return this.receitasCriadas;
    }


    public void adicionarNivel(Nivel nivel) {
        this.niveis.add(nivel);
    }

    public void listarItensPorNivel(int nivel) {
        for (Nivel n : niveis) {
            if (n.getNumeroNivel() == nivel) {
                n.listarItens();
                return;
            }
        }
        System.out.println("Nível " + nivel + " não encontrado.");
    }
    public boolean verificarNivelCompleto(int nivel){
        if (nivel < 1 || nivel > 4) {
            throw new IllegalArgumentException("Nível deve estar entre 1 e 4.");
        }
        for(Item i: niveis.get(nivel-1).getItens()){
            if(!i.isDesbloqueado()){
                return false;
            }
        }

        return true;
    }

    public void listarReceitasPorNivel(int nivel) {
        for (Nivel n : niveis) {
            if (n.getNumeroNivel() == nivel) {
                n.listarReceitas();
                return;
            }
        }
        System.out.println("Nível " + nivel + " não encontrado.");
    }


    public void listarItens() {
        if(this.Itens.isEmpty()){
            System.out.println("Lista de itens vazia.");
        }
        System.out.println("Lista de itens no inventário:");
        for(Item item: this.Itens){
            if(item.isDesbloqueado()){
                System.out.printf("Item %d: %s\n", item.getIdItem(), item.getNome());
                System.out.printf("%s\n", item.getRaridade());
            }

        }
    }

    public void listarReceitas() {
        int itemId;
        if(this.receitasCriadas.isEmpty()){
            System.out.println("Lista de receitas vazia.");
            return;
        }
        System.out.println("Lista de receitas criadas:");
        for(Receita receita: this.receitasCriadas){
            receita.getProduto().listarItem();
        }
    }
    public void adicionarReceita(Receita receita) {
        this.receitasCriadas.add(receita);
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

    public Receita getReceita(int id){
        for(Receita receita: receitasCriadas){
            if(receita.getIdReceita() == id){
                return receita;
            }
        }
        System.out.println("Id da Receita invalida");
        return null;
    }

    public void desboloquearItem(int id){
        for(Item item: Itens){
            if(item.getIdItem() == id){
                item.setDesbloqueado(true);
                return;
            }
        }
    }

    public Item getItem(int id){
        for(Item item: Itens){
            if(item.getIdItem() == id){
                return item;
            }
        }
        System.out.println("Item inexistente.");
        return null;
    }


}