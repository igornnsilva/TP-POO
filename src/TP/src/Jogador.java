public class Jogador {
    private int idJogador;
    private String nome;
    private Inventario inventario;

    public Jogador(int id, String Nome){
        this.idJogador = id;
        this.nome = Nome;
        this.inventario = new Inventario();
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

    public void adicionarItemNoInventario(int idItem, String nome, String nomeIcone, boolean desbloqueado, Raridade raridade){
        this.inventario.adicionarItem(idItem, nome, nomeIcone, desbloqueado, raridade);
    }

}
