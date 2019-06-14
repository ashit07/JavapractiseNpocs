package main.java.multithreading.concurrentModification;

import java.util.HashSet;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DataHolder {
    private static final Map<String, ObjectClass> holder = new ConcurrentHashMap<String, ObjectClass>();

    private static final DataHolder INSTANCE = new DataHolder();

    private DataHolder() {

    }

    public static DataHolder getInstance() {
	return INSTANCE;
    }

    public void updateData(ObjectClass objToUpdate) {
	holder.put(objToUpdate.getDn(), objToUpdate);
    }

    public void removeData(ObjectClass objToRemove) {
	holder.remove(objToRemove.getDn());
    }

    public void removeInValidDns(Set<String> set) {
	getDnsList().retainAll(set);
    }

    public Set<ObjectClass> getAllObjects() {
	Set<ObjectClass> holderObjects = new HashSet<ObjectClass>();
	holderObjects.addAll(holder.values());
	return holderObjects;
    }

    public ObjectClass getData(String dn) {
	return holder.get(dn);
    }

    public Set<String> getDnsList() {
	return holder.keySet();
    }
}
