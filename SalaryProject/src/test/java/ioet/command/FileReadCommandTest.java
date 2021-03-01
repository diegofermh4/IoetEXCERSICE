package ioet.command;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ioet.infraestructure.EmployeInfraestructure;



class FileReadCommandTest {

	@Test
	void test() {
		
		FileReadCommand command= new FileReadCommand(new EmployeInfraestructure());
		command.execute();
		assertTrue(true);
	}
	
	

}
