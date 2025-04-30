package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.process.MobileElementManager;

public class Scoreboard extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel intrusCaughtLabel;
    private JLabel guardiensLabel;
    private JLabel intrusLabel;
    private JLabel blocksPercentageLabel;
    private JLabel timeLabel;
    private LocalDateTime startTime;
    private Timer timer;

    // Constructeur de la classe Scoreboard
    public Scoreboard() {
        // Définition des dimensions, bordure et couleur du panneau
        setPreferredSize(new Dimension(400, 800));
        setBorder(BorderFactory.createTitledBorder("Gardien's Scoreboard"));
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        // Lancement du timer
        startTimer();

        // Définition de la grille de mise en page avec la classe GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(30, 30, 30, 30); // ajouter 5 pixels d'espace autour de chaque cellule

        // Création et ajout de chaque label de la grille
        JLabel intrusCaughtTitle = new JLabel("Nombre d'intrus attrapés :");
        intrusCaughtTitle.setFont(new Font("Arial", Font.BOLD, 16));
        add(intrusCaughtTitle, gbc);

        gbc.gridx++;
        intrusCaughtLabel = new JLabel("0");
        intrusCaughtLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(intrusCaughtLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel guardiensTitle = new JLabel("Nombre de gardiens :");
        guardiensTitle.setFont(new Font("Arial", Font.BOLD, 16));
        add(guardiensTitle, gbc);

        gbc.gridx++;
        guardiensLabel = new JLabel("0");
        guardiensLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(guardiensLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel intrusTitle = new JLabel("Nombre d'intrus :");
        intrusTitle.setFont(new Font("Arial", Font.BOLD, 16));
        add(intrusTitle, gbc);

        gbc.gridx++;
        intrusLabel = new JLabel("0");
        intrusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(intrusLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel blocksPercentageTitle = new JLabel("Pourcentage d'obstacles :");
        blocksPercentageTitle.setFont(new Font("Arial", Font.BOLD, 16));
        add(blocksPercentageTitle, gbc);

        gbc.gridx++;
        //blocksPercentageLabel = new JLabel("0%");
        blocksPercentageLabel = new JLabel();
        //blocksPercentageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(blocksPercentageLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel timeTitle = new JLabel("Temps :");
        timeTitle.setFont(new Font("Arial", Font.BOLD, 16));
        add(timeTitle, gbc);

        gbc.gridx++;
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(timeLabel, gbc);

        // initialisation du temps de départ
        startTime = LocalDateTime.now();

        // mise à jour du temps au lancement
        updateTime();
    }

    private void startTimer() {
        // Initialiser la date de départ
        startTime = LocalDateTime.now();

        // Créer une tâche planifiée pour mettre à jour le temps toutes les secondes
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        }, 0, 1000);
    }

    public void updateintrusCaughtCount(int count) {
        intrusCaughtLabel.setText(String.valueOf(count));
    }

    public void updateintrusCount(int count) {
        intrusLabel.setText(String.valueOf(count));
    }

    public void updateguardiensCount(int count) {
        guardiensLabel.setText(String.valueOf(count));
    }

    public void setInitialCounts(int intrus, int guardiens, int totalintrus, double blockPercentage) {
        intrusCaughtLabel.setText("0");
        intrusLabel.setText(String.valueOf(intrus));
        guardiensLabel.setText(String.valueOf(guardiens));
        
    }

    public void incrementintrusCount() {
        int count = Integer.parseInt(intrusLabel.getText());
        intrusLabel.setText(String.valueOf(count + 1));
    }

    public void decrementintrusCount() {
        int count = Integer.parseInt(intrusLabel.getText());
        intrusLabel.setText(String.valueOf(count - 1));
    }

    public void incrementguardiensCount() {
        int count = Integer.parseInt(guardiensLabel.getText());
        guardiensLabel.setText(String.valueOf(count + 1));
    }

    public void decrementguardiensCount() {
        int count = Integer.parseInt(guardiensLabel.getText());
        guardiensLabel.setText(String.valueOf(count - 1));
    }

    public void incrementintrusCaughtCount() {
        int count = Integer.parseInt(intrusCaughtLabel.getText());
        intrusCaughtLabel.setText(String.valueOf(count + 1));
    }

    public void setintrusCount(int count) {
        intrusLabel.setText(String.valueOf(count));
    }

    public void setguardiensCount(int count) {
        guardiensLabel.setText(String.valueOf(count));
    }

    public void setPercentageBlocks(double percentage) {
        blocksPercentageLabel.setText(String.valueOf(percentage) + "%");
    }

    public void updateTime() {
        if (timeLabel != null) {
            // calcul du temps écoulé
            Duration duration = Duration.between(startTime, LocalDateTime.now());
            String formattedTime = duration.toDaysPart()  +
                    duration.toHoursPart() + ":" +
                    String.format("%02d", duration.toMinutesPart()) + ":" +
                    String.format("%02d", duration.toSecondsPart());
            timeLabel.setText(formattedTime);
        }
    }
}