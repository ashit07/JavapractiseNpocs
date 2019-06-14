package main.java.multithreading.concurrentModification;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Thread1_Updation implements Runnable {

    @Override
    public void run() {
	// Updates all values
	// updateAllValues();
	// Update status of 10 values + add 2 Objects + remove 2 objects

	// Adding and removing 2 elements
	updateSomeValues();
    }

    private void updateSomeValues() {
	Set<String> dnsList = DataHolder.getInstance().getDnsList();
	System.out.println("Size 1: " + dnsList.size());
	Set<String> dnsListCopy = new HashSet<String>();
	dnsListCopy.addAll(dnsList);
	Iterator<String> itr = dnsList.iterator();
	int count1 = 0;
	while (itr.hasNext()) {
	    String dn = (String) itr.next();
	    if (count1 % 4 == 0) {
		dnsListCopy.remove(dn);
		dnsListCopy.add(dn + "_updated");
	    }
	    count1++;
	}
	System.out.println("Removing invalid dns ");
	DataHolder.getInstance().removeInValidDns(dnsListCopy);
	// updating 10 elements
	Set<String> dnsList2 = DataHolder.getInstance().getDnsList();
	System.out.println("Size 2: " + dnsList2.size());
	Iterator<String> itr2 = dnsList2.iterator();
	int count = 0;
	while (itr2.hasNext()) {
	    String dn = itr2.next();
	    if (count % 3 == 0) {
		ObjectClass obj = DataHolder.getInstance().getData(dn);
		System.out.println("Updating dn " + obj.getDn());
		obj.setStatus(obj.getStatus() + "_updated");
	    }
	    count++;
	}

    }

    private void updateAllValues() {
	Map<String, ObjectClass> updatedData = DataGenerator.getInstance()
		.getUpdatedObjects();
	System.out.println("Removing invalid dns ");
	DataHolder.getInstance().removeInValidDns(updatedData.keySet());
	Set<ObjectClass> updatedObjects = new HashSet<ObjectClass>();
	updatedObjects.addAll(updatedData.values());
	for (ObjectClass object : updatedObjects) {
	    System.out.println("Updating dn " + object.getDn());
	    DataHolder.getInstance().updateData(object);

	}
    }
}
