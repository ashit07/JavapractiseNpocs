package main.java.jsonparser;

public class Cells {
	String name;
	String dn;
	int type;
	CellsName cellName;

	public Cells(String name, String dn, int type) {
		// this.name = name;
		this.cellName = new CellsName(name);
		this.dn = dn;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
