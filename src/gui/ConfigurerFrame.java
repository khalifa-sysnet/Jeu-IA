package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import config.GameConfiguration;

public class ConfigurerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
    // Les champs de texte pour chaque paramètre de la simulation
    private JTextField colonneField = new JTextField(String.valueOf(GameConfiguration.COLUMN_COUNT), 5);
    private JTextField ligneField = new JTextField(String.valueOf(GameConfiguration.LINE_COUNT), 5);
    private JTextField nbIntrusField = new JTextField(String.valueOf(GameConfiguration.INTRU_COUNT), 5);
    private JTextField nbGardiensField = new JTextField(String.valueOf(GameConfiguration.GARDIEN_COUNT), 5);
    private JTextField tailleVisionField = new JTextField(String.valueOf(GameConfiguration.SIZE_VISION), 5);
    private JTextField tempsSpawnField = new JTextField(String.valueOf(GameConfiguration.TIMER_SPAWN_INTRU), 5);
    private JTextField tempsCommunicationField = new JTextField(String.valueOf(GameConfiguration.TIMER_COMMUNICATION_GARDIEN), 5);
    private JTextField chanceEauField = new JTextField(String.valueOf(GameConfiguration.CHANCE_FOR_WATER_BLOCK), 5);
    private JTextField chanceArbreField = new JTextField(String.valueOf(GameConfiguration.CHANCE_FOR_TREE_BLOCK), 5);
    private JTextField chanceRocherField = new JTextField(String.valueOf(GameConfiguration.CHANCE_FOR_ROCK_BLOCK), 5);

    //Variable max et min pour chaque parametre de la simulation
    private int colonneMin = 7, colonneMax = 25; //largeur max et min
    private int ligneMin = 7, ligneMax = 19; //hauteur max et min
    private int nbIntrusMin = 1, nbIntrusMax = 10;
    private int nbGardiensMin = 1, nbGardiensMax = 5;
    private int tailleVisionMin = 1, tailleVisionMax = 3;
    private int tempsSpawnMin = 10, tempsSpawnMax = 50;
    private int tempsCommunicationMin = 1, tempsCommunicationMax = 10;
    private float chanceEauMin = 0.0f, chanceEauMax = 0.3f;
    private float chanceArbreMin = 0.0f, chanceArbreMax = 0.3f;
    private float chanceRocherMin = 0.0f, chanceRocherMax = 0.3f;

    // Constructeur
	public ConfigurerFrame() {
	    super("Menu de configuration d'avant partie");
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    initComponents();
	}

    // Initialise les composants de l'interface
	public void initComponents() {
		Container contentPane = this.getContentPane();
		JPanel global = new JPanel();
		global.setLayout(new BoxLayout(global, BoxLayout.Y_AXIS));
		
        // Ajoute un titre à l'interface
		JPanel titlePane = new JPanel();
		titlePane.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 0)); // ajouter une marge supérieure
		JLabel title = new JLabel("Configurer la simulation Gardien");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 36));
		titlePane.add(title);
		global.add(titlePane);

	    
	    JPanel configPane = new JPanel(new GridLayout(10, 2, 5, 5));
	    configPane.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
	    
	    JLabel colonneLabel = new JLabel("Largeur de la carte");
	    JLabel ligneLabel = new JLabel("Hauteur de la carte");
	    JLabel nbIntrusLabel = new JLabel("Nombre d'intrus");
	    JLabel nbGardiensLabel = new JLabel("Nombre de gardiens");
	    JLabel tailleVisionLabel = new JLabel("Taille du champ de vision");
	    JLabel tempsSpawnLabel = new JLabel("Temps d'apparition d'un nouvel intru");
	    JLabel tempsCommunicationLabel = new JLabel("Temps avant communication entre les gardiens");
	    JLabel chanceEauLabel = new JLabel("Chance d'apparition de bloc d'eau (entre 0 et 0.3)");
	    JLabel chanceArbreLabel = new JLabel("Chance d'apparition de bloc d'arbre (entre 0 et 0.3)");
	    JLabel chanceRocherLabel = new JLabel("Chance d'apparition de bloc de rocher (entre 0 et 0.3)");

	   
	    configPane.add(colonneLabel);
	    configPane.add(colonneField);
	    configPane.add(ligneLabel);
	    configPane.add(ligneField); 
	    configPane.add(nbIntrusLabel);
	    configPane.add(nbIntrusField);
	    configPane.add(nbGardiensLabel);
	    configPane.add(nbGardiensField);
	    configPane.add(tailleVisionLabel);
	    configPane.add(tailleVisionField);
	    configPane.add(tempsSpawnLabel);
	    configPane.add(tempsSpawnField);
	    configPane.add(tempsCommunicationLabel);
	    configPane.add(tempsCommunicationField);
	    configPane.add(chanceEauLabel);
	    configPane.add(chanceEauField);
	    configPane.add(chanceArbreLabel);
	    configPane.add(chanceArbreField);
	    configPane.add(chanceRocherLabel);
	    configPane.add(chanceRocherField);
	    
	    global.add(configPane);
	    
	    JPanel buttonsPane = new JPanel();
	    buttonsPane.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
	    
	    JButton confirmConfig = new JButton("Confirmer choix");
	    confirmConfig.setPreferredSize(new Dimension(200, 50)); // définit une taille personnalisée pour le bouton
	    JButton launchSim = new JButton("Lancer la simulation");
	    launchSim.setPreferredSize(new Dimension(200, 50)); // définit une taille personnalisée pour le bouton

	    confirmConfig.addActionListener(new ConfirmConfig(this));
	    launchSim.addActionListener(new LaunchSim());
	    
	   

	    
	    titlePane.add(title);
	    
	    
	    configPane.add(colonneLabel);
	    configPane.add(colonneField);
	    configPane.add(ligneLabel);
	    configPane.add(ligneField);
	    configPane.add(nbIntrusLabel);
	    configPane.add(nbIntrusField);
	    configPane.add(nbGardiensLabel);
	    configPane.add(nbGardiensField);
	    configPane.add(tailleVisionLabel);
	    configPane.add(tailleVisionField);
	    configPane.add(tempsSpawnLabel);
	    configPane.add(tempsSpawnField);
	    configPane.add(tempsCommunicationLabel);
	    configPane.add(tempsCommunicationField);
	    configPane.add(chanceEauLabel);
	    configPane.add(chanceEauField);
	    configPane.add(chanceArbreLabel);
	    configPane.add(chanceArbreField);
	    configPane.add(chanceRocherLabel);
	    configPane.add(chanceRocherField);
	    
	    buttonsPane.add(confirmConfig);
	    buttonsPane.add(launchSim);
	    
	    global.add(titlePane);
	    global.add(configPane);
	    global.add(buttonsPane);
	    
	    contentPane.add(global);
	    
	    pack();
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	private class ConfirmConfig implements ActionListener {
		private ConfigurerFrame frame;
		
		public ConfirmConfig(ConfigurerFrame frame) {
			this.frame = frame;
		}
		
		//Permet l'affichage du message d'erreure si une mauvaise valeur est saisie
		@Override
		public void actionPerformed(ActionEvent e) {
			    int colonne = Integer.valueOf(colonneField.getText());
			    if (colonne < colonneMin || colonne > colonneMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur de la largeur doit être comprise entre " + colonneMin + " et " + colonneMax);
			        return;
			    }
			    int ligne = Integer.valueOf(ligneField.getText());
			    if (ligne < ligneMin || ligne > ligneMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur de la hauteur doit être comprise entre " + ligneMin + " et " + ligneMax);
			        return;
			    }
			    int nbIntrus = Integer.valueOf(nbIntrusField.getText());
			    if (nbIntrus < nbIntrusMin || nbIntrus > nbIntrusMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur du nombre d'intrus doit être comprise entre " + nbIntrusMin + " et " + nbIntrusMax);
			        return;
			    }
			    int nbGardiens = Integer.valueOf(nbGardiensField.getText());
			    if (nbGardiens < nbGardiensMin || nbGardiens > nbGardiensMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur du nombre de gardiens doit être comprise entre " + nbGardiensMin + " et " + nbGardiensMax);
			        return;
			    }
			    int tailleVision = Integer.valueOf(tailleVisionField.getText());
			    if (tailleVision < tailleVisionMin || tailleVision > tailleVisionMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur de la taille du champ de vision doit être comprise entre " + tailleVisionMin + " et " + tailleVisionMax);
			        return;
			    }
			    int tempsSpawn = Integer.valueOf(tempsSpawnField.getText());
			    if (tempsSpawn < tempsSpawnMin || tempsSpawn > tempsSpawnMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur du temps de spawn doit être comprise entre " + tempsSpawnMin + " et " + tempsSpawnMax);
			        return;
			    }
			    int tempsCommunication = Integer.valueOf(tempsCommunicationField.getText());
			    if (tempsSpawn < tempsCommunicationMin || tempsCommunication > tempsCommunicationMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur du temps de communication doit être comprise entre " + tempsCommunicationMin + " et " + tempsCommunicationMax);
			        return;
			    }
			    double chanceEau = Double.valueOf(chanceEauField.getText());
			    if (chanceEau < chanceEauMin || chanceEau > chanceEauMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur de la chance d'avoir un bloc d'eau doit être comprise entre " + chanceEauMin + " et " + chanceEauMax);
			        return;
			    }
			    double chanceArbre = Double.valueOf(chanceArbreField.getText());
			    if (chanceArbre < chanceArbreMin || chanceArbre > chanceArbreMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur de la chance d'avoir un bloc d'arbre doit être comprise entre " + chanceArbreMin + " et " + chanceArbreMax);
			        return;
			    }
			    double chanceRocher = Double.valueOf(chanceRocherField.getText());
			    if (chanceRocher < chanceRocherMin || chanceRocher > chanceRocherMax) {
			        JOptionPane.showMessageDialog(frame, "La valeur de la chance d'avoir un bloc de rocher doit être comprise entre " + chanceRocherMin + " et " + chanceRocherMax);
			        return;
			    }
			GameConfiguration.COLUMN_COUNT = Integer.valueOf(colonneField.getText());
			GameConfiguration.LINE_COUNT = Integer.valueOf(ligneField.getText());
			GameConfiguration.INTRU_COUNT = Integer.valueOf(nbIntrusField.getText());
			GameConfiguration.GARDIEN_COUNT = Integer.valueOf(nbGardiensField.getText());
			GameConfiguration.SIZE_VISION = Integer.valueOf(tailleVisionField.getText());
			GameConfiguration.TIMER_SPAWN_INTRU = Integer.valueOf(tempsSpawnField.getText());
			GameConfiguration.TIMER_COMMUNICATION_GARDIEN = Integer.valueOf(tempsCommunicationField.getText());
			GameConfiguration.CHANCE_FOR_WATER_BLOCK = Double.valueOf(chanceEauField.getText());
			GameConfiguration.CHANCE_FOR_TREE_BLOCK = Double.valueOf(chanceArbreField.getText());
			GameConfiguration.CHANCE_FOR_ROCK_BLOCK = Double.valueOf(chanceRocherField.getText());
		}
		
	}
	
	private class LaunchSim implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GUISec gui = new GUISec("Simulation");
            Thread t = new Thread(gui);
            t.start();
            setVisible(false);
        }
    }
}