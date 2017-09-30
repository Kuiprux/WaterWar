package com.jimdo.jjh4296.base.graphic.world;

import java.util.ArrayList;

import com.jimdo.jjh4296.object.SpriteObject;

public class World {

	private ArrayList<ArrayList<SpriteObject>> objects = new ArrayList<ArrayList<SpriteObject>>();
	
	public World(ArrayList<ArrayList<SpriteObject>> map) {
		objects = new ArrayList<ArrayList<SpriteObject>>(map);
	}
	
	public ArrayList<ArrayList<SpriteObject>> getWorld() {
		return objects;
	}
	
	public void replaceObject(int x, int y, SpriteObject object) {
		objects.get(x).set(y, object);
	}

}
