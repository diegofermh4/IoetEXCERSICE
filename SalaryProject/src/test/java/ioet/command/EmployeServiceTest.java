package ioet.command;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import ioet.model.Employe;
import ioet.model.SalaryDetail;
import ioet.services.EmployeService;

public class EmployeServiceTest {
	@Test
	void processTest() {
		String data ="RENE = MO10: 00-12: 00, TU10: 00-12: 00, TH01: 00-03: 00, SA14: 00-18: 00, SU20: 00-21: 00";
		EmployeService service= new EmployeService();
		Employe emp= service.procesString(data);
		assertNotNull(emp);
	}
	@Test
	void processDetailTest()
	{
		String data ="MO10:00-12:00";
		EmployeService service= new EmployeService();
		SalaryDetail emp= service.processDetail(data);
		assertNotNull(emp);
	}
	
	@Test
	void getValueTest()
	{
		
		EmployeService service= new EmployeService();
		BigDecimal value= service.obtainValue("MO", 10, 0, 12, 0);
		System.out.println(value);
		assertNotNull(value);
	}
}
