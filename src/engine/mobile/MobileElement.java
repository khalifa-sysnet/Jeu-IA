package engine.mobile;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;

public abstract class MobileElement {

	private Block position;

	public MobileElement(Block position, Map map) {
		this.position = position;
	}

	public List<Block> getZone(Gardien gardien, Map map) {
		// On va parcourir chaque case de la map pour calcul la distance entre le
		// gardien et la case parcouru.
		// Si la distance est inferieure ou égale à la valeur souhaité, on l'ajoutera à
		// la liste des blocks de champ de vison
		Block position = gardien.getPosition();
		List<Block> zone = new ArrayList<>();

		for (int i = 0; i < GameConfiguration.LINE_COUNT; i++) {

			for (int j = 0; j < GameConfiguration.COLUMN_COUNT; j++) {

				if (i != position.getLine() || j != position.getColumn()) { // on exclu la case exact où ce trouve
																			// l'intru

					int rayon = Math.abs(position.getLine() - i) + Math.abs(position.getColumn() - j);
					// on créé le rayon
					if (rayon <= GameConfiguration.SIZE_VISION) {
						// si le block est dans le rayon, on l'ajoute à la liste de champ de vision
						Block newPos = map.getBlock(i, j);
						if (newPos.isFloor() || newPos.isWater()) {
							// on verifie que le block qu'on souhaite ajouté au champs de vision n'a pas de
							// restriction au niveau des obstacles (seulement le sol et l'eau peut laisser
							// passer la vision)
							zone.add(newPos);
						}

					}

				}
			}
		}

		return zone;
	}

	public List<Block> getZone(Intru intru, Map map) {
		// On va parcourir chaque case de la map pour calcul la distance entre l'intru
		// et la case parcouru.
		// Si la distance est inferieure ou égale à la valeur souhaité, on l'ajoutera à
		// la liste des blocks de champ de vison
		Block position = intru.getPosition();
		List<Block> zone = new ArrayList<>();

		for (int i = 0; i < GameConfiguration.LINE_COUNT; i++) {

			for (int j = 0; j < GameConfiguration.COLUMN_COUNT; j++) {

				if (i != position.getLine() || j != position.getColumn()) { // on exclu la case exact où ce trouve
																			// l'intru

					int rayon = Math.abs(position.getLine() - i) + Math.abs(position.getColumn() - j);
					// on créé le rayon
					if (rayon <= GameConfiguration.SIZE_VISION) {
						// si le block est dans le rayon, on l'ajoute à la liste de champ de vision
						Block newPos = map.getBlock(i, j);
						if (newPos.isFloor() || newPos.isWater()) {
							// on verifie que le block qu'on souhaite ajouté au champs de vision n'a pas de
							// restriction au niveau des obstacles (seulement le sol et l'eau peut laisser
							// passer la vision)
							zone.add(newPos);
						}

					}

				}
			}
		}

		return zone;
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}
}
