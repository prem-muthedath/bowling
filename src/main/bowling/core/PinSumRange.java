package bowling.core;

public class PinSumRange {
	private int basePins;

	public PinSumRange(int basePins) {
		this.basePins=basePins;
	}

	public int filter(int sum) {
		if(sum < minSum() || sum > maxSum()) 
			throw new RuntimeException(message(sum));
		return sum;		
	}

	private int minSum() {
		return basePins;
	}

	private int maxSum() {
		return Bowling.PINS*(1+(basePins/Bowling.PINS));
	}

	private String message(int sum) {
		return "EXPECTED PIN SUM: "+minSum()+" - "+maxSum()+". BUT FOUND: "+sum+".";
	}	
}
