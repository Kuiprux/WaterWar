package com.jimdo.jjh4296.base.graphic.world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jimdo.jjh4296.base.reference.Registry;
import com.jimdo.jjh4296.object.SpriteObject;

public class WorldLoader {

	final File MAP_DIRECTORY = new File("saves");
	List<File> files = new ArrayList<File>();
	List<World> worldList = new ArrayList<World>();
	HashMap<String, String> variable = new HashMap<String, String>();

	public void load() {
		if (!MAP_DIRECTORY.exists()) {
			MAP_DIRECTORY.mkdir();
		}
		getWorldFiles(MAP_DIRECTORY);
		for (int i = 0; i < files.size(); i++) {
			worldList.add(readWorldFile(files.get(i)));
		}
	}

	public List<World> getWorldList() {
		return worldList;
	}

	private void getWorldFiles(File directory) {
		File[] listOfFiles = directory.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				getWorldFiles(file);
			} else {
				files.add(file);
			}
		}
	}

	private World readWorldFile(File file) {
		ArrayList<ArrayList<SpriteObject>> world = new ArrayList<ArrayList<SpriteObject>>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;

			while ((s = in.readLine()) != null) {
				ArrayList<SpriteObject> line = readALine(s);
				if (line != null) {
					world.add(line);
				}
			}
			in.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		return new World(world);
	}

	private ArrayList<SpriteObject> readALine(String str) {
		boolean isLine = true;
		ArrayList<SpriteObject> line = new ArrayList<SpriteObject>();
		if (str.contains("//")) {
			String[] strs = str.split("/+/+");
			if (strs[0].equals("")) {
				isLine = false;
			}
			str = strs[0];
		}
		String[] strs1 = str.split("\\s");
		String cleanStr = str.replaceAll("\\s", "");
		if (strs1[0].equals("use")) {
			if (strs1.length == 4 && strs1[2].equals("as")) {
				variable.put(strs1[3], strs1[1]);
				isLine = false;
			}
		}
		String[] objects = cleanStr.split(",");
		for (int x = 0; x < objects.length; x++) {
			if (!(objects[x].startsWith("Item.") || objects[x].startsWith("Block."))) {
				if (variable.containsKey(objects[x])) {
					objects[x] = variable.get(objects[x]);
				} else {
					line.add(null);
					continue;
				}
			}
			String[] strs = objects[x].split("\\.");
			int type = 0;
			switch (strs[0]) {
			case "Item":
				type += 1;
			case "Block":
				type += 1;
			}
			switch (type) {
			case 1:
				if (Registry.hasBlock(strs[1])) {
					line.add(Registry.getBlock(strs[1]));
				} else {
					line.add(null);
				}
				break;
			case 2:
				if (Registry.hasItem(strs[1])) {
					line.add(Registry.getItem(strs[1]));
				} else {
					line.add(null);
				}
				break;
			}
		}
		if (isLine) {
			return line;
		}
		return null;
	}
}
