package engine.map;

import config.GameConfiguration;

public class Block {
	public int line;
	private int column;
	private boolean isWater = false;
	private boolean isTree = false;
	private boolean isRock = false;

	public Block(int line, int column) {
		this.line = line;
		this.column = column;
		double randomSpawnWater = Math.random();
		double randomSpawnTree = Math.random();
		double randomSpawnRock = Math.random();
		if (randomSpawnWater < GameConfiguration.CHANCE_FOR_WATER_BLOCK) { // placement des obstacles d'eaux
																			// aléatoirement
			isWater = true;

		} else if (randomSpawnTree < GameConfiguration.CHANCE_FOR_TREE_BLOCK) { // placement des obstacles d'arbres
																				// aléatoirement
			isTree = true;

		} else if (randomSpawnRock < GameConfiguration.CHANCE_FOR_ROCK_BLOCK) { // placement des obstacles des rochers
																				// aléatoirement
			isRock = true;
		} else {

		}
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public boolean isWater() {
		return isWater;
	}

	public boolean isTree() {
		return isTree;
	}

	public boolean isRock() {
		return isRock;
	}

	public boolean isOnTop() {
		// On prend les cases qui sont tout en haut, donc où la valeur de line est à 0
		return line == 0;
	}

	public boolean isOnBottom() {
		// On prend les cases qui sont tout en bas, donc où la valeur de line est au
		// maximum
		return line == GameConfiguration.LINE_COUNT - 1;
	}

	public boolean isOnLeftBorder() {
		// On prend les cases qui sont tout à gauche, donc où la valeur de column est à
		// 0
		return column == 0;
	}

	public boolean isOnRightBorder() {
		// On prend les cases qui sont tout à droite, donc où la valeur de column est au
		// maximum
		return column == GameConfiguration.COLUMN_COUNT - 1;
	}

	public boolean isWall() {
		// On regarde quelles cases sont sur la bordure de la map afin de savoir où nous
		// mettrons nos murs
		return isOnTop() || isOnBottom() || isOnLeftBorder() || isOnRightBorder();
	}

	public boolean isFloor() {
		// Les cases de sol sont les cases qui ne sont ni des murs ni des obstacles
		if (isRock() || isTree() || isWater() || isWall()) {
			return false;
		} else {
			return true;
		}
	}

}
