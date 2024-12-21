public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Item agua = new Item(1, "Agua", "Agua", true, Raridade.Comum);
        Item terra = new Item(2, "Terra", "Terra", true, Raridade.Comum);
        Item barro = new Item(3, "Barro", "Barro", true, Raridade.Comum);
        Receita Barro = new Receita(1, barro);
        Barro.setItemLista(agua);
        Barro.setItemLista(terra);
        Inventario inventario = new Inventario();
        inventario.adicionarItem(agua);
        inventario.adicionarItem(terra);
        inventario.adicionarReceita(Barro);
        inventario.listarItens();
    }
}