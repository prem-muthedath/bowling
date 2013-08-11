package bowling.core;

public class PinSumRange {
	private int minimum;

	public PinSumRange(int minimum) {
		this.minimum=minimum;
	}

	public int filter(int sum) {
		if(sum < minimum() || sum > maximum()) 
			throw new RuntimeException(message(sum));
		return sum;		
	}

	private int minimum() {
		return minimum;
	}

	private int maximum() {
		int normalMaximum=Bowling.PINS*(1+(minimum/Bowling.PINS));
		int absoluteMaximum=3*Bowling.PINS;
		return Math.min(normalMaximum, absoluteMaximum);
	}

	private String message(int sum) {
		return "EXPECTED PIN SUM: "+minimum()+" - "+maximum()+". BUT FOUND: "+sum+".";
	}	
}
