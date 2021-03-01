package ioet.command;

public class Invoker {
	private Command readFile;

	public Invoker(Command command) {
		this.readFile = command;
	}

	public void readData() {
		readFile.execute();
	}
}
