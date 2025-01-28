package principal;

import java.util.List;

public class Jogador {
    private int idJogador, nivelAtual;
    private String nome;
    private Inventario inventario;

    public Jogador(int id, String Nome){
        this.idJogador = id;
        this.nome = Nome;
        this.inventario = new Inventario();
        this.nivelAtual = 1;
    }

    public Jogador(int id, String Nome, Inventario inv){
        this.idJogador = id;
        this.nome = Nome;
        this.inventario = inv;
        this.nivelAtual = 1;
    }

    public int getNivelAtual(){
        return this.nivelAtual;
    }

    public void setListaItens(List<Item> itens){

    }
    public void setIdJogador(int id){
        this.idJogador = id;
    }
    public int getIdJogador(){
        return this.idJogador;
    }

    public void setNome(String Nome){
        this.nome = Nome;
    }
    public String getNome(){
        return this.nome;
    }
    public Inventario getInventario(){return this.inventario; };


    public void adicionarReceitaNoInventario(Receita receita){
        inventario.adicionarReceita(receita);
    }

    public Receita getReceita(int id){
        return this.inventario.getReceita(id);
    }

    public void nivelAtualCompleto(){
        if(inventario.verificarNivelCompleto(nivelAtual)){
            this.nivelAtual++;
        }
    }

}
