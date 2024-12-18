public class Item {
    private int idItem;
    private String nome;
    private String nomeIcone;
    private boolean desbloqueado;
    private Raridade raridade;
    public Item(int idItem, String nome, String nomeIcone, boolean desbloqueado, Raridade raridade) {
        this.idItem = idItem;
        this.nome = nome;
        this.nomeIcone = nomeIcone;
        this.desbloqueado = desbloqueado;
        this.raridade = raridade;
    }

    public int getIdItem() {
        return idItem;
    }
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNomeIcone() {
        return nomeIcone;
    }
    public void adicionarIcone(String nomeIcone) {
        this.nomeIcone = nomeIcone;
    }
    public boolean isDesbloqueado() {
        return desbloqueado;
    }
    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }
    public Raridade getRaridade() {
        return raridade;
    }
    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }



}
