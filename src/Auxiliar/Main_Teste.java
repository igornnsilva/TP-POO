package Auxiliar;

import principal.Controlador;
import principal.Inventario;
import principal.Jogador;
import principal.Mesa;

import java.util.Scanner;

public class Main_Teste {
    public static void main(String[] args) {
        Inicializador inicializador = new Inicializador();
        Controlador ctr = new Controlador();
        Mesa Craft = ctr.criarMesa();
        Inventario temp = new Inventario();
        Scanner leitor = new Scanner(System.in);
        Jogador jogador = new Jogador(1, "Gabriel", temp);

        inicializador.inicializaNiveis(temp);
        jogador.nivelAtualCompleto();


        jogador.getInventario().listarItensPorNivel(jogador.getNivelAtual());
        jogador.getInventario().listarReceitasPorNivel(1);



    }
}
