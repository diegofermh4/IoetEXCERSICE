package ioet.command;

public class Invoker {
	private Command readFile;

	public Invoker(Command command) {
		this.readFile = command;
	}
/**
 * Use command pattern from read all data
 */
	public void readData() {
		readFile.execute();
	}
}
