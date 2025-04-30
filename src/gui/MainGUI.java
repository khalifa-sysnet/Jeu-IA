package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

import config.GameConfiguration;
import engine.map.Map;
import engine.process.InitSimulation;
import engine.process.MobileElementManager;


public class MainGUI extends JFrame implements Runnable {

	// Attributs de la classe MainGUI
	private static final long serialVersionUID = 1L;
	private Map map;
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WIDTH, GameConfiguration.HEIGHT);
	private MobileElementManager manager;
	private GameDisplay dashboard;

	// Constructeur de la classe MainGUI
	public MainGUI(String title) {
		super(title);
		init();
	}

	// Initialisation des éléments graphiques de la fenêtre
	private void init() {

		// Récupération du contentPane de la fenêtre et configuration du layout
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

		// Création d'un champ de texte
		JTextField textField = new JTextField(20);

		// Initialisation de la carte et du gestionnaire d'éléments mobiles de la simulation
		map = InitSimulation.buildMap();
		manager = InitSimulation.buildInitMobile(map);

		// Création de l'affichage du jeu
		dashboard = new GameDisplay(map, manager);

		// Configuration de la taille préférée de l'affichage du jeu et ajout à la fenêtre
		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard);
		contentPane.add(textField);

		// Configuration de la fermeture de la fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Calcul de la taille de la fenêtre en fonction de son contenu et affichage
		pack();
		setVisible(true);

		// Configuration de la taille préférée de la fenêtre et possibilité de redimensionner la fenêtre
		setPreferredSize(preferredSize);
		setResizable(true);
	}

	// Implémentation de la méthode run() de l'interface Runnable
	@Override
	public void run() {
		// Boucle infinie pour la simulation du jeu
		while (true) {
			try {
				// Pause pour respecter la vitesse de jeu
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			// Passage au tour suivant de la simulation et mise à jour de l'affichage
			manager.nextRound();
			dashboard.repaint();
		}
	}


}
