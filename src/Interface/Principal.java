package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JPanel {
    private JPanel esqPanel;
    private JPanel dirPanel;
    private JLabel moldura1;
    private JLabel moldura2;
    private JLabel[] icones; // Ícones no painel esquerdo
    private JLabel[] molduras; // Referência aos quadrados no painel direito
    private Image backgroundImage;

    public Principal() {

        // Carrega a imagem de fundo
        backgroundImage = new ImageIcon(getClass().getResource("/Images/principal_background.png")).getImage();
        this.setLayout(null);
        //this.setBackground(Color.white);

        // Pega o tamanho da tela atual
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Painel esquerdo com imagem de fundo
        esqPanel = new JPanel() {
            private Image inventario = new ImageIcon(getClass().getResource("/Images/inventario.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Desenha a imagem como plano de fundo do painel
                if (inventario != null) {
                    g.drawImage(inventario, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        Color cor = new Color(0, 74, 173);
        esqPanel.setBackground(cor);

        esqPanel.setBounds(0, 0, screenWidth / 3, screenHeight);
        esqPanel.setLayout(null);
        this.add(esqPanel);

        // Cria os ícones no painel esquerdo
        icones = new JLabel[3];
        String[] iconPaths = {"/Images/icone1.png", "/Images/icone2.png", "/Images/icone3.png"};
        for (int i = 0; i < icones.length; i++) {
            ImageIcon iconImage = new ImageIcon(getClass().getResource(iconPaths[i]));
            icones[i] = new JLabel(iconImage);
            icones[i].setBounds(100 + (i * 100), 300, 64, 64); // Posiciona os ícones no painel esquerdo
            esqPanel.add(icones[i]);

            // Adiciona funcionalidade de clique nos ícones
            int index = i;
            icones[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    colocarIconeNaMoldura(iconPaths[index]);
                }
            });
        }

        // Painel direito contendo duas molduras
        dirPanel = new JPanel();
        dirPanel.setBounds((screenWidth / 3), 0, screenWidth / 3 * 2, screenHeight);
        dirPanel.setLayout(null);
        dirPanel.setBackground(new Color(240, 240, 240, 0)); // Define uma cor de fundo clara
        this.add(dirPanel);

        // Molduras para exibir os ícones clicados
        moldura1 = criarMoldura(400, 350); // Posição e tamanho da moldura 1
        dirPanel.add(moldura1);

        moldura2 = criarMoldura(600, 350); // Posição e tamanho da moldura 2
        dirPanel.add(moldura2);

        // Lista de molduras
        molduras = new JLabel[]{moldura1, moldura2};
    }

    private JLabel criarMoldura(int x, int y) {
        JLabel moldura = new JLabel();
        moldura.setBounds(x, y, 100, 100);
        moldura.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Borda preta
        moldura.setOpaque(true);
        moldura.setBackground(Color.WHITE);
        moldura.setHorizontalAlignment(SwingConstants.CENTER);
        moldura.setVerticalAlignment(SwingConstants.CENTER);

        // Adiciona funcionalidade para limpar ícone ao clicar na moldura
        moldura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moldura.setIcon(null); // Remove o ícone da moldura
            }
        });

        return moldura;
    }

    private void colocarIconeNaMoldura(String iconPath) {
        // Verifica qual moldura está vazia para inserir o ícone
        for (JLabel moldura : molduras) {
            if (moldura.getIcon() == null) { // Se a moldura não tiver ícone
                moldura.setIcon(new ImageIcon(getClass().getResource(iconPath)));
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo ajustada ao tamanho do painel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new Principal());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }*/
}

