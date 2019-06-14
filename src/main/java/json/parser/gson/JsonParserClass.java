package main.java.jsonparser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonParserClass {
	public List<Cells> generateRandomCells(int numberOfCells) {
		int i = 0;
		List<Cells> listCells = new ArrayList<Cells>();

		while (i < numberOfCells) {
			listCells.add(new Cells("name " + i, "dn " + i, i++));
		}
		return listCells;
	}

	public String generateJsonString(List<Cells> listCells) {
		Gson obj = new Gson();
		return obj.toJson(listCells);
	}

	public List<Cells> generateObjectsFromJson(String json) {
		Gson obj = new GsonBuilder().create();
		Type collectionType = new TypeToken<List<Cells>>() {
		}.getType();
		List<Cells> enums = obj.fromJson(json, collectionType);
		/*
		 * Cells cellObjs = obj.fromJson(json, Cells.class); List<Cells>
		 * listCells = new ArrayList<Cells>(); listCells.add(cellObjs);
		 */return enums;
	}

	public static void main(String[] args) {
		JsonParserClass obj = new JsonParserClass();
		String jsonString = obj.generateJsonString(obj.generateRandomCells(4));
		System.out.println(jsonString);
		String jsonString2 = "[{\"name\":\"name 0\",\"dn\":\"dn 0\",\"type\":0},{\"name\":\"name 1\",\"dn\":\"dn 1\",\"type\":1},{\"name\":\"name 2\",\"dn\":\"dn 2\",\"type\":2}]";

		List<Cells> listcells = obj.generateObjectsFromJson(jsonString2);
		System.out.println(listcells.get(0).getDn());
	}
}
