package Interface;

import principal.Nivel;
import principal.Item;
import principal.Inventario;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JPanel {
    private JPanel esqPanel;
    private JPanel dirPanel;
    private JLabel moldura1;
    private JLabel moldura2;
    private JLabel[] molduras; // Referência aos quadrados no painel direito
    private Image backgroundImage;

    public Principal() {

        // Carrega a imagem de fundo
        backgroundImage = new ImageIcon(getClass().getResource("/Images/principal_background.png")).getImage();
        this.setLayout(null);

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

        // Painel direito contendo duas molduras
        dirPanel = new JPanel();
        dirPanel.setBounds((screenWidth / 3), 0, screenWidth / 3 * 2, screenHeight);
        dirPanel.setLayout(null);
        dirPanel.setOpaque(false); // Garante que o fundo seja transparente para exibir o do painel principal
        this.add(dirPanel);


        // Molduras para exibir os ícones clicados
        moldura1 = criarMoldura(400, 350); // Posição e tamanho da moldura 1
        dirPanel.add(moldura1);

        moldura2 = criarMoldura(600, 350); // Posição e tamanho da moldura 2
        dirPanel.add(moldura2);

        // Lista de molduras
        molduras = new JLabel[]{moldura1, moldura2};

        // Adicionar botão "Craftar"
        adicionarBotaoCraftar(moldura1, moldura2);

        // Adiciona o sinal de "+" entre as molduras
        adicionarSinalMais();

    }


    private void adicionarBotaoCraftar(JLabel moldura1, JLabel moldura2) {
        // Criação do botão
        JButton craftarButton = new JButton("Craftar");
        craftarButton.setBounds(500, 500, 100, 40); // Posicionado abaixo das molduras
        dirPanel.add(craftarButton);

        // Adiciona funcionalidade ao botão
        craftarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica se ambas as molduras possuem ícones atribuídos
                if (moldura1.getIcon() != null && moldura2.getIcon() != null) {
                    // Obtem os itens associados às molduras
                    Item item1 = (Item) moldura1.getClientProperty("item");
                    Item item2 = (Item) moldura2.getClientProperty("item");

                    // Verifica se os itens não são nulos
                    if (item1 != null && item2 != null) {
                        // Chama o método testeCraft da classe Main
                        System.out.println("E N");
                        Main.testeCraft(item1, item2);
                        atualizarIconesNoPainelEsquerdo();

                        // Limpa as molduras após o craft
                        removerIconeDaMoldura(moldura1);
                        removerIconeDaMoldura(moldura2);

                        // Atualiza a interface gráfica
                        dirPanel.revalidate();
                        dirPanel.repaint();
                    } else {
                        // Exibe uma mensagem de erro no console para debug
                        System.err.println("Erro: Uma ou ambas as molduras não possuem itens.");
                    }
                } else {
                    // Exibe uma mensagem caso as molduras estejam vazias
                    JOptionPane.showMessageDialog(
                            dirPanel,
                            "Ambas as molduras devem conter itens!",
                            "Erro",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });
    }



    private JLabel criarMoldura(int x, int y) {
        JLabel moldura = new JLabel();
        moldura.setBounds(x, y, 100, 100);
        moldura.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4)); // Borda preta
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

    private void colocarIconeNaMoldura(String iconPath, String nome, Item item) {
        for (JLabel moldura : molduras) {
            if (moldura.getIcon() == null) { // Se a moldura não tiver ícone
                // Adiciona o ícone na moldura
                moldura.setIcon(new ImageIcon(getClass().getResource(iconPath)));
                moldura.setHorizontalAlignment(SwingConstants.CENTER);
                moldura.setVerticalAlignment(SwingConstants.CENTER);

                // Cria o label para o nome e posiciona acima da moldura
                JLabel nomeLabel = new JLabel(nome);
                nomeLabel.setBounds(moldura.getX(), moldura.getY() - 20, moldura.getWidth() + 40, 20);
                nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
                nomeLabel.setFont(new Font("Arial", Font.BOLD, 12));
                nomeLabel.setForeground(Color.BLACK);

                // Add nome ao painel e atualiza layout
                dirPanel.add(nomeLabel);

                // Vincula o nome à moldura com o nome como propriedade da moldura
                moldura.putClientProperty("nomeLabel", nomeLabel);

                // Configura o item na propriedade da moldura
                moldura.putClientProperty("item", item);

                // Configura a funcionalidade de clique para remover icone e nome
                moldura.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removerIconeDaMoldura(moldura);
                    }
                });

                dirPanel.repaint();
                break;
            }
        }
    }

    private void removerIconeDaMoldura(JLabel moldura) {
        // Remove o ícone da moldura
        moldura.setIcon(null);

        // Remove a propriedade "item" associada à moldura.
        moldura.putClientProperty("item", null);

        // Remove o label do nome associado à moldura
        JLabel nomeLabel = (JLabel) moldura.getClientProperty("nomeLabel");
        if (nomeLabel != null) {
            dirPanel.remove(nomeLabel);
            moldura.putClientProperty("nomeLabel", null); // Limpa a associação do nome
        }

        // Atualiza a exibição do painel direito
        dirPanel.revalidate();
        dirPanel.repaint();
    }


    public void atualizarIconesNoPainelEsquerdo() {
        esqPanel.removeAll(); // Limpa o painel esquerdo

        // Define o layout principal do painel esquerdo como BorderLayout
        esqPanel.setLayout(new BorderLayout());

        // Painel superior com botões para trocar os cards
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(new Color(0, 74, 173)); // Cor de fundo do painel de botões

        // Painel que conterá os cards dos níveis
        CardLayout cardLayout = new CardLayout();
        JPanel cardsPanel = new JPanel(cardLayout);

        // Obtém os níveis do inventário
        Inventario inventario = Main.jogador.getInventario();
        List<Nivel> niveis = inventario.getNiveis();

        // Cria um card para cada nível
        for (Nivel nivel : niveis) {
            int nivelNumero = nivel.getNumeroNivel();

            // Painel customizado que inclui a imagem de fundo
            JPanel nivelPanel = new JPanel() {
                private final Image inventarioImage = new ImageIcon(getClass().getResource("/Images/inventario.png")).getImage();

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Desenha a imagem como plano de fundo do painel
                    if (inventarioImage != null) {
                        g.drawImage(inventarioImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            Color cor = new Color(0, 74, 173);
            nivelPanel.setBackground(cor);
            nivelPanel.setLayout(null); // Usamos layout absoluto para posicionar os ícones

            List<Item> itens = nivel.getItens();
            int xOffset = 100; // Posição horizontal inicial dos ícones
            int yOffset = 200; // Posição vertical inicial dos ícones
            int itemsPerRow = 4; // Quantidade de ícones por linha
            int itemIndex = 0;

            for (Item item : itens) {
                String iconPath;

                // Verifica se o item está desbloqueado ou bloqueado
                if (item.isDesbloqueado()) {
                    iconPath = "/Images/" + item.getNomeIcone();
                } else {
                    iconPath = "/Images/bloqueado.png";
                }

                // Cria o JLabel com o ícone do item
                JLabel itemIconLabel = new JLabel(new ImageIcon(getClass().getResource(iconPath)));
                itemIconLabel.setBounds(xOffset, yOffset, 64, 64); // Define a posição e o tamanho do ícone
                nivelPanel.add(itemIconLabel);

                // Adiciona uma funcionalidade de clique (caso esteja desbloqueado)
                if (item.isDesbloqueado()) {
                    itemIconLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            colocarIconeNaMoldura(iconPath, item.getNome(), item); // Adiciona o ícone à moldura ao clicar
                        }
                    });
                }

                // Organiza os ícones em linhas e colunas
                xOffset += 80; // Espaçamento horizontal
                itemIndex++;
                if (itemIndex == itemsPerRow) { // Move para a próxima linha
                    xOffset = 100;
                    yOffset += 80; // Espaçamento vertical
                    itemIndex = 0;
                }
            }

            // Adiciona o painel do nível como um card
            cardsPanel.add(nivelPanel, "Nivel " + nivelNumero);

            // Cria um botão para navegar até este card
            JButton nivelButton = new JButton("Nível " + nivelNumero);
            nivelButton.setFocusable(false); // Remove o foco visual do botão
            nivelButton.addActionListener(e -> cardLayout.show(cardsPanel, "Nivel " + nivelNumero)); // Troca para o card correspondente
            topPanel.add(nivelButton);
        }

        // Adiciona o painel de botões no topo e o painel de cards no centro
        esqPanel.add(topPanel, BorderLayout.NORTH);
        esqPanel.add(cardsPanel, BorderLayout.CENTER);

        // Revalida e repinta o painel esquerdo
        esqPanel.revalidate();
        esqPanel.repaint();
    }




    private void adicionarSinalMais() {
        // Cria um painel customizado para desenhar o "+"
        JPanel plusPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Torna o desenho suavizado
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Configura as dimensões
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int plusSize = Math.min(panelWidth, panelHeight) / 4; // Tamanho do "+" relativo ao painel

                // Coordenadas para desenhar as duas linhas do "+"
                int centerX = panelWidth / 2;
                int centerY = panelHeight / 2;

                // Desenha a borda preta para o "+"
                g2d.setColor(Color.BLACK);

                // Linha horizontal com borda
                g2d.fillRect(centerX - plusSize - 1, centerY - (plusSize / 4) - 1, plusSize * 2 + 5, plusSize / 2 + 5);

                // Linha vertical com borda
                g2d.fillRect(centerX - (plusSize / 4) - 1, centerY - plusSize - 1, plusSize / 2 + 5, plusSize * 2 + 5);

                // Desenha o "+" branco sobre a borda preta
                g2d.setColor(Color.WHITE);

                // Linha horizontal
                g2d.fillRect(centerX - plusSize, centerY - (plusSize / 4), plusSize * 2, plusSize / 2);

                // Linha vertical
                g2d.fillRect(centerX - (plusSize / 4), centerY - plusSize, plusSize / 2, plusSize * 2);
            }
        };

        // Define o tamanho e a posição do painel com o "+"
        plusPanel.setBounds(500, 350, 100, 100); // Ajuste para ficar entre moldura1 e moldura2
        plusPanel.setOpaque(false); // Transparente, para ver o fundo do painel direito
        dirPanel.add(plusPanel);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo ajustada ao tamanho do painel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}


