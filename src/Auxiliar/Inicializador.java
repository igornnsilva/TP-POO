package Auxiliar;
import principal.*;

public class Inicializador {

    public void inicializaItens(Inventario inv){
        Item temp = new Item(1, "Destilado Anão","icone1.png", true, Raridade.Comum,0);
        inv.addItem(temp);
        temp = new Item(2, "Cérebro de Afogado", "icone2.png", true, Raridade.Comum,0);
        inv.addItem(temp);
        temp = new Item(3, "Andorinha", "icone3.png", false, Raridade.Comum, 1);
        inv.addItem(temp);
        temp = new Item(4, "Suco de Tolete", "icone5.png", true, Raridade.Raro,0);
        inv.addItem(temp);
        temp = new Item(5, "Acônito", "icone3.png", true, Raridade.Comum,0);
        inv.addItem(temp);
        temp = new Item(6, "Poção Wiggenweld", "icone4.png", false, Raridade.Raro,1);
        inv.addItem(temp);

    }

    public void inicializaReceitas(Inventario inv){
        Receita temp = new Receita(1, 3, 1, 2);
        Item temp2 = inv.getItem(3);
        temp.setProduto(temp2);
        inv.adicionarReceita(temp);
        temp = new Receita(2, 6, 4, 5);
        temp2 = inv.getItem(6);
        temp.setProduto(temp2);
        inv.adicionarReceita(temp);

    }

    public void inicializaNiveis(Inventario inventario) {
        Nivel nivel1 = new Nivel(1); // Comum
        Nivel nivel2 = new Nivel(2); // Incomum
        Nivel nivel3 = new Nivel(3); // Raro
        Nivel nivel4 = new Nivel(4); // Lendário

        // Nível 1 - Comum
        Item destiladoAnao = new Item(1, "Destilado Anão", "um.jpg", true, Raridade.Comum, 0);
        Item cerebroAfogado = new Item(2, "Cérebro de Afogado", "dois.jpg", true, Raridade.Comum, 0);
        Item agua = new Item(23, "Água", "tres.jpg", true, Raridade.Comum, 0);
        Item areia = new Item(24, "Areia", "quatro.jpg", true, Raridade.Comum, 0);
        Item pedra = new Item(26, "Pedra", "cinco.jpg", true, Raridade.Comum, 0);

        nivel1.adicionarItem(destiladoAnao);
        nivel1.adicionarItem(cerebroAfogado);
        nivel1.adicionarItem(agua);
        nivel1.adicionarItem(areia);
        nivel1.adicionarItem(pedra);

        // Receitas do nível 1
        Item swallow = new Item(3, "Swallow", "seis.jpg", false, Raridade.Comum, 1);
        Receita receita1 = new Receita(1, 3, 1, 2);
        receita1.setProduto(swallow);
        nivel1.adicionarReceita(receita1);
        nivel1.adicionarItem(swallow);

        Item pocaoCuraSimples = new Item(25, "Poção de Cura Simples", "sete.jpg", false, Raridade.Comum, 11);
        Receita receita11 = new Receita(11, 25, 23, 24);
        receita11.setProduto(pocaoCuraSimples);
        nivel1.adicionarReceita(receita11);
        nivel1.adicionarItem(pocaoCuraSimples);

        Item pocaoForca = new Item(27, "Poção de Força", "oito.jpg", false, Raridade.Comum, 12);
        Receita receita12 = new Receita(12, 27, 26, 24);
        receita12.setProduto(pocaoForca);
        nivel1.adicionarReceita(receita12);
        nivel1.adicionarItem(pocaoForca);

        Item pocaoDefesa = new Item(28, "Poção de Defesa", "nove.jpg", false, Raridade.Comum, 13);
        Receita receita13 = new Receita(13, 28, 23, 26);
        receita13.setProduto(pocaoDefesa);
        nivel1.adicionarReceita(receita13);
        nivel1.adicionarItem(pocaoDefesa);

        // Nível 2 - Incomum
        Item cortinarius = new Item(4, "Cortinarius", "dois.jpg", true, Raridade.Incomum, 0);
        Item essenciaAgua = new Item(6, "Essência de Água", "dois.jpg", true, Raridade.Incomum, 0);
        Item coracaoGolem = new Item(11, "Coração de Golem", "dois.jpg", true, Raridade.Incomum, 0);
        Item terra = new Item(29, "Terra", "dois.jpg", true, Raridade.Incomum, 0);

        nivel2.adicionarItem(cortinarius);
        nivel2.adicionarItem(essenciaAgua);
        nivel2.adicionarItem(coracaoGolem);
        nivel2.adicionarItem(terra);

        // Receitas do nível 2
        Item thunderboltHerb = new Item(5, "Thunderbolt Herb", "dois.jpg", false, Raridade.Incomum, 2);
        Receita receita2 = new Receita(2, 5, 1, 4);
        receita2.setProduto(thunderboltHerb);
        nivel2.adicionarReceita(receita2);
        nivel2.adicionarItem(thunderboltHerb);

        Item catsEye = new Item(7, "Cat's Eye", "dois.jpg", false, Raridade.Incomum, 3);
        Receita receita3 = new Receita(3, 7, 1, 6);
        receita3.setProduto(catsEye);
        nivel2.adicionarReceita(receita3);
        nivel2.adicionarItem(catsEye);

        Item rubea = new Item(12, "Rubea", "dois.jpg", false, Raridade.Incomum, 5);
        Receita receita5 = new Receita(5, 12, 1, 11);
        receita5.setProduto(rubea);
        nivel2.adicionarReceita(receita5);
        nivel2.adicionarItem(rubea);

        Item pocaoEstamina = new Item(30, "Poção de Estamina", "dois.jpg", false, Raridade.Incomum, 14);
        Receita receita14 = new Receita(14, 30, 23, 29);
        receita14.setProduto(pocaoEstamina);
        nivel2.adicionarReceita(receita14);
        nivel2.adicionarItem(pocaoEstamina);

        // Nível 3 - Raro
        Item mandragora = new Item(13, "Mandrágora", "nove.jpg", true, Raridade.Raro, 0);
        Item fumacaDragao = new Item(14, "Fumaça de Dragão", "nove.jpg", true, Raridade.Raro, 0);
        Item asasMorcego = new Item(16, "Asas de Morcego", "nove.jpg", true, Raridade.Raro, 0);
        Item lagrimasFenex = new Item(17, "Lágrimas de Fênix", "nove.jpg", true, Raridade.Raro, 0);

        nivel3.adicionarItem(mandragora);
        nivel3.adicionarItem(fumacaDragao);
        nivel3.adicionarItem(asasMorcego);
        nivel3.adicionarItem(lagrimasFenex);

        // Receitas do nível 3
        Item pocaoCuraAvancada = new Item(15, "Poção de Cura Avançada", "nove.jpg", false, Raridade.Raro, 6);
        Receita receita6 = new Receita(6, 15, 13, 14);
        receita6.setProduto(pocaoCuraAvancada);
        nivel3.adicionarReceita(receita6);
        nivel3.adicionarItem(pocaoCuraAvancada);

        Item pocaoAmor = new Item(18, "Poção do Amor", "nove.jpg", false, Raridade.Raro, 7);
        Receita receita7 = new Receita(7, 18, 16, 17);
        receita7.setProduto(pocaoAmor);
        nivel3.adicionarReceita(receita7);
        nivel3.adicionarItem(pocaoAmor);

        Item pocaoVerdade = new Item(21, "Poção da Verdade", "nove.jpg", false, Raridade.Raro, 9);
        Receita receita9 = new Receita(9, 21, 17, 13);
        receita9.setProduto(pocaoVerdade);
        nivel3.adicionarReceita(receita9);
        nivel3.adicionarItem(pocaoVerdade);

        Item pocaoFogo = new Item(22, "Poção de Fogo", "nove.jpg", false, Raridade.Raro, 10);
        Receita receita10 = new Receita(10, 22, 14, 16);
        receita10.setProduto(pocaoFogo);
        nivel3.adicionarReceita(receita10);
        nivel3.adicionarItem(pocaoFogo);

        // Nível 4 - Lendário
        Item gaivotaBranca = new Item(8, "Gaivota Branca", "nove.jpg", true, Raridade.Lendario, 0);
        Item rebis = new Item(9, "Rebis", "nove.jpg", true, Raridade.Lendario, 0);
        Item raizMandragora = new Item(19, "Raiz de Mandrágora", "nove.jpg", true, Raridade.Lendario, 0);

        nivel4.adicionarItem(gaivotaBranca);
        nivel4.adicionarItem(rebis);
        nivel4.adicionarItem(raizMandragora);

        // Receitas do nível 4
        Item whiteGull = new Item(10, "White Gull", "nove.jpg", false, Raridade.Lendario, 4);
        Receita receita4 = new Receita(4, 10, 8, 9);
        receita4.setProduto(whiteGull);
        nivel4.adicionarReceita(receita4);
        nivel4.adicionarItem(whiteGull);

        Item pocaoInvocacao = new Item(20, "Poção de Invocação", "nove.jpg", false, Raridade.Lendario, 8);
        Receita receita8 = new Receita(8, 20, 19, 14);
        receita8.setProduto(pocaoInvocacao);
        nivel4.adicionarReceita(receita8);
        nivel4.adicionarItem(pocaoInvocacao);

        // Adicionando os níveis ao inventário
        inventario.adicionarNivel(nivel1);
        inventario.adicionarNivel(nivel2);
        inventario.adicionarNivel(nivel3);
        inventario.adicionarNivel(nivel4);
    }
}