package main.java.multithreading.concurrentModification;

import java.util.Set;

public class JobWorker {
    private static final String TERMINATOR = ";;;";
    private static final String SEPARATOR = "--";

    public static void main(String args[]) {
	DataGenerator.getInstance().loadData();

	generateAndShowReport();
	for (int i = 0; i < 5; i++) {
	    Thread updatorThread = new Thread(new Thread1_Updation());

	    Thread reportGeneratorGetData = new Thread(new Thread2_Iteration());
	    Thread reportGeneratorGetValues = new Thread(
		    new Thread3_iteration_values());

	    updatorThread.start();
	    // reportGeneratorGetData.start();
	    reportGeneratorGetValues.start();
	    // try {
	    // Thread.sleep(0);
	    // } catch (InterruptedException e) {
	    // // TODO Auto-generated catch block
	    // e.printStackTrace();
	    // }
	}
    }

    private static void generateAndShowReport() {
	Set<ObjectClass> availableObjects = DataHolder.getInstance()
		.getAllObjects();
	final StringBuffer report = new StringBuffer();
	for (ObjectClass obj : availableObjects) {
	    report.append(obj.getDn()).append(SEPARATOR).append(obj.getId())
		    .append(SEPARATOR).append(obj.getStatus())
		    .append(TERMINATOR);
	}
	System.out.println("Report default: ");
	System.out.println(report);
    }
}
