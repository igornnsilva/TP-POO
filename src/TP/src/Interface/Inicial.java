/*package com;

import javax.swing.*;
import java.awt.*;

public class Inicial extends JPanel {
    private JLabel nome;
    private JLabel titulo;
    private JTextField nomeCampo;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background image and scale it to fill the entire space
        Image backgroundImage = new ImageIcon(getClass().getResource("/Images/inicio_background.png")).getImage();
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }


    public Inicial() {
        this.setLayout(null);
        //Color cor = new Color(102, 255, 255);
        //this.setBackground(cor);

        // Pega o tamanho da tela atual
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Título
        titulo = new JLabel("POOcraft", SwingConstants.CENTER);
        int tituloWidth = 250;
        int tituloHeight = 150;
        titulo.setBounds((screenWidth - tituloWidth) / 2, (screenHeight / 2) - 250, tituloWidth, tituloHeight);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.black);
        this.add(titulo);

        // Dimensões dos elementos
        int nomeWidth = 40;       // Largura do JLabel "Nome"
        int nomeHeight = 20;      // Altura do JLabel "Nome"
        int nomeCampoWidth = 150; // Largura do campo de texto
        int nomeCampoHeight = 25; // Altura do campo de texto

        // Calcula a largura total do conjunto
        int conjuntoWidth = nomeWidth + 10 + nomeCampoWidth;

        // Posição inicial do conjunto (centralizado no eixo X)
        int conjuntoStartX = (screenWidth - conjuntoWidth) / 2;

        // Posição no eixo Y
        int conjuntoY = screenHeight / 2;

        // Nome (à esquerda)
        nome = new JLabel("Nome", SwingConstants.RIGHT); // Alinha o texto à direita dentro do JLabel
        nome.setBounds(conjuntoStartX, conjuntoY, nomeWidth, nomeHeight);
        this.add(nome);

        // Campo para nome (à direita de "Nome")
        nomeCampo = new JTextField();
        nomeCampo.setBounds(conjuntoStartX + nomeWidth + 10, conjuntoY, nomeCampoWidth, nomeCampoHeight);
        this.add(nomeCampo);

        this.setVisible(true);
    }

}
*/

package Interface;

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
