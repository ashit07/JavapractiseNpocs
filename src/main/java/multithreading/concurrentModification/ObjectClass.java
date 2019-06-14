package main.java.multithreading.concurrentModification;

class ObjectClass {
    private String dn;
    private String id;
    private String name;
    private String status;

    String getDn() {
	return dn;
    }

    void setDn(String dn) {
	this.dn = dn;
    }

    String getId() {
	return id;
    }

    void setId(String id) {
	this.id = id;
    }

    String getName() {
	return name;
    }

    void setName(String name) {
	this.name = name;
    }

    String getStatus() {
	return status;
    }

    void setStatus(String status) {
	this.status = status;
    }

}
