package engine.mobile;

import engine.map.Block;
import engine.map.Map;

public class Gardien extends MobileElement {

	public Gardien(Block position, Map map) {
		super(position, map);
	}

	public boolean etatPoursuite;
}