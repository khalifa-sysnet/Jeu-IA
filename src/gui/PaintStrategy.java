package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Gardien;
import engine.mobile.Intru;

public class PaintStrategy {
	
	// Méthode pour dessiner la carte
	public void paintMap(Map map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE; // Récupération de la taille des blocs à partir de la classe GameConfiguration
		Block[][] blocks = map.getBlocks(); // Récupération de la grille de blocs de la carte
		
		// Parcours de tous les blocs de la carte
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex]; // Récupération du bloc courant de la carte
				
				// Si le bloc est un mur
				if(map.isWall(block)) {
					Image image = SimulationUtility.loadImage("mur.png"); // Charge l'image du mur
					graphics.drawImage(image, block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize, null); // Dessine l'image du mur
				}
				// Si le bloc est de l'eau
				else if (map.isWater(block)) {
					Image image = SimulationUtility.loadImage("eau.png"); // Charge l'image de l'eau
					graphics.drawImage(image, block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize, null); // Dessine l'image de l'eau
				}
				// Si le bloc est un arbre
				else if (map.isTree(block)){
					Image image = SimulationUtility.loadImage("arbre.png"); // Charge l'image de l'arbre
					graphics.drawImage(image, block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize, null); // Dessine l'image de l'arbre
				}
				//Si le bloc est un rocher
				else if (map.isRock(block)) {
					Image image = SimulationUtility.loadImage("roche.png"); // Charge l'image de rocher
					graphics.drawImage(image, block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize, null); // Dessine l'image du rocher
				}
				// Sinon (le bloc est de l'herbe)
				else {
					Image image = SimulationUtility.loadImage("herbe.png"); // Charge l'image de l'herbe
					graphics.drawImage(image, block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize, null); // Dessine l'image de l'herbe
				}
			}
		}
	}

	// Méthode pour dessiner le gardien
	public void paintGardien(Gardien gardien, Graphics graphics) {
		Block position = gardien.getPosition(); // Récupération de la position du gardien
		int blockSize = GameConfiguration.BLOCK_SIZE; // Récupération de la taille des blocs à partir de la classe GameConfiguration
		
		int y = position.getLine(); // Récupération de la ligne de la position du gardien
		int x = position.getColumn(); // Récupération de la colonne de la position du gardien
		
		Image image = SimulationUtility.loadImage("gardien.png"); // Charge l'image du gardien
		graphics.drawImage(image, x * blockSize, y * blockSize, blockSize, blockSize, null);

		}
	
	public void paintGardienPoursuite(Gardien gardien, Graphics graphics) {
		Block position = gardien.getPosition(); // Récupération de la position du gardien
		int blockSize = GameConfiguration.BLOCK_SIZE; // Récupération de la taille des blocs à partir de la classe GameConfiguration
		
		int y = position.getLine(); // Récupération de la ligne de la position du gardien
		int x = position.getColumn(); // Récupération de la colonne de la position du gardien
		
		Image image = SimulationUtility.loadImage("gardien-poursuite.png"); // Charge l'image du gardien
		graphics.drawImage(image, x * blockSize, y * blockSize, blockSize, blockSize, null);

		}

	public void paintIntru(Intru intru, Graphics graphics) {
		Block position = intru.getPosition(); // Récupération de la position de l'intru
		int blockSize = GameConfiguration.BLOCK_SIZE; // Récupération de la taille des blocs à partir de la classe GameConfiguration

		int y = position.getLine(); // Récupération de la ligne de la position de l'intru
		int x = position.getColumn();// Récupération de la colonne de la position de l'intru

		Image image = SimulationUtility.loadImage("intru.png"); // charge l'image de l'intru
		graphics.drawImage(image, x * blockSize, y * blockSize, blockSize, blockSize, null); // dessine l'image du gardien
	}
	
	public void paintVision(Gardien gardien, Graphics graphics,Map map) {
	    List<Block> zone = gardien.getZone(gardien,map);

	    Graphics2D g2d = (Graphics2D) graphics;
	    AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
	    g2d.setComposite(alpha);
	    //AlphaComposite permet de modifier la transparence d'un objet graphique lorsqu'il est dessiné en le combinant avec le contenu déjà présent à cet endroit.

	    for (Block block : zone) {
	        graphics.setColor(Color.white); // bleu transparent
	        graphics.fillRect(block.getColumn() * GameConfiguration.BLOCK_SIZE, block.getLine() * GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE);
	    }
	}
	
	public void paintVision(Intru intru, Graphics graphics, Map map) {
	    List<Block> zone = intru.getZone(intru,map);

	    Graphics2D g2d = (Graphics2D) graphics;
	    AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
	    
	    g2d.setComposite(alpha);
	  //AlphaComposite permet de modifier la transparence d'un objet graphique lorsqu'il est dessiné en le combinant avec le contenu déjà présent à cet endroit.

	    for (Block block : zone) {
	        graphics.setColor(Color.yellow); // rouge transparent
	        graphics.fillRect(block.getColumn() * GameConfiguration.BLOCK_SIZE, block.getLine() * GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE);
	    }
	}


	
}