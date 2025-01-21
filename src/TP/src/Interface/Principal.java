import javax.swing.*;
import java.awt.*;

public class Principal extends JPanel {
    private JLabel nome;
    private JLabel ola;
    private JLabel teste;
    private JTextField nomeCampo;
    private JPanel esqPanel;
    private JPanel dirPanel;
    private Image backgroundImage;

    public Principal() {

        // Carrega a imagem de fundo
        backgroundImage = new ImageIcon(getClass().getResource("/Images/principal_background.png")).getImage();
        this.setLayout(null);
        this.setBackground(Color.white);

        // Pega o tamanho da tela atual
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Painel esquerdo com imagem de fundo
        esqPanel = new JPanel() {
            private Image backgroundImage = new ImageIcon(getClass().getResource("/Images/inventario.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Desenha a imagem como plano de fundo do painel
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }

        };
        Color cor = new Color(0, 74, 173);
        esqPanel.setBackground(cor);

        esqPanel.setBounds(0, 0, screenWidth / 3, screenHeight); // Define o tamanho e posição do painel esquerdo
        esqPanel.setLayout(null); // Configura layout absoluto para componentes adicionais (se necessário)
        this.add(esqPanel);

        /*
        // Painel direito (mantém linha preta como no exemplo original)
        Color cor = new Color(92, 75, 46);
        dirPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g);
                g2d.setColor(Color.BLACK); // Define a cor preta para a linha
                g2d.setStroke(new BasicStroke(3)); // Define espessura da linha
                g2d.drawLine(0, 200, getWidth(), 200); // Desenha a linha horizontal
            }
        };
        dirPanel.setBackground(cor);
        dirPanel.setBounds((screenWidth / 4) * 3, 0, screenWidth / 4, screenHeight); // Posição e dimensões do painel
        this.add(dirPanel);
        */

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo ajustada ao tamanho do painel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
