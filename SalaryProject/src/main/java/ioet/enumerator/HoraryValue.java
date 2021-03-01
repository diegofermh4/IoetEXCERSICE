package ioet.enumerator;

import java.math.BigDecimal;

public enum HoraryValue {
MO1("MO",0,1,9,0,new BigDecimal(25)),MO2("MO",9,1,18,0,new BigDecimal(15)),MO3("MO",18,1,0,0,new BigDecimal(20)),
TU1("TU",0,1,9,0,new BigDecimal(25)),TU2("TU",9,1,18,0,new BigDecimal(15)),TU3("MO",18,1,0,0,new BigDecimal(20)),
WE1("WE",0,1,9,0,new BigDecimal(25)),WE2("WE",9,1,18,0,new BigDecimal(15)),WE3("WE",18,1,0,0,new BigDecimal(20)),
TH1("TH",0,1,9,0,new BigDecimal(25)),TH2("TH",9,1,18,0,new BigDecimal(15)),TH3("TH",18,1,0,0,new BigDecimal(20)),
FR1("FR",0,1,9,0,new BigDecimal(25)),FR2("FR",9,1,18,0,new BigDecimal(15)),FR3("FR",18,1,0,0,new BigDecimal(20)),
SA1("SA",0,1,9,0,new BigDecimal(30)),SA2("SA",9,1,18,0,new BigDecimal(20)),SA3("SA",18,1,0,0,new BigDecimal(25)),
SU1("SU",0,1,9,0,new BigDecimal(30)),SU2("SU",9,1,18,0,new BigDecimal(20)),SU3("SU",18,1,0,0,new BigDecimal(25));
private HoraryValue(String dayWeek,int startHour, int startminute,int finishHour, int finishminute,BigDecimal value)
{
	this.dayOfWeek=dayWeek;
	this.starthour=startHour;
	this.startminute=startminute;
	this.finishhour=finishHour;
	this.finishminute=finishminute;
	this.value=value;
	}
private int starthour;
private int startminute;
private int finishhour;
private int finishminute;
private String dayOfWeek;
private BigDecimal value;
public int getStarthour() {
	return starthour;
}
public void setStarthour(int starthour) {
	this.starthour = starthour;
}
public int getStartminute() {
	return startminute;
}
public void setStartminute(int startminute) {
	this.startminute = startminute;
}
public int getFinishhour() {
	return finishhour;
}
public void setFinishhour(int finishhour) {
	this.finishhour = finishhour;
}
public int getFinishminute() {
	return finishminute;
}
public void setFinishminute(int finishminute) {
	this.finishminute = finishminute;
}
public String getDayOfWeek() {
	return dayOfWeek;
}
public void setDayOfWeek(String dayOfWeek) {
	this.dayOfWeek = dayOfWeek;
}
public BigDecimal getValue() {
	return value;
}
public void setValue(BigDecimal value) {
	this.value = value;
}
	
}
