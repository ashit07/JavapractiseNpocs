package main.java.multithreading.concurrentModification;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class DataGenerator {
    private static final DataGenerator INSTANCE = new DataGenerator();
    private static final String GENERIC_STATUS = "Primary";
    private static final String GENERIC_ID = "1234";

    private DataGenerator() {
    }

    public static DataGenerator getInstance() {
	return INSTANCE;
    }

    public Map<String, ObjectClass> getUpdatedObjects() {
	return generateUpdatedData();
    }

    public void loadData() {
	Set<ObjectClass> objData = new HashSet<ObjectClass>();
	objData.addAll(generateData(40, "abc").values());
	for (ObjectClass obj : objData) {
	    DataHolder.getInstance().updateData(obj);
	}
    }

    private Map<String, ObjectClass> generateData(int numObjects,
	    String lastThree) {
	Set<String> dnsList = generateDns(numObjects, lastThree);
	Map<String, ObjectClass> objData = new HashMap<String, ObjectClass>();
	for (String dn : dnsList) {
	    objData.put(dn, getObject(dn));
	}
	return objData;
    }

    private Set<String> generateDns(int numberOfObjs, String lastThree) {
	Random r = new Random();
	String genericString = "ABCDEF" + lastThree;
	Set<String> dnList = new HashSet<String>();
	for (int i = 0; i < numberOfObjs; i++) {
	    String randomDn = scramble(r, genericString);
	    dnList.add(randomDn);
	}
	return dnList;
    }

    private ObjectClass getObject(String dn) {
	ObjectClass obj = new ObjectClass();
	obj.setDn(dn);
	obj.setId(getRandomId());
	obj.setName(dn);
	obj.setStatus(getRandomStatus());
	return obj;
    }

    private String getRandomId() {
	Random r = new Random();
	return scramble(r, GENERIC_ID);
    }

    private String getRandomStatus() {
	Random r = new Random();
	return scramble(r, GENERIC_STATUS);
    }

    private String scramble(Random random, String inputString) {
	// Convert your string into a simple char array:
	char a[] = inputString.toCharArray();

	// Scramble the letters using the standard Fisher-Yates shuffle,
	for (int i = 0; i < a.length - 1; i++) {
	    int j = random.nextInt(a.length - 1);
	    // Swap letters
	    char temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}

	return new String(a).intern();
    }

    public Map<String, ObjectClass> generateUpdatedData() {
	return generateData(40, "xyz");

    }

}
