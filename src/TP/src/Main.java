public class Main {
    public static void main(String[] args) {

         Controlador ctr = new Controlador();
         Jogador Gabriel = ctr.criarJogador(1, "Gabriel");
         Mesa Craft = ctr.criarMesa();

         Gabriel.adicionarItemNoInventario(1, "Destilado Anão","Destilado Anão", true, Raridade.Comum);
         Gabriel.adicionarItemNoInventario(2, "Cérebro de Afogado", "Cérebro de Afogado", true, Raridade.Comum);



         Item I_Andorinha = new Item(3, "Andorinha", "Andorinha", true, Raridade.Comum);
         Receita Andorinha = new Receita(1, I_Andorinha, 1, 2);

        Gabriel.adicionarReceitaNoInventario(Andorinha);



        Craft.craftarReceita(Gabriel.getReceita(1),Gabriel.getInventario() );
        Gabriel.getInventario().listarItens();


    }
}
