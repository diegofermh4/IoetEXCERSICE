package ioet.model;

import java.math.BigDecimal;

public class SalaryDetail {
	private String day;
	private BigDecimal partialSalary;
	private Employe employe;

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public BigDecimal getPartialSalary() {
		return partialSalary;
	}

	public void setPartialSalary(BigDecimal partialSalary) {
		this.partialSalary = partialSalary;
	}

}
