package main.java.multithreading.concurrentModification;

import java.util.Set;

public class Thread2_Iteration implements Runnable {
    private static final String TERMINATOR = ";;;";
    private static final String SEPARATOR = "--";
    private static final StringBuffer report = new StringBuffer();

    @Override
    public void run() {
	Set<String> availableDns = DataHolder.getInstance().getDnsList();
	for (String dn : availableDns) {
	    addToReport(DataHolder.getInstance().getData(dn));
	}
	showReport();
    }

    public void showReport() {
	System.out.println("Report updated:");
	System.out.println(report);
    }

    private void addToReport(ObjectClass obj) {
	System.out.println("Adding dn to report " + obj.getDn());
	report.append(obj.getDn()).append(SEPARATOR).append(obj.getId())
		.append(SEPARATOR).append(obj.getStatus()).append(TERMINATOR);

    }
}
