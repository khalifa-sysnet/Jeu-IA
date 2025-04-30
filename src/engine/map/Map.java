package engine.map;

public class Map {

	private Block[][] blocks;

	private int lineCount;
	private int columnCount;

	public Map(int lineCount, int columnCount) {
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];

		// On crée la map en créant les cases une par une pour chaque ligne par ligne
		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Block getBlock(int line, int column) {
		// On identifiera une case avec ses coordonnées
		return blocks[line][column];
	}

	public boolean isOnTop(Block block) {
		int line = block.getLine();
		return line == 0;
	}

	public boolean isOnBottom(Block block) {
		int line = block.getLine();
		return line == lineCount - 1;
	}

	public boolean isOnLeftBorder(Block block) {
		int column = block.getColumn();
		return column == 0;
	}

	public boolean isOnRightBorder(Block block) {
		int column = block.getColumn();
		return column == columnCount - 1;
	}

	public boolean isOnBorder(Block block) {
		return isOnTop(block) || isOnBottom(block) || isOnLeftBorder(block) || isOnRightBorder(block);
	}

	public boolean isWall(Block block) {
		if (isOnBorder(block)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isWater(Block block) {
		return block.isWater();
	}

	public boolean isTree(Block block) {
		return block.isTree();
	}

	public boolean isRock(Block block) {
		return block.isRock();
	}

	public boolean isFloor(Block block) {
		if (!isWall(block) && !block.isWater() && !block.isTree() && !block.isRock() && !isWall(block)) {
			return true;
		} else {
			return false;
		}
	}

	public double getBlockPercentage() {
		// On parcours la map et on va incrementer une variable à chaque fois que la
		// case n'est pas un sol (elle sera donc un obstacle)
		double nbBlocks = 0.0;
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (!isFloor(blocks[i][j])) {
					nbBlocks++;
				}
			}
		}
		return Math.round(nbBlocks / (lineCount * columnCount) * 10000.0) / 100.0;
	}
}
