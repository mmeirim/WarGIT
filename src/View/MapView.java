package View;
import javax.swing.*;

import Controller.APIController;
import Model.API;
import Model.PlayerColor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MapView extends JPanel {
    public static MapView MapView = null;

    JButton checkObjectivesButton = new JButton("Ver Carta de Objetivo");
    JButton checkCardsButton = new JButton("Ver Cartas de Território");
    JButton addArmy = new JButton("Adicionar Exército");
    JButton attackButton = new JButton("Atacar");
    JButton moveTroopsButton = new JButton("Realocar Tropas");
    JButton finishButton = new JButton("Finalizar Jogada");
    Image backgroundImage;
    Image territoriesImage;

    Graphics2D g;

    //Jogador da vez e cor do jogador
	String jogadorDaVez;
	Color corDoJogador;
	String descricaoObjetivo;
	JLabel jogadorDaVezLabel = new JLabel();

    APIController controller = APIController.getInstance();
    API game = API.getInstance();

    public MapView() {
        // setLayout(new BorderLayout());
        setLayout(null);
    
        try {
            backgroundImage = ImageIO.read(new File("resources/imagens/imagemFundo.png"));
            // g.drawImage(backgroundImage, 0, 0, 1200, 700, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel buttonPanel = new JPanel();
        // buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        setLayout(new FlowLayout(FlowLayout.RIGHT));

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(checkObjectivesButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(checkCardsButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(addArmy);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(attackButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(moveTroopsButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(finishButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // buttonPanel.add(cancelButton);

        add(buttonPanel);

        //Cria e adiciona o label do jogador da vez
        jogadorDaVezLabel.setFont(new Font("Arial", Font.BOLD, 50));
        jogadorDaVezLabel.setForeground(Color.WHITE);
        // jogadorDaVezLabel.setBounds(640,660,200,30);
        add(jogadorDaVezLabel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = (Graphics2D) g;

        this.g.drawImage(backgroundImage, 0, 0, 1440, 900, null);
        jogadorDaVezLabel.setText(jogadorDaVez);
    }

    //singleton
    public static MapView getMapView() {
        if (MapView == null) {
            MapView = new MapView();
        }
        return MapView;
    }

    // Atualiza view no início da rodada de posicionamento para determinar o primeiro jogador
	public void determinaPrimeiroJogador(String jogadorDaVez, PlayerColor corDoJogador){
		// Adicionar frase "Primeiro jogador: NOME - COR"
		// Adicionar descrição do objetivo em cima da carta
		// NÃO IMPRIMIR AINDA, SÓ ADD PARA IMPRIMIR AO CHAMAR O DRAWCOMPONENT DO MAINFRAME
		this.jogadorDaVez = jogadorDaVez;
		// this.corDoJogador = corDoJogador;
	}
}
