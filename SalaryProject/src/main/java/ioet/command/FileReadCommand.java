package ioet.command;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ioet.infraestructure.EmployeInfraestructure;

public class FileReadCommand implements Command {
	private EmployeInfraestructure employes;

	public FileReadCommand(EmployeInfraestructure emp) {
		this.employes = emp;
	}
/**
 * Obtain data from file and transform file to list
 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String fileName = "META-INF/file.txt";

		Path path;
		try {
			path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());

			Stream<String> lines = Files.lines(path);
			// System.out.println("TAM "+lines.count());
			lines.forEach(p-> employes.getEmployes().add(p));
			//String data = lines.collect(Collectors.joining("\n"));
			lines.close();
			//System.out.println(data);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
