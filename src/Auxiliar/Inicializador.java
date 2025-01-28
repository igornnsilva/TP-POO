package Auxiliar;
import principal.*;

public class Inicializador {
    public void inicializaNiveis(Inventario inventario) {
        Nivel nivel1 = new Nivel(1); // Comum
        Nivel nivel2 = new Nivel(2); // Incomum
        Nivel nivel3 = new Nivel(3); // Raro
        Nivel nivel4 = new Nivel(4); // Lendário

        // Nível 1 - Comum
        Item destiladoAnao = new Item(1, "Destilado Anão", "destilado_anao.png", true, Raridade.Comum, 0);
        Item cerebroAfogado = new Item(2, "Cérebro de Afogado", "cerebro_afogado.png", true, Raridade.Comum, 0);
        Item agua = new Item(23, "Água", "agua.png", true, Raridade.Comum, 0);
        Item areia = new Item(24, "Areia", "areia.png", true, Raridade.Comum, 0);
        Item pedra = new Item(26, "Pedra", "pedra.png", true, Raridade.Comum, 0);

        nivel1.adicionarItem(destiladoAnao);
        nivel1.adicionarItem(cerebroAfogado);
        nivel1.adicionarItem(agua);
        nivel1.adicionarItem(areia);
        nivel1.adicionarItem(pedra);

        // Receitas do nível 1
        Item swallow = new Item(3, "Swallow", "swallow.png", true, Raridade.Comum, 1);
        Receita receita1 = new Receita(1, 3, 1, 2);
        receita1.setProduto(swallow);
        nivel1.adicionarReceita(receita1);
        nivel1.adicionarItem(swallow);

        Item pocaoCuraSimples = new Item(25, "Poção de Cura Simples", "pocao_cura_simples.png", true, Raridade.Comum, 11);
        Receita receita11 = new Receita(11, 25, 23, 24);
        receita11.setProduto(pocaoCuraSimples);
        nivel1.adicionarReceita(receita11);
        nivel1.adicionarItem(pocaoCuraSimples);

        Item pocaoForca = new Item(27, "Poção de Força", "pocao_forca.png", true, Raridade.Comum, 12);
        Receita receita12 = new Receita(12, 27, 26, 24);
        receita12.setProduto(pocaoForca);
        nivel1.adicionarReceita(receita12);
        nivel1.adicionarItem(pocaoForca);

        Item pocaoDefesa = new Item(28, "Poção de Defesa", "pocao_defesa.png", true, Raridade.Comum, 13);
        Receita receita13 = new Receita(13, 28, 23, 26);
        receita13.setProduto(pocaoDefesa);
        nivel1.adicionarReceita(receita13);
        nivel1.adicionarItem(pocaoDefesa);

        // Nível 2 - Incomum
        Item cortinarius = new Item(4, "Cortinarius", "cortinarius.png", true, Raridade.Incomum, 0);
        Item essenciaAgua = new Item(6, "Essência de Água", "essencia_agua.png", true, Raridade.Incomum, 0);
        Item coracaoGolem = new Item(11, "Coração de Golem", "coracao_golem.png", true, Raridade.Incomum, 0);
        Item terra = new Item(29, "Terra", "terra.png", true, Raridade.Incomum, 0);

        nivel2.adicionarItem(cortinarius);
        nivel2.adicionarItem(essenciaAgua);
        nivel2.adicionarItem(coracaoGolem);
        nivel2.adicionarItem(terra);

        // Receitas do nível 2
        Item thunderboltHerb = new Item(5, "Thunderbolt Herb", "thunderbolt_herb.png", false, Raridade.Incomum, 2);
        Receita receita2 = new Receita(2, 5, 1, 4);
        receita2.setProduto(thunderboltHerb);
        nivel2.adicionarReceita(receita2);
        nivel2.adicionarItem(thunderboltHerb);

        Item catsEye = new Item(7, "Cat's Eye", "cats_eye.png", false, Raridade.Incomum, 3);
        Receita receita3 = new Receita(3, 7, 1, 6);
        receita3.setProduto(catsEye);
        nivel2.adicionarReceita(receita3);
        nivel2.adicionarItem(catsEye);

        Item rubea = new Item(12, "Rubea", "rubea.png", false, Raridade.Incomum, 5);
        Receita receita5 = new Receita(5, 12, 1, 11);
        receita5.setProduto(rubea);
        nivel2.adicionarReceita(receita5);
        nivel2.adicionarItem(rubea);

        Item pocaoEstamina = new Item(30, "Poção de Estamina", "pocao_estamina.png", false, Raridade.Incomum, 14);
        Receita receita14 = new Receita(14, 30, 23, 29);
        receita14.setProduto(pocaoEstamina);
        nivel2.adicionarReceita(receita14);
        nivel2.adicionarItem(pocaoEstamina);

        // Nível 3 - Raro
        Item mandragora = new Item(13, "Mandrágora", "mandragora.png", true, Raridade.Raro, 0);
        Item fumacaDragao = new Item(14, "Fumaça de Dragão", "fumaca_dragao.png", true, Raridade.Raro, 0);
        Item asasMorcego = new Item(16, "Asas de Morcego", "asas_morcego.png", true, Raridade.Raro, 0);
        Item lagrimasFenex = new Item(17, "Lágrimas de Fênix", "lagrimas_fenix.png", true, Raridade.Raro, 0);

        nivel3.adicionarItem(mandragora);
        nivel3.adicionarItem(fumacaDragao);
        nivel3.adicionarItem(asasMorcego);
        nivel3.adicionarItem(lagrimasFenex);

        // Receitas do nível 3
        Item pocaoCuraAvancada = new Item(15, "Poção de Cura Avançada", "pocao_cura_avancada.png", false, Raridade.Raro, 6);
        Receita receita6 = new Receita(6, 15, 13, 14);
        receita6.setProduto(pocaoCuraAvancada);
        nivel3.adicionarReceita(receita6);
        nivel3.adicionarItem(pocaoCuraAvancada);

        Item pocaoAmor = new Item(18, "Poção do Amor", "pocao_amor.png", false, Raridade.Raro, 7);
        Receita receita7 = new Receita(7, 18, 16, 17);
        receita7.setProduto(pocaoAmor);
        nivel3.adicionarReceita(receita7);
        nivel3.adicionarItem(pocaoAmor);

        Item pocaoVerdade = new Item(21, "Poção da Verdade", "pocao_verdade.png", false, Raridade.Raro, 9);
        Receita receita9 = new Receita(9, 21, 17, 13);
        receita9.setProduto(pocaoVerdade);
        nivel3.adicionarReceita(receita9);
        nivel3.adicionarItem(pocaoVerdade);

        Item pocaoFogo = new Item(22, "Poção de Fogo", "pocao_fogo.png", false, Raridade.Raro, 10);
        Receita receita10 = new Receita(10, 22, 14, 16);
        receita10.setProduto(pocaoFogo);
        nivel3.adicionarReceita(receita10);
        nivel3.adicionarItem(pocaoFogo);

        // Nível 4 - Lendário
        Item gaivotaBranca = new Item(8, "Gaivota Branca", "gaivota_branca.png", true, Raridade.Lendario, 0);
        Item rebis = new Item(9, "Rebis", "rebis.png", true, Raridade.Lendario, 0);
        Item raizMandragora = new Item(19, "Raiz de Mandrágora", "raiz_mandragora.png", true, Raridade.Lendario, 0);

        nivel4.adicionarItem(gaivotaBranca);
        nivel4.adicionarItem(rebis);
        nivel4.adicionarItem(raizMandragora);

        // Receitas do nível 4
        Item whiteGull = new Item(10, "White Gull", "white_gull.png", false, Raridade.Lendario, 4);
        Receita receita4 = new Receita(4, 10, 8, 9);
        receita4.setProduto(whiteGull);
        nivel4.adicionarReceita(receita4);
        nivel4.adicionarItem(whiteGull);

        Item pocaoInvocacao = new Item(20, "Poção de Invocação", "pocao_invocacao.png", false, Raridade.Lendario, 8);
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
