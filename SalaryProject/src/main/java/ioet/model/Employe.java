package ioet.model;

import java.math.BigDecimal;
import java.util.List;

public class Employe {
	private String name;
	private BigDecimal salary;
	private List<SalaryDetail> details;
	private String data;

	public Employe(String name, BigDecimal salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<SalaryDetail> getDetails() {
		return details;
	}

	public void setDetails(List<SalaryDetail> details) {
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "El monto a pagar a " + name + " es:" + salary.doubleValue() + " USD";
	}
}
