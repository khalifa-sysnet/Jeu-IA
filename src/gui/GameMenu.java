package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameMenu extends JFrame {
    
    private static final long serialVersionUID = 1L;

    public GameMenu() {
        super("Simulation GARDIEN"); // Initialise le titre de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permet de fermer la fenêtre
        initComponents(); // Initialise les composants graphiques
    }

    private void initComponents() {
    	BackgroundPanel panel = new BackgroundPanel(""); // Initialise le fond d'écran
    	panel.setBackground(Color.white); // Définit la couleur de fond de la fenêtre

        panel.setLayout(new BorderLayout()); // Définit le layout pour le panneau principal
        panel.setPreferredSize(new Dimension(900, 300)); // Définit les dimensions du panneau

        JLabel label = new JLabel("Menu principal de la simulation Gardien"); // Initialise un label
        label.setHorizontalAlignment(JLabel.CENTER); // Centre le texte du label
        label.setFont(new Font("Arial", Font.BOLD, 55)); // Définit la police et la taille de la police pour le label

        panel.add(label, BorderLayout.CENTER); // Ajoute le label au centre du panneau

        JButton jouerButton = new JButton("Jouer"); // Initialise un bouton jouer
        jouerButton.setPreferredSize(new Dimension(200, 50)); // Définit les dimensions du bouton jouer
        jouerButton.addActionListener(new ActionListener() { // Ajoute un ActionListener pour gérer les actions du bouton jouer
            @Override
            public void actionPerformed(ActionEvent e) {
                GUISec gui = new GUISec("Simulation"); // Initialise une nouvelle instance de la fenêtre principale de la simulation
                Thread t = new Thread(gui); // Initialise un nouveau thread pour la fenêtre principale
                t.start(); // Démarre le thread
                setVisible(false); // Rend la fenêtre de menu invisible
            }
        });
        
        JButton configurerButton = new JButton("Configurer"); // Initialise un bouton configurer
        configurerButton.setPreferredSize(new Dimension(200, 50)); // Définit les dimensions du bouton configurer
        configurerButton.addActionListener(new ActionListener() { // Ajoute un ActionListener pour gérer les actions du bouton configurer
        @Override
        public void actionPerformed(ActionEvent e) {
        ConfigurerFrame configFrame = new ConfigurerFrame(); // Initialise une nouvelle instance de la fenêtre de configuration
        configFrame.setVisible(true); // Rend la fenêtre de configuration visible
        dispose(); // Détruit la fenêtre de menu
        }
        });

        JButton quitterButton = new JButton("Quitter"); // Initialise un bouton quitter
        quitterButton.setPreferredSize(new Dimension(200, 50)); // Définit les dimensions du bouton quitter
        quitterButton.addActionListener(new ActionListener() { // Ajoute un ActionListener pour gérer les actions du bouton quitter
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Quitte l'application
            }
        });
        
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 	50));
        buttonPanel.add(jouerButton);
        buttonPanel.add(configurerButton);
        buttonPanel.add(quitterButton);


        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
    }
}
