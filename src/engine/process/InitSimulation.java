package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Gardien;
import engine.mobile.Intru;

public class InitSimulation {

	private static Map map = new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);

	public static Map buildMap() {
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];
				// Pour chaque cases, on lui donnera sa propriété
				map.isWall(block);
				map.isWater(block);
				map.isTree(block);
				map.isRock(block);
				map.isFloor(block);
			}
		}
		return map;
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);

		initGardien(map, manager);
		initIntru(map, manager);

		return manager;
	}

	private static int getRandomNumber(int min, int max) {
		// fonction qui nous servira à utiliser des valeurs aléatoire
		return (int) (Math.random() * (max + 1 - min)) + min;
	}

	private static void initGardien(Map map, MobileElementManager manager) {
		// On va prendre le nombre de gardien souhaiter, et en ajouter un aléatoirement
		// sur la map, on l'ajoutera aussi dans la liste

		int gardienCount = GameConfiguration.GARDIEN_COUNT;
		while (gardienCount != 0) {

			Block block = map.getBlock(getRandomNumber(1, GameConfiguration.LINE_COUNT - 2),
					getRandomNumber(1, GameConfiguration.COLUMN_COUNT - 2));
			Gardien gardien = new Gardien(block, map);
			manager.add(gardien);
			gardienCount--;
		}
	}

	private static void initIntru(Map map, MobileElementManager manager) {

		// On va prendre le nombre d'intru souhaiter, et en ajouter un aléatoirement sur
		// la map, on l'ajoutera aussi dans la liste

		int intrusCount = GameConfiguration.INTRU_COUNT;
		while (intrusCount != 0) {

			Block block = map.getBlock(getRandomNumber(1, GameConfiguration.LINE_COUNT - 2),
					getRandomNumber(1, GameConfiguration.COLUMN_COUNT - 2));
			Intru intru = new Intru(block, map);
			manager.add(intru);
			intrusCount--;
		}
	}

}
