package InterestCalculator;

import java.text.NumberFormat;


public class Interest{
	private int principal;
	private double rate;
	private int years;
	
	public Interest(int p, double r, int y) {
		principal = p;
		rate = r;
		years = y;
	}
	
	public double simple(int year) {
		return principal + (principal * (rate/100) * year);
	}
	
	public double compound(int year) {
		return principal * Math.pow((1 + rate/100), year);
	}
	
	public String computeSimple() {
		String result = "";
		result += "Principal: " + NumberFormat.getCurrencyInstance().format(principal) + ", Rate: " + rate + "\n";
		result += "Year, Simple Interest Amount" + "\n";
		for (int i = 1; i <= years; i++) {
			result += i + "-->" + NumberFormat.getCurrencyInstance().format(simple(i)) + "\n";
		}
		return result;
	}
	
	public String computeCompound() {
		String result = "";
		result += "Principal: " + NumberFormat.getCurrencyInstance().format(principal) + ", Rate: " + rate + "\n";
		result += "Year, Compound Interest Amount" + "\n";
		for (int i = 1; i <= years; i++) {
			result += i + "-->" + NumberFormat.getCurrencyInstance().format(compound(i)) + "\n";
		}
		return result;
	}
	
	public String computeBoth() {
		String result = "";
		result += "Principal: " + NumberFormat.getCurrencyInstance().format(principal) + ", Rate: " + rate + "\n";
		result += "Year, Simple Interest Amount, Compound Interest Amount" + "\n";
		for (int i = 1; i <= years; i++) {
			result += i + "-->" + NumberFormat.getCurrencyInstance().format(simple(i));
			result += "-->" + NumberFormat.getCurrencyInstance().format(compound(i)) + "\n";
		}
		return result;
	}
}
