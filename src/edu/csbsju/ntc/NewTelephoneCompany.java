package edu.csbsju.ntc;

public class NewTelephoneCompany {
	private int startTime;
	private int duration;
	private static final double FED_TAX = 0.04;
	private static final double COST = 40;
	private static final double HOURS_DISCOUNT = 0.5;
	private static final double DURATION_DISCOUNT = 0.15;

	public int getStartTime() {
		return this.startTime;
	}

	public void setStartTime(int hours) {
		this.startTime = hours;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double computeCharge() {
		double charge = 0;
		if (startTime < 0 || startTime >= 2400 || startTime % 100 > 59) {
			throw new UnsupportedOperationException("Invalid START TIME");
		} else if (duration <= 0) {
			throw new UnsupportedOperationException("Invalid LENGTH");
		} else if ((startTime < 800) || (startTime >= 1800)) {
			if (duration > 60) {
				charge = duration * COST * HOURS_DISCOUNT * (1 - DURATION_DISCOUNT);
			} else {
				charge = duration * COST * HOURS_DISCOUNT;
			}
		} else {
			if (duration > 60) {
				charge = duration * COST * (1 - DURATION_DISCOUNT);
			} else {
				charge = duration * COST;
			}
		}
		return (charge * (1 + FED_TAX));
	}

	public static void main(String args[]) {
		NewTelephoneCompany ntc = new NewTelephoneCompany();
		int i = 0;
		int j = 0;
		int[] startTimes = { 500, 759, 1959, 2359, 0, 400, 759, 1800, 1801, 2359, 800, 900, 1000, 800, 801, 1759 };
		int[] durations = { 100, 61, 61, 65, 60, 59, 1, 10, 10, 10, 65, 61, 40, 1, 59, 60 };

		try {
			
			System.out.println("Start Time" + "\t" + "Duration" + "\t" + "Expected Result");
			for (i = 0; i < startTimes.length; i++) {
				ntc.setStartTime(startTimes[i]);
				// System.out.println("ntc.setStartTime("+startTimes[i]+");");
				ntc.setDuration(durations[i]);
				System.out.println(startTimes[i] + "\t\t" + durations[i] + "\t\t" + ntc.computeCharge());
			}
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}
	}

}