package bowling.core;

public class PinCountRange {
	private int minimum;

	public PinCountRange(int minimum) {
		this.minimum=minimum;
	}

	public int filter(int count) {
		if(count >= minimum() && count <= maximum()) return count;
		throw new RuntimeException(message(count));
	}

	private int minimum() {
		return minimum;
	}

	private int maximum() {
		int maximum=Bowling.PINS*(1+(minimum/Bowling.PINS));
		int ceiling=3*Bowling.PINS;
		return Math.min(maximum, ceiling);
	}

	private String message(int count) {
		return "EXPECTED PIN COUNT: "+minimum()+" - "+maximum()+". BUT FOUND: "+count+".";
	}	
}
