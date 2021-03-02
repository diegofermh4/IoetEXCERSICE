package IoetExecise.SalaryProject;

import java.util.stream.Stream;

import ioet.command.Command;
import ioet.command.FileReadCommand;
import ioet.command.Invoker;
import ioet.infraestructure.EmployeInfraestructure;
import ioet.services.EmployeService;

public class App {
    
    public static void main(String[] args) {
    	EmployeInfraestructure infrastructure = new EmployeInfraestructure();
    	EmployeService service = new EmployeService();
    	// get Data from file and transform to List objects
    	Command readData= new FileReadCommand(infrastructure);
    	Invoker invoke= new Invoker(readData);
    	invoke.readData();
    	Stream<String> data = infrastructure.getEmployes().stream();
    	// process to employes representes in lines (calculate salary)
    	data.forEach(p-> {
    		System.out.println(service.procesString(p));	
    	});
    	
    }
    
}
