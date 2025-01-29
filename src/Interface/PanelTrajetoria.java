package Interface;

import javax.swing.*;
import java.awt.*;
import Main.Main;

public class PanelTrajetoria extends JPanel {
    private Image backgroundImage;
    private JLabel[] icones;

    public PanelTrajetoria() {
        // Carrega a imagem de fundo
        backgroundImage = new ImageIcon(getClass().getResource("/Images/final_background.png")).getImage();

        // Define o layout como nulo
        this.setLayout(null);
        //this.setBackground(Color.white);

        // Pega o tamanho da tela atual
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Botão "Fechar" (pode ser usado para resetar ou qualquer funcionalidade alternativa, se necessário)
        JButton closeButton = new JButton("Fechar");
        closeButton.setBounds(screenWidth - 150, screenHeight - 100, 100, 30); // Define o tamanho e a posição do botão
        closeButton.addActionListener(e -> {
            // Aqui você pode adicionar a funcionalidade que preferir, como trocar de painel
            SwingUtilities.getWindowAncestor(this).dispose(); // Fecha a janela atual, se for usada dentro de um JFrame
        });

        // Adiciona o botão ao painel
        this.add(closeButton);

        //this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Redimensiona e desenha a imagem de fundo para ocupar toda a tela
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Desenha os textos
        g.setFont(new Font("Arial", Font.BOLD, 32));
        g.setColor(Color.WHITE);
        int textWidth = g.getFontMetrics().stringWidth("Fim de jogo!");
        int xPosition = (getWidth() - textWidth) / 2;
        g.drawString("Parabéns " +Main.jogador.getNome()+ " você ganhou!", xPosition, 100);
        textWidth = g.getFontMetrics().stringWidth("Sua Trajetória foi:!");
        xPosition = (getWidth() - textWidth) / 2;
        g.drawString("Sua Trajetória foi:", xPosition, 150);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("ITENS NÃO DESTRAVADOS:", 50, 200);
        g.drawString("ORDEM DE RECEITAS CRIADAS:", 450, 200);

        // Desenha os ícones simulando um caminho
        int iconSize = 50;
        int startX = 450;
        int startY = 250;
        int step = 100;
        icones = new JLabel[4];
        String[] iconPaths = {"/Images/icone1.png", "/Images/icone2.png", "/Images/icone3.png", "/Images/icone5.png"};

        for (int i = 0; i < icones.length; i++) {
            ImageIcon iconImage = new ImageIcon(getClass().getResource(iconPaths[i]));
            icones[i] = new JLabel(iconImage);
            icones[i].setBounds(450 + (i*100), 250, 50, 50); // Posiciona os ícones no painel esquerdo
            this.add(icones[i]);

            // Desenha setas entre os ícones
            if (i < icones.length - 1) {
                g.drawLine(startX + (i * step) + iconSize, startY + iconSize / 2,
                        startX + ((i + 1) * step), startY + iconSize / 2);
            }
        }


    }

}