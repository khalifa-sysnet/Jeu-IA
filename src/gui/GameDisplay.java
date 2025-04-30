package gui;

import java.awt.Graphics;


import javax.swing.JPanel;
import engine.map.Map;
import engine.mobile.Gardien;
import engine.mobile.Intru;

import engine.process.MobileElementManager;

public class GameDisplay extends JPanel {
	// Définition des attributs de la classe
	private static final long serialVersionUID = 1L;
	private Map map;
	private MobileElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	// Constructeur de la classe GameDisplay prenant en paramètre une map et un gestionnaire d'éléments mobiles
	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	// Méthode pour dessiner le composant
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Dessin de la map
		paintStrategy.paintMap(map, g);
		
		// Dessin des gardiens en fonction de leur état de poursuite ou non
		for (Gardien gardien : manager.getGardiens()) {
			if (gardien.etatPoursuite == true) {
				paintStrategy.paintGardienPoursuite(gardien, g);		
			}else {
				paintStrategy.paintGardien(gardien, g);				
			}
			paintStrategy.paintVision(gardien, g,map);
		}	

		// Dessin des intrus et de leur vision
		for (Intru intru : manager.getIntrus()) {
			paintStrategy.paintIntru(intru, g);
			paintStrategy.paintVision(intru, g,map);
		}		
	}

	// Méthode pour obtenir le gestionnaire d'éléments mobiles de la classe
	public MobileElementManager getManager() {
		return this.manager;
	}
}
