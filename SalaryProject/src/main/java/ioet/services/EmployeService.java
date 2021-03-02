package ioet.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ioet.enumerator.HoraryValue;
import ioet.model.Employe;
import ioet.model.SalaryDetail;

public class EmployeService {
	/**
	 * Process each line from file
	 * 
	 * @param data
	 * @return
	 */
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
			// System.out.println(p.replace(" ", ""));
			SalaryDetail detail = processDetail(p.replace(" ", ""));
			salaryDetail.add(detail);
			valueDetail.add(detail.getPartialSalary().doubleValue());
		});
		employe.setDetails(salaryDetail);
		double total = (double) valueDetail.stream().reduce(0d, (a, b) -> a + b);
		employe.setSalary(new BigDecimal(total));
		return employe;

	}

	/**
	 * Calculate each value for each day
	 * 
	 * @param job
	 * @return
	 */
	public SalaryDetail processDetail(String job) {
		// String job = "MO10:00-12:00";
		SalaryDetail detail = new SalaryDetail();
		String day = job.substring(0, 2);
		int startHour = Integer.parseInt(job.substring(2, 4));
		int startMinute = Integer.parseInt(job.substring(5, 7));
		int finishHour = Integer.parseInt(job.substring(8, 10));
		int finishMinute = Integer.parseInt(job.substring(11, 13));
		detail.setDay(day);
		detail.setPartialSalary(obtainValue(day, startHour, startMinute, finishHour, finishMinute));
		return detail;

	}

	/**
	 * Calculate value to pay from each day
	 * 
	 * @param day
	 * @param startHour
	 * @param startMinute
	 * @param finishHour
	 * @param finishMinute
	 * @return
	 */
	public BigDecimal obtainValue(String day, int startHour, int startMinute, int finishHour, int finishMinute) {
		BigDecimal value = BigDecimal.ONE;
		value = switch (day) {
		case "MO", "TU", "WE", "TH", "FR" -> {
			HoraryValue range1 = HoraryValue.MO1;
			HoraryValue range2 = HoraryValue.MO2;
			HoraryValue range3 = HoraryValue.MO3;
			BigDecimal resWeek = BigDecimal.ZERO;
			if (startHour <= range1.getFinishhour() && startHour >= range1.getStarthour()) {
				if (finishHour <= range1.getFinishhour()) {

					resWeek = range1.getValue().multiply(new BigDecimal(finishHour - startHour));
				} else {
					int numHours1 = range1.getFinishhour() - startHour;
					var valueAux1 = range1.getValue().multiply(new BigDecimal(numHours1));
					if (finishHour <= range2.getFinishhour()) {
						int numHours2 = finishHour - range2.getStarthour();
						valueAux1.add(range2.getValue().multiply(new BigDecimal(numHours2)));
					} else {
						int numHours2 = range2.getFinishhour() - range2.getStarthour();
						valueAux1.add(range2.getValue().multiply(new BigDecimal(numHours2)));
						int numHour3 = finishHour - range3.getStarthour();
						valueAux1.add(range3.getValue().multiply(new BigDecimal(numHour3)));
					}
					resWeek = valueAux1;
				}
			} else if (startHour <= range2.getFinishhour() && startHour >= range2.getStarthour()) {
				if (finishHour <= range2.getFinishhour()) {

					resWeek = range2.getValue().multiply(new BigDecimal(finishHour - startHour));
				} else {
					int numHours2 = range2.getFinishhour() - range2.getStarthour();
					resWeek.add(range2.getValue().multiply(new BigDecimal(numHours2)));
					int numHour3 = finishHour - range3.getStarthour();
					resWeek.add(range3.getValue().multiply(new BigDecimal(numHour3)));
				}
			} else {
				resWeek = range3.getValue().multiply(new BigDecimal(finishHour - startHour));
			}
			yield resWeek;
		}
		case "SA", "SU" -> {
			HoraryValue range1 = HoraryValue.SA1;
			HoraryValue range2 = HoraryValue.SA2;
			HoraryValue range3 = HoraryValue.SA3;
			BigDecimal res = BigDecimal.ZERO;
			if (startHour <= range1.getFinishhour() && startHour >= range1.getStarthour()) {
				if (finishHour <= range1.getFinishhour()) {

					res = range1.getValue().multiply(new BigDecimal(finishHour - startHour));
				} else {
					int numHours1 = range1.getFinishhour() - startHour;
					var valueAux1 = range1.getValue().multiply(new BigDecimal(numHours1));
					if (finishHour <= range2.getFinishhour()) {
						int numHours2 = finishHour - range2.getStarthour();
						valueAux1.add(range2.getValue().multiply(new BigDecimal(numHours2)));
					} else {
						int numHours2 = range2.getFinishhour() - range2.getStarthour();
						valueAux1.add(range2.getValue().multiply(new BigDecimal(numHours2)));
						int numHour3 = finishHour - range3.getStarthour();
						valueAux1.add(range3.getValue().multiply(new BigDecimal(numHour3)));
					}
					res = valueAux1;
				}
			} else if (startHour <= range2.getFinishhour() && startHour >= range2.getStarthour()) {
				if (finishHour <= range2.getFinishhour()) {

					res = range2.getValue().multiply(new BigDecimal(finishHour - startHour));
				} else {
					int numHours2 = range2.getFinishhour() - range2.getStarthour();
					res.add(range2.getValue().multiply(new BigDecimal(numHours2)));
					int numHour3 = finishHour - range3.getStarthour();
					res.add(range3.getValue().multiply(new BigDecimal(numHour3)));
				}
			} else {
				res = range3.getValue().multiply(new BigDecimal(finishHour - startHour));
			}
			yield res;
		}
		default -> new BigDecimal(0);
		};

		return value;
	}
}
