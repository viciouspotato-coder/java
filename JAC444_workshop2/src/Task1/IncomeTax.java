/**********************************************
Workshop 2
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 02/06/2022
**********************************************/

package Task1;

public class IncomeTax {
	
	public final int SINGLE_FILER = 0;
    public final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public final int MARRIED_SEPARATELY = 2;
    public final int HEAD_OF_HOUSEHOLD = 3;
	
    private int filingStatus = 0;
	
	private int[][] intervals = {
		{8350, 33950, 82250, 171550, 372950},
		{16700, 67900, 137050, 208850, 372950},
		{8350, 33950, 68525, 104425, 186475},
		{11950, 45500, 117450, 190200, 372950}
	};
	
	private double[] rates = {0.1, 0.15, 0.25, 0.28, 0.33, 0.35};
	
	private double taxableIncome = 0;
	
	IncomeTax() {
	}
	
	IncomeTax(int status, int[][] intervals, double[] rates, double taxableIncome) {
		setFilingStatus(status);
		setIntervals(intervals);
		setRates(rates);
		setTaxableIncome(taxableIncome);
	}
	
	public int getFilingStatus() {
		return filingStatus;
	}
	
	public void setFilingStatus(int status) {
		this.filingStatus = status;
	}
	
	public int[][] getIntervals(){
		return intervals;
	}
	
	public void setIntervals(int[][] intervals) {
		this.intervals = intervals;
	}
	
	public double[] getRates() {
		return rates;
	}
	
	public void setRates(double[] rates) {
		this.rates = rates;
	}
	
	public double getTaxableIncome() {
		return taxableIncome;
	}
	
	public void setTaxableIncome(double taxableIncome) { 
		this.taxableIncome = taxableIncome;
	}
	
	public double getIncomeTax() {
		//sum tracker
		double totalTax = 0;
		//tracks the most recent used variable
		int previousInterval = 0;
		//loop through the intervals
		for (int i = 0; i < intervals[filingStatus].length; i++) {
			//checks if the next interval needs to be used
			if (taxableIncome > intervals[filingStatus][i]) {
				//uses the current rate for the current interval
				totalTax += (intervals[filingStatus][i] - previousInterval) * rates[i];
				//sets the previous interval to the current one
				previousInterval = intervals[filingStatus][i];
			} else {
				//uses the latest rate for the remaining income and breaks the loop
				totalTax += (taxableIncome - previousInterval) * rates[i];
				break;
			}
		}
		return totalTax;
	}
}
