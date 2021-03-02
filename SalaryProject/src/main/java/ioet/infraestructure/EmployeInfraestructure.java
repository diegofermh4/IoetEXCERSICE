package ioet.infraestructure;

import java.util.ArrayList;
import java.util.List;

public class EmployeInfraestructure {
	private List<String> employes;
	/**
	 * Get Employes from files
	 */
	public EmployeInfraestructure()
	{
		employes= new ArrayList();
	}
	public List<String> getEmployes() {
		return employes;
	}
}
