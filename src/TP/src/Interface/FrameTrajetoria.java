import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameTrajetoria extends JFrame {
    private Image backgroundImage;

    public FrameTrajetoria() {
        // Carrega a imagem de fundo
        backgroundImage = new ImageIcon(getClass().getResource("/Images/Frametrajetoria.jpeg")).getImage();

        // Define o layout como nulo
        this.setLayout(null);
        this.setBackground(Color.white);

        // Pega o tamanho da tela atual
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Ajusta o tamanho do frame para o tamanho da tela
        this.setSize(screenWidth, screenHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centraliza o frame na tela

        // Cria um botão para fechar a janela
        JButton closeButton = new JButton("Fechar");
        closeButton.setBounds(screenWidth - 150, screenHeight - 100, 100, 30); // Define o tamanho e a posição do botão
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
            }
        });

        // Adiciona o botão ao frame
        this.add(closeButton);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Redimensiona e desenha a imagem de fundo para ocupar toda a tela
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Desenha os textos
        g.setFont(new Font("Arial", Font.BOLD, 32));
        g.setColor(Color.WHITE);
        int textWidth = g.getFontMetrics().stringWidth("Fim de jogo!");
        int xPosition = (getWidth() - textWidth) / 2;
        g.drawString("Fim de jogo!", xPosition, 100);
        textWidth = g.getFontMetrics().stringWidth("Sua Trajetória foi:!");
        xPosition = (getWidth() - textWidth) / 2;
        g.drawString("Sua Trajetória foi:!", xPosition, 150);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("ITENS NÃO DESTRAVADOS:", 50, 200);
        g.drawString("ORDEM DE RECEITAS CRIADAS:", 450, 200);

        // Desenha os ícones simulando um caminho
        int iconSize = 50;
        int startX = 450;
        int startY = 250;
        int step = 100;
        String[] icons = {
            "/Images/icon1.png", "/Images/icon2.jpg", "/Images/icon3.png", "/Images/icon5.png"
        };

        for (int i = 0; i < icons.length; i++) {
            Image icon = new ImageIcon(getClass().getResource(icons[i])).getImage();
            g.drawImage(icon, startX + (i * step), startY, iconSize, iconSize, this);
            // Desenha setas entre os ícones
            if (i < icons.length - 1) {
                g.drawLine(startX + (i * step) + iconSize, startY + iconSize / 2,
                        startX + ((i + 1) * step), startY + iconSize / 2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrameTrajetoria frame = new FrameTrajetoria();
            frame.setVisible(true);
        });
    }
}
