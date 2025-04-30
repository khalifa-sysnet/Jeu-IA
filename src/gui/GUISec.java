package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import config.GameConfiguration;
import engine.map.Map;
import engine.process.InitSimulation;
import engine.process.MobileElementManager;
import gui.Scoreboard;



public class GUISec extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private Map map;
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WIDTH, GameConfiguration.HEIGHT);
	private MobileElementManager manager;
	private GameDisplay dashboard;
	

	public GUISec(String title) {
		super(title);
		init();
	}

	private void init() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // création des JPanel
	    JPanel leftPanel = new JPanel();
	    JPanel buttonPanel = new JPanel(new FlowLayout());
	    JPanel rightPanel = new JPanel();

	    // définition de la couleur de fond des JPanel
	    leftPanel.setBackground(Color.gray);
	    buttonPanel.setBackground(Color.LIGHT_GRAY);
	    rightPanel.setBackground(Color.gray);

	    // définition des dimensions et proportions des JPanel
	    leftPanel.setPreferredSize(new Dimension(1000, 500));
	    buttonPanel.setPreferredSize(new Dimension(600, 50));
	    rightPanel.setPreferredSize(new Dimension(450, 550));

	    // ajout de composants au JPanel de gauche
	    map = InitSimulation.buildMap();
	    manager = InitSimulation.buildInitMobile(map);
	    dashboard = new GameDisplay(map, manager);
	    dashboard.setPreferredSize(preferredSize);
	    leftPanel.add(dashboard);

	 // ajout de boutons au JPanel de boutons
	    // ajout du boutons ajouterIntru
	    JButton addButton = new JButton("Ajouter un intru");
	    addButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            manager.spawnIntru();
	        }
	    });
	    buttonPanel.add(addButton);
	    
	 // ajout du bouton Quitter
	    JButton quitButton = new JButton("Quitter");
	    quitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0); // quitte l'application
	        }
	    });
	    buttonPanel.add(quitButton);



	    // création et ajout de la ScoreboardPanel au JPanel de droite
	    Scoreboard scoreboard = new Scoreboard();
		scoreboard.setPercentageBlocks(map.getBlockPercentage());
		manager.setScoreBoard(scoreboard);
	    rightPanel.add(scoreboard);

	    // ajout des JPanel à la fenêtre
	    getContentPane().setLayout(new BorderLayout());
	    getContentPane().add(leftPanel, BorderLayout.WEST);
	    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	    getContentPane().add(rightPanel, BorderLayout.EAST);

	    // taille et affichage de la fenêtre
	    setSize(new Dimension(1000, 600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setVisible(true);
	}


	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			manager.nextRound();
			dashboard.repaint();
		}
	}

}
