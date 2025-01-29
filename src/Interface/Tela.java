package Interface;

import javax.swing.*;
import java.awt.*;
import Main.Main;

public class Tela extends JFrame {
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);
    public Inicial inicial = new Inicial();
    public Principal principal = new Principal();
    public PanelTrajetoria panelTrajetoria = new PanelTrajetoria();

    JButton btn1 = new JButton("Jogar");
    JButton btn2 = new JButton("Va para final");
    JButton btn3 = new JButton("Va para inicial");

    public Tela() {
        // Configuração dos botões
        btn1.setBounds((getGraphicsConfiguration().getBounds().width / 2) - 70,
                (getGraphicsConfiguration().getBounds().height / 2) + 150,
                120, 20);
        btn3.setBounds((getGraphicsConfiguration().getBounds().width / 2) - 70,
                (getGraphicsConfiguration().getBounds().height / 2) + 150,
                120, 20);

        // Associa botão ao painel inicial
        inicial.add(btn1);
        principal.add(btn2);
        panelTrajetoria.add(btn3);

        // Paineis principais (card layout)
        mainPanel.add(inicial, "inicial");
        mainPanel.add(principal, "principal");
        mainPanel.add(panelTrajetoria, "trajetoria");

        // Configurações da janela
        this.setTitle("Tela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza janela
        this.setExtendedState(MAXIMIZED_BOTH);
        this.add(mainPanel);
        this.setResizable(false);
        this.setVisible(true);

        // Botão para salvar o nome e mudar de painel
        btn1.addActionListener((e) -> {
            // Obtém o texto do campo de texto no painel inicial
            Inicial inicialPanel = (Inicial) inicial;
            String nome = inicialPanel.getNomeCampo().trim();

            if (!nome.isEmpty()) {
                Main.comecaJogo(nome);
                cardLayout.show(mainPanel, "principal");
                // Atualiza os ícones no painel esquerdo (com itens do inventário)
                principal.atualizarIconesNoPainelEsquerdo();
                System.out.println("FOI");
            } else {
                // Mostra mensagem caso o nome esteja vazio
                JOptionPane.showMessageDialog(this,
                        "Por favor, insira um nome antes de começar!");
            }
        });



        // Botões para outros painéis
        btn2.addActionListener((e) -> {
            //cardLayout.show(mainPanel, "trajetoria");
        });

        /*btn3.addActionListener((e) -> {
            cardLayout.show(mainPanel, "inicial");
        });*/
    }

    public static void main(String[] args) {
        Tela janela = new Tela();
    }
}

