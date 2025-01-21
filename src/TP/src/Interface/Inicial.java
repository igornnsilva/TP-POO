import javax.swing.*;
import java.awt.*;

public class Inicial extends JPanel {
    private JLabel nome;
    private JLabel titulo;
    private JTextField nomeCampo;
    private Image backgroundImage;

    public Inicial() {
        // Carrega a imagem de fundo
        backgroundImage = new ImageIcon(getClass().getResource("/Images/inicio_background.png")).getImage();

        // Define o layout como null para posicionamento absoluto
        this.setLayout(null);

        // Obtém o tamanho da tela atual
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Configuração do título
        titulo = new JLabel("POOcraft", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        titulo.setBounds((screenWidth - 250) / 2, (screenHeight / 2) - 250, 250, 150);
        this.add(titulo);

        // Configuração do nome JLabel
        nome = new JLabel("Nome:");
        nome.setFont(new Font("Arial", Font.PLAIN, 16));
        nome.setForeground(Color.white);
        nome.setBounds((screenWidth / 2) - 100, screenHeight / 2, 60, 25);
        this.add(nome);

        // Configuração do campo de entrada de nome
        nomeCampo = new JTextField();
        nomeCampo.setBounds((screenWidth / 2) - 30, screenHeight / 2, 150, 25);
        this.add(nomeCampo);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo ajustada ao tamanho do painel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

}
