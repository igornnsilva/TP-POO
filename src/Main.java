import principal.*;
import Auxiliar.Inicializador;
import java.util.Scanner;

public class Main {

    // Método para adicionar um atraso entre as mensagens
    public static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //Método para limpar a tela usando códigos ANSI
    public static void limparTela() {
        System.out.print("\033[H\033[2J"); // Código ANSI para limpar a tela
        System.out.flush();
    }

    // Método para imprimir texto com atraso caractere por caractere
    public static void escreverComEfeito(String texto, long atrasoPorChar) {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            delay(atrasoPorChar);
        }
        System.out.println(); // Pular linha ao final
    }

    public static void main(String[] args) {
        Inicializador inicializador = new Inicializador();
        Controlador ctr = new Controlador();
        Mesa Craft = ctr.criarMesa();
        Inventario temp = new Inventario();
        Scanner leitor = new Scanner(System.in);

        inicializador.inicializaItens(temp);
        inicializador.inicializaReceitas(temp);

        int com = -1;

        limparTela(); // Limpa o terminal
        escreverComEfeito("Bem vindo ao POOcraft!", 50); // Texto com efeito de digitação
        System.out.printf("Digite o nome do usuário: ");
        String nome = leitor.nextLine();
        Jogador jogador = new Jogador(1, nome, temp);

        while (com != 0) {
            limparTela(); // Limpa a tela no início do loop
            escreverComEfeito("Bem vindo " + jogador.getNome() + "!", 50);
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Listar Itens");
            System.out.println("2 - Listar Receitas");
            System.out.println("3 - Craftar");
            System.out.println("0 - Sair");

            com = leitor.nextInt();
            leitor.nextLine(); // Consumir a quebra de linha após o número

            if (com == 1) {
                limparTela();
                jogador.getInventario().listarItens();
                System.out.println("Pressione Enter para continuar...");
                leitor.nextLine();
            } else if (com == 2) {
                limparTela();
                jogador.getInventario().listarReceitas();
                System.out.println("Pressione Enter para continuar...");
                leitor.nextLine();
            } else if (com == 3) {
                limparTela();


                System.out.println("Digite o Primeiro item:");
                int idItem1 = leitor.nextInt();
                leitor.nextLine();
                System.out.println("Digite o Segundo item:");
                int idItem2 = leitor.nextInt();
                leitor.nextLine();

                Craft.craftItem(jogador.getInventario(), idItem1, idItem2);
                System.out.println("Pressione Enter para continuar...");
                try {
                    System.out.println("Item craftado: " + Craft.getItemFinal().getNome());
                } catch (Exception NullPointerException) {
                    System.out.println("Combinação de produtos não craftável.");
                }

                leitor.nextLine();
            }
        }

        limparTela();
        escreverComEfeito("Obrigado por jogar POOcraft! Até a próxima!", 50);
    }
}