package Auxiliar;
import principal.*;

public class Inicializador {
    public void inicializaNiveis(Inventario inventario) {
        Nivel nivel1 = new Nivel(1); // Comum
        Nivel nivel2 = new Nivel(2); // Incomum
        Nivel nivel3 = new Nivel(3); // Raro
        Nivel nivel4 = new Nivel(4); // Lendário

        // Adicionando itens ao nível 1 (Comum)
        Item destiladoAnao = new Item(1, "Destilado Anão", "destilado_anao.png", true, Raridade.Comum, 0);
        Item cerebroAfogado = new Item(2, "Cérebro de Afogado", "cerebro_afogado.png", true, Raridade.Comum, 0);
        nivel1.adicionarItem(destiladoAnao);
        nivel1.adicionarItem(cerebroAfogado);

        // Receita do nível 1
        Item swallow = new Item(3, "Swallow", "swallow.png", false, Raridade.Comum, 1);
        Receita receita1 = new Receita(1, 3, 1, 2);
        receita1.setProduto(swallow);
        nivel1.adicionarReceita(receita1);

        // Adicionando itens ao nível 2 (Incomum)
        Item cortinarius = new Item(4, "Cortinarius", "cortinarius.png", true, Raridade.Incomum, 0);
        Item essenciaAgua = new Item(5, "Essência de Água", "essencia_agua.png", true, Raridade.Incomum, 0);
        Item coracaoGolem = new Item(6, "Coração de Golem", "coracao_golem.png", true, Raridade.Incomum, 0);
        nivel2.adicionarItem(cortinarius);
        nivel2.adicionarItem(essenciaAgua);
        nivel2.adicionarItem(coracaoGolem);

        // Receitas do nível 2
        Item thunderboltHerb = new Item(7, "Thunderbolt Herb", "thunderbolt_herb.png", false, Raridade.Incomum, 1);
        Receita receita2 = new Receita(2, 7, 1, 4);
        receita2.setProduto(thunderboltHerb);
        nivel2.adicionarReceita(receita2);

        Item catsEye = new Item(8, "Cat's Eye", "cats_eye.png", false, Raridade.Incomum, 1);
        Receita receita3 = new Receita(3, 8, 1, 5);
        receita3.setProduto(catsEye);
        nivel2.adicionarReceita(receita3);

        Item rubea = new Item(9, "Rubea", "rubea.png", false, Raridade.Incomum, 1);
        Receita receita4 = new Receita(4, 9, 1, 6);
        receita4.setProduto(rubea);
        nivel2.adicionarReceita(receita4);

        // Adicionando itens ao nível 3 (Raro)
        Item mandragora = new Item(10, "Mandrágora", "mandragora.png", true, Raridade.Raro, 0);
        Item fumacaDragao = new Item(11, "Fumaça de Dragão", "fumaca_dragao.png", true, Raridade.Raro, 0);
        Item asasMorcego = new Item(12, "Asas de Morcego", "asas_morcego.png", true, Raridade.Raro, 0);
        Item lagrimasFenex = new Item(13, "Lágrimas de Fênix", "lagrimas_fenix.png", true, Raridade.Raro, 0);
        nivel3.adicionarItem(mandragora);
        nivel3.adicionarItem(fumacaDragao);
        nivel3.adicionarItem(asasMorcego);
        nivel3.adicionarItem(lagrimasFenex);

        // Receitas do nível 3
        Item pocaoCuraAvancada = new Item(14, "Poção de Cura Avançada", "pocao_cura_avancada.png", false, Raridade.Raro, 1);
        Receita receita5 = new Receita(5, 14, 10, 11);
        receita5.setProduto(pocaoCuraAvancada);
        nivel3.adicionarReceita(receita5);

        Item pocaoAmor = new Item(15, "Poção do Amor", "pocao_amor.png", false, Raridade.Raro, 1);
        Receita receita6 = new Receita(6, 15, 12, 13);
        receita6.setProduto(pocaoAmor);
        nivel3.adicionarReceita(receita6);

        Item pocaoVerdade = new Item(16, "Poção da Verdade", "pocao_verdade.png", false, Raridade.Raro, 1);
        Receita receita7 = new Receita(7, 16, 13, 10);
        receita7.setProduto(pocaoVerdade);
        nivel3.adicionarReceita(receita7);

        Item pocaoFogo = new Item(17, "Poção de Fogo", "pocao_fogo.png", false, Raridade.Raro, 1);
        Receita receita8 = new Receita(8, 17, 11, 12);
        receita8.setProduto(pocaoFogo);
        nivel3.adicionarReceita(receita8);

        // Adicionando itens ao nível 4 (Lendário)
        Item gaivotaBranca = new Item(18, "Gaivota Branca", "gaivota_branca.png", true, Raridade.Lendario, 0);
        Item rebis = new Item(19, "Rebis", "rebis.png", true, Raridade.Lendario, 0);
        Item raizMandragora = new Item(20, "Raiz de Mandrágora", "raiz_mandragora.png", true, Raridade.Lendario, 0);
        nivel4.adicionarItem(gaivotaBranca);
        nivel4.adicionarItem(rebis);
        nivel4.adicionarItem(raizMandragora);

        // Receitas do nível 4
        Item whiteGull = new Item(21, "White Gull", "white_gull.png", false, Raridade.Lendario, 1);
        Receita receita9 = new Receita(9, 21, 18, 19);
        receita9.setProduto(whiteGull);
        nivel4.adicionarReceita(receita9);

        Item pocaoInvocacao = new Item(22, "Poção de Invocação", "pocao_invocacao.png", false, Raridade.Lendario, 1);
        Receita receita10 = new Receita(10, 22, 20, 11);
        receita10.setProduto(pocaoInvocacao);
        nivel4.adicionarReceita(receita10);

        // Adicionando os níveis ao inventário
        inventario.adicionarNivel(nivel1);
        inventario.adicionarNivel(nivel2);
        inventario.adicionarNivel(nivel3);
        inventario.adicionarNivel(nivel4);
    }
}
