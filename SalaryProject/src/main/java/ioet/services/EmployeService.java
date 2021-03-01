package ioet.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ioet.enumerator.HoraryValue;
import ioet.model.Employe;
import ioet.model.SalaryDetail;

public class EmployeService {

	public Employe procesString(String data) {

		// String data = "RENE = MO10: 00-12: 00, TU10: 00-12: 00, TH01: 00-03: 00,
		// SA14: 00-18: 00, SU20: 00-21: 00";
		int nameindex = data.indexOf("=");
		var name = data.substring(0, nameindex - 1);
		var employe = new Employe(name, new BigDecimal(0));
		var assist = data.substring(nameindex + 1, data.length());
		var dataJob = assist.split(",");
		var salaryDetail = new ArrayList<SalaryDetail>();
		List<Double> valueDetail = new ArrayList<Double>();
		Stream<String> stream = Stream.of(dataJob);
		stream.forEach(p -> {
			//System.out.println(p.replace(" ", ""));
			SalaryDetail detail = processDetail(p.replace(" ", ""));
			salaryDetail.add(detail);
			valueDetail.add(detail.getPartialSalary().doubleValue());
		});
		employe.setDetails(salaryDetail);
		double total =  (double) valueDetail.stream().reduce(0d,(a,b)->a+b);
		employe.setSalary(new BigDecimal(total));
		return employe;

	}

	public SalaryDetail processDetail(String job) {
		// String job = "MO10:00-12:00";
		SalaryDetail detail = new SalaryDetail();
		String day = job.substring(0, 2);
		int startHour = Integer.parseInt(job.substring(2, 4));
		int startMinute = Integer.parseInt(job.substring(5, 7));
		//System.out.println(day + " " + startHour + " " + startMinute);
		int finishHour = Integer.parseInt(job.substring(8, 10));
		int finishMinute = Integer.parseInt(job.substring(11, 13));
		//System.out.println(day + " " + finishHour + " " + finishMinute);
		detail.setDay(day);
		BigDecimal numerHours= new BigDecimal(finishHour - startHour);
		detail.setPartialSalary(obtainValue(day, startHour, startMinute, finishHour, finishMinute).multiply(numerHours));
		return detail;

	}

	public BigDecimal obtainValue(String day, int startHour, int startMinute, int finishHour, int finishMinute) {
		BigDecimal value = BigDecimal.ONE;
		value = switch (day) {
		case "MO", "TU", "WE", "TH", "FR" -> {
			HoraryValue range1 = HoraryValue.MO1;
			HoraryValue range2 = HoraryValue.MO2;
			HoraryValue range3 = HoraryValue.MO3;
			BigDecimal resWeek = null;
			if (startHour <= range1.getFinishhour() && startHour >= range1.getStarthour()) {
				resWeek = range1.getValue();
			} else if (startHour <= range2.getFinishhour() && startHour >= range2.getStarthour()) {
				resWeek = range2.getValue();
			} else {
				resWeek = range3.getValue();
			}
			yield resWeek;
		}
		case "SA", "SU" -> {
			HoraryValue range1 = HoraryValue.SA1;
			HoraryValue range2 = HoraryValue.SA2;
			HoraryValue range3 = HoraryValue.SA3;
			BigDecimal res = null;
			if (startHour <= range1.getFinishhour() && startHour >= range1.getStarthour()) {
				res = range1.getValue();
			} else if (startHour <= range2.getFinishhour() && startHour >= range2.getStarthour()) {
				res = range2.getValue();
			} else {
				res = range3.getValue();
			}
			yield res;
		}
		default -> new BigDecimal(0);
		};

		return value;
	}
}
