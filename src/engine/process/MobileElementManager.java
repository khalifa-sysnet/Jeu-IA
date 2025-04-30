package engine.process;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Gardien;
import engine.mobile.Intru;
import engine.mobile.MobileElement;
import gui.Scoreboard;

public class MobileElementManager {

	private Map map;

	private List<Gardien> gardiens = new ArrayList<Gardien>();
	private List<Intru> intrus = new ArrayList<Intru>();
	private Scoreboard scoreBoard;
	private int intruCaught;

	int timerSpawn = GameConfiguration.TIMER_SPAWN_INTRU;
	int timerCom = GameConfiguration.TIMER_COMMUNICATION_GARDIEN;

	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void moveUp(Gardien gardien) {
		// deplacement du gardien en direction du haut, la valeur line qu'on va
		// simplement décrémenter si il n'y a pas d'obstacle au dessus
		Block position = gardien.getPosition();
		if (position.getLine() > 1) {
			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
			if (map.isTree(newPosition) || map.isFloor(newPosition)) {
				// COLLISION: Si le bloc de destination est un sol (herbe) ou un arbre, il peux
				// y aller, sinon, il ne peut pourra pas
				gardien.setPosition(newPosition);
			}
		}
	}

	public void moveDown(Gardien gardien) {
		// deplacement du gardien en direction du bas, la valeur line qu'on va
		// simplement incrémenter si il n'y a pas d'obstacle en dessous
		Block position = gardien.getPosition();
		if (position.getLine() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			if (map.isTree(newPosition) || map.isFloor(newPosition)) {
				// COLLISION: Si le bloc de destination est un sol (herbe) ou un arbre, il peux
				// y aller, sinon, il ne peut pourra pas
				gardien.setPosition(newPosition);
			}
		}
	}

	public void moveLeft(Gardien gardien) {
		// deplacement du gardien en direction de la gauche, la valeur column qu'on va
		// simplement décrémenter si il n'y a pas d'obstacle à gauche
		Block position = gardien.getPosition();
		if (position.getColumn() > 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			if (map.isTree(newPosition) || map.isFloor(newPosition)) {
				// COLLISION: Si le bloc de destination est un sol (herbe) ou un arbre, il peux
				// y aller, sinon, il ne peut pourra pas
				gardien.setPosition(newPosition);
			}
		}
	}

	public void moveRight(Gardien gardien) {
		// deplacement du gardien en direction de la droite, la valeur column qu'on va
		// simplement incrémenter si il n'y a pas d'obstacle à droite
		Block position = gardien.getPosition();
		if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);

			if (map.isTree(newPosition) || map.isFloor(newPosition)) {
				// COLLISION: Si le bloc de destination est un sol (herbe) ou un arbre, il peux
				// y aller, sinon, il ne peut pourra pas
				gardien.setPosition(newPosition);
			}
		}
	}

	public void moveUp(Intru intru) {
		// deplacement de l'intru en direction du haut, la valeur line qu'on va
		// simplement décrémenter si il n'y a pas d'obstacle au dessus
		Block position = intru.getPosition();
		if (position.getLine() > 1) {
			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
			if (map.isTree(newPosition) || map.isFloor(newPosition)) {
				// COLLISION: Si le bloc de destination est un sol (herbe) ou un arbre, il peux
				// y aller, sinon, il ne peut pourra pas
				intru.setPosition(newPosition);
			}
		}
	}

	public void moveDown(Intru intru) {
		// deplacement de l'intru en direction de la droite, la valeur line qu'on va
		// simplement incrémenter si il n'y a pas d'obstacle en dessous
		Block position = intru.getPosition();
		if (position.getLine() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			if (map.isTree(newPosition) || map.isFloor(newPosition)) {
				// COLLISION: Si le bloc de destination est un sol (herbe) ou un arbre, il peux
				// y aller, sinon, il ne peut pourra pas
				intru.setPosition(newPosition);
			}
		}
	}

	public void moveLeft(Intru intru) {
		// deplacement de l'intru en direction de la gauche, la valeur column qu'on va
		// simplement décrémenter si il n'y a pas d'obstacle à gauche
		Block position = intru.getPosition();
		if (position.getColumn() > 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			if (map.isTree(newPosition) || map.isFloor(newPosition)) {
				// COLLISION: Si le bloc de destination est un sol (herbe) ou un arbre, il peux
				// y aller, sinon, il ne peut pourra pas
				intru.setPosition(newPosition);
			}
		}
	}

	public void moveRight(Intru intru) {
		// deplacement de l'intru en direction de la droite, la valeur column qu'on va
		// simplement incrémenter si il n'y a pas d'obstacle de la droite
		Block position = intru.getPosition();
		if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			if (map.isTree(newPosition) || map.isFloor(newPosition)) {
				// COLLISION: Si le bloc de destination est un sol (herbe) ou un arbre, il peux
				// y aller, sinon, il ne peut pourra pas
				intru.setPosition(newPosition);
			}
		}
	}

	public void RandomMoveGardiens(Gardien gardien) {

		int direction = getRandomNumber(1, 4);
		// choix de direction aléatoire chaque chiffres sera associé à une direction (4
		// chiffres pour 4 directions)

		if (direction == 1) {
			moveDown(gardien);
		}

		if (direction == 2) {
			moveUp(gardien);
		}

		if (direction == 3) {
			moveRight(gardien);
		}

		if (direction == 4) {
			moveLeft(gardien);
		}

	}

	public void RandomMoveIntrus(Intru intru) {

		int direction = getRandomNumber(1, 4);
		// choix de direction aléatoire chaque chiffres sera associé à une direction (4
		// chiffres pour 4 directions)

		if (direction == 1) {
			moveDown(intru);
		}

		if (direction == 2) {
			moveUp(intru);
		}

		if (direction == 3) {
			moveRight(intru);
		}

		if (direction == 4) {
			moveLeft(intru);
		}

	}

	public void poursuiteGardien() {

		// Si le gardien à un intru dans son champ de vision, il va se diriger vers lui,
		// sinon, il va verifier si un gardien communique avec lui, sinon, il va se
		// déplacer aléatoirement
		for (Gardien gardien : gardiens) {
			// On récupère la position actuelle du gardien
			Block posGardien = gardien.getPosition();

			// On récupère la liste de blocs dans le champ de vision du gardien
			List<Block> vision = gardien.getZone(gardien, map);
			// On cherche l'intrus le plus proche dans la liste de blocs du champ de vision
			Intru intruProche = null;
			double closestDistance = Double.POSITIVE_INFINITY;
			for (Intru intru : intrus) {
				Block posIntru = intru.getPosition();
				// Chemin le plus court
				if (vision.contains(posIntru)) {
					double distance = Math.sqrt(Math.pow(posIntru.getLine() - posGardien.getLine(), 2)
							+ Math.pow(posIntru.getColumn() - posGardien.getColumn(), 2));
					if (distance < closestDistance) {
						intruProche = intru;
						closestDistance = distance;
					}
				}

			}
			// Si un intrus est trouvé dans le champ de vision du gardien, on le suit
			if (intruProche != null) {
				gardien.etatPoursuite = true;
				Block posIntruProche = intruProche.getPosition();
				// On décide du déplacement que le gardien doit faire
				if (posGardien.getLine() > posIntruProche.getLine()) {
					moveUp(gardien);
				} else if (posGardien.getLine() < posIntruProche.getLine()) {
					moveDown(gardien);
				} else if (posGardien.getColumn() < posIntruProche.getColumn()) {
					moveRight(gardien);
				} else if (posGardien.getColumn() > posIntruProche.getColumn()) {
					moveLeft(gardien);
				}
				if (timerCom == 0) {
					communication(posIntruProche);
				} else {
					timerCom--;
				}

			} else if (timerCom != 0) {

				RandomMoveGardiens(gardien);
				gardien.etatPoursuite = false;

			}
		}

	}

	public void communication(Block posIntru) {
		// méthode qu'on appelera si la poursuite d'un des gardiens est trop longue afin
		// qu'il ce fasse aider
		for (Gardien gardien : gardiens) {
			// On récupère la position actuelle du gardien
			Block posGardien = gardien.getPosition();

			// On récupère la liste de blocs dans le champ de vision du gardien
			List<Block> vision = gardien.getZone(gardien, map);
			// Si les gardiens ne sont pas dans le champs de vision de l'intru, ils iront
			// vers lui (pour éviter de refaire bouger ce qui son deja dans le champ de
			// vision)
			if (!vision.contains(posIntru)) {
				gardien.etatPoursuite = true;
				if (posGardien.getLine() > posIntru.getLine()) {
					moveUp(gardien);
				} else if (posGardien.getLine() < posIntru.getLine()) {
					moveDown(gardien);
				} else if (posGardien.getColumn() < posIntru.getColumn()) {
					moveRight(gardien);
				} else if (posGardien.getColumn() > posIntru.getColumn()) {
					moveLeft(gardien);
				}

			}

		}

	}

	public void fuiteIntru() {
		// Si un gardien ce trouve dans le champ de vision d'un intru. L'intru va ce
		// déplacer dans la position contraire de celle du gardien

		for (Intru intru : intrus) {
			// On récupère la position actuelle de l'intru
			Block posIntru = intru.getPosition();

			// On récupère la liste de blocs dans le champ de vision de l'intru
			List<Block> vision = intru.getZone(intru, map);
			// On cherche le gardien le plus proche dans la liste de blocs du champ de
			// vision
			Gardien gardienProche = null;
			double closestDistance = Double.POSITIVE_INFINITY;
			for (Gardien gardien : gardiens) {
				Block posGardien = gardien.getPosition();
				if (vision.contains(posGardien)) {
					double distance = Math.sqrt(Math.pow(posGardien.getLine() - posIntru.getLine(), 2)
							+ Math.pow(posGardien.getColumn() - posIntru.getColumn(), 2));
					if (distance < closestDistance) {
						gardienProche = gardien;
						closestDistance = distance;
					}
				}
			}
			// Si un gardien est trouvé dans le champ de vision de l'intru, on le fuit
			if (gardienProche != null) {
				Block posGardienProche = gardienProche.getPosition();
				// On décide du déplacement que l'intru doit faire
				if (posIntru.getLine() < posGardienProche.getLine()) {
					moveUp(intru);
				} else if (posIntru.getLine() > posGardienProche.getLine()) {
					moveDown(intru);
				} else if (posIntru.getColumn() > posGardienProche.getColumn()) {
					moveRight(intru);
				} else if (posIntru.getColumn() < posGardienProche.getColumn()) {
					moveLeft(intru);
				}
			} else {
				RandomMoveIntrus(intru);
			}
		}
	}

	public void eliminerIntrus() {
		// On compare simplement la position des gardiens et verifions si c'est la même
		// que celle d'intru. Dans quel cas on va supprimer l'intru

		for (Gardien gardien : gardiens) {

			Block positionGardien = gardien.getPosition();
			// Parcourir la liste des intrus avec un itérateur
			for (Iterator<Intru> iterator = intrus.iterator(); iterator.hasNext();) {

				Intru intru = iterator.next();
				Block positionIntrus = intru.getPosition();
				// Si la position de l'intrus est égale à la position du gardien, on supprime
				// l'intru
				if (positionGardien.equals(positionIntrus)) {
					iterator.remove();
					intruCaught++;
					// on incrémente le compteur d'intru attrapé
					timerCom = GameConfiguration.TIMER_COMMUNICATION_GARDIEN;
				}
			}
		}
		scoreBoard.updateintrusCaughtCount(intruCaught);
		// on met à jour le compteur
		updateScoreBoard();
	}

	public void spawnRandomIntru() {

		if (timerSpawn != 0) {
			// On prend l'entier qui correspond au temps de spawn. S'il n'est pas égal à 0,
			// on decremente (-1)
			timerSpawn--;
		} else {

			int line = getRandomNumber(2, GameConfiguration.LINE_COUNT - 2);
			int column = getRandomNumber(2, GameConfiguration.COLUMN_COUNT - 2);
			// S'il est égal à 0, on va lui ajouter un intru à la liste avec une position
			// aléatoire.
			Block position = new Block(line, column);
			if (position.isFloor() || position.isTree()) {
				// on regarde si la position est adéquat, pour que l'intru n'apparait pas sur un
				// rocher, de l'eau ou un mur.
				Intru intru = new Intru(position, map);
				add(intru);
				timerSpawn = GameConfiguration.TIMER_SPAWN_INTRU;
			}
		}
		updateScoreBoard();
	}

	public void spawnIntru() {
		int line = getRandomNumber(2, GameConfiguration.LINE_COUNT - 2);
		int column = getRandomNumber(2, GameConfiguration.COLUMN_COUNT - 2);
		// S'il est égal à 0, on va lui ajouter un intru à la liste avec une position
		// aléatoire.
		Block position = new Block(line, column);
		if (position.isFloor() || position.isTree()) {
			// on regarde si la position est adéquat, pour que l'intru n'apparait pas sur un
			// rocher, de l'eau ou un mur.
			Intru intru = new Intru(position, map);
			add(intru);
		}
		updateScoreBoard();
	}

	public void nextRound() {
		poursuiteGardien();
		fuiteIntru();
		eliminerIntrus();
		spawnRandomIntru();
	}

	public List<Intru> getIntrus() {
		updateScoreBoard();
		return intrus;
	}

	public List<Gardien> getGardiens() {
		updateScoreBoard();
		return gardiens;
	}

	public void add(Intru intru) {
		intrus.add(intru);
		updateScoreBoard();
	}

	public void suppr(Intru intru) {
		intrus.remove(intru);
		updateScoreBoard();
	}

	public void add(Gardien gardien) {
		gardiens.add(gardien);
		updateScoreBoard();
	}

	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}

	public void setScoreBoard(Scoreboard scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

	public void updateScoreBoard() {
		if (scoreBoard != null) {
			this.scoreBoard.updateguardiensCount(gardiens.size());
			this.scoreBoard.updateintrusCount(intrus.size());
			this.scoreBoard.setPercentageBlocks(map.getBlockPercentage());
		}
	}
}