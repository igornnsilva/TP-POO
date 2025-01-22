package Interface;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame{
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);
    JPanel inicial = new Inicial();
    JPanel principal = new Principal();
    JPanel panelTrajetoria = new PanelTrajetoria();

    JButton btn1 = new JButton("Jogar");
    JButton btn2 = new JButton("Va para final");
    JButton btn3 = new JButton("Va para inicial");

    public Tela() {

        btn1.setBounds((getGraphicsConfiguration().getBounds().width/2) - 70, (getGraphicsConfiguration().getBounds().height/2) + 150, 120, 20);
        btn2.setBounds((getGraphicsConfiguration().getBounds().width/2) - 70, (getGraphicsConfiguration().getBounds().height/2) + 150, 120, 20);
        btn3.setBounds((getGraphicsConfiguration().getBounds().width/2) - 70, (getGraphicsConfiguration().getBounds().height/2) + 150, 120, 20);
        inicial.add(btn1);
        principal.add(btn2);
        panelTrajetoria.add(btn3);

        //Paineis de telas: inicial e principal
        mainPanel.add(inicial, "inicial");
        mainPanel.add(principal, "principal");
        mainPanel.add(panelTrajetoria, "trajetoria");

        this.setTitle("Tela"); //Nome para janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Faz a janela fechar ao clicar no x

        setLocationRelativeTo(null); //Inicializa janela centralizada
        this.setExtendedState(MAXIMIZED_BOTH); //Inicializa janela em tela cheia


        //Adiciona telas em um painel principal
        this.add(mainPanel);

        //Faz com que o botao leve para a outra tela
        btn1.addActionListener ((e) -> {
            cardLayout.show(mainPanel, "principal");
        });

        btn2.addActionListener ((e) -> {
            cardLayout.show(mainPanel, "trajetoria");
        });

        btn3.addActionListener ((e) -> {
            cardLayout.show(mainPanel, "inicial");
        });


        //Desativa o modo janela
        this.setResizable(false);

        //Torna o conteudo da janela visivel
        this.setVisible(true);



        //int t = getGraphicsConfiguration().getBounds().width;
        //System.out.println("Tamanho: " + t);


        /*
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabbedPane1.getSelectedIndex() < 2){
                    tabbedPane1.setSelectedIndex(tabbedPane1.getSelectedIndex()+1);
                }else{
                    tabbedPane1.setSelectedIndex(0);
                }
            }
        });*/
    }

    public static void main(String[] args) {
        Tela janela = new Tela();
    }
}
