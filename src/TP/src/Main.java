public class Main {
    public static void main(String[] args) {

        Item barro = new Item(3, "Barro", "Barro", true, Raridade.Comum); // Pensar se faz a criação do item no inventário ou na classe main
        Receita Barro = new Receita(1, barro, 1, 2);

        Inventario inventario = new Inventario();
        inventario.adicionarItem(1, "Agua", "Agua", true, Raridade.Comum);
        inventario.adicionarItem(2, "Terra", "Terra", true, Raridade.Comum);
        inventario.adicionarReceita(Barro);
        inventario.listarItens();



        //Teste Craft
        Mesa teste = new Mesa();


        teste.craftarReceita(inventario.getReceita(1), inventario);
        inventario.listarItens();
    }
}
