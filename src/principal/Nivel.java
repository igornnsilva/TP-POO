package principal;

import java.util.ArrayList;
import java.util.List;


//Classe responsável por representar um nível do jogo, Listando itens e receitas
public class Nivel {
    private int numeroNivel;
    private List<Item> itens;
    private List<Receita> receitas;

    public Nivel(int numeroNivel) {
        this.numeroNivel = numeroNivel;
        this.itens = new ArrayList<>();
        this.receitas = new ArrayList<>();
    }

    public int getNumeroNivel() {
        return numeroNivel;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Item getItem(int id){
        for(Item item: itens){
            if(item.getIdItem() == id){
                return item;
            }
        }
        System.out.println("Item inexistente.");
        return null;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);
    }

    public void listarItens() {
        System.out.println("Itens do Nível " + numeroNivel + ":");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item disponível neste nível.");
        } else {
            for (Item item : itens) {
                if(item.isDesbloqueado()){
                    System.out.printf("- %s (ID: %d, Raridade: %s)\n", item.getNome(), item.getIdItem(), item.getRaridade());
                }

            }
        }
    }

    public void listarItensCadastrados() {
        System.out.println("Itens do Nível " + numeroNivel + ":");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item disponível neste nível.");
        } else {
            for (Item item : itens) {
                System.out.printf("- %s (ID: %d, Raridade: %s)\n", item.getNome(), item.getIdItem(), item.getRaridade());
            }
        }
    }

    public void listarReceitas() {
        System.out.println("Receitas do Nível " + numeroNivel + ":");
        if (receitas.isEmpty()) {
            System.out.println("Nenhuma receita disponível neste nível.");
        } else {
            for (Receita receita : receitas) {
                System.out.printf("- %s (ID Receita: %d, Produto: %s)\n",
                        receita.getProduto().getNome(),
                        receita.getIdReceita(),
                        receita.getProduto().getNome());
            }
        }
    }
}