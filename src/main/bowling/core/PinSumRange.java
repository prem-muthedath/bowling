package bowling.core;

public class PinSumRange {
	private int minSum;

	public PinSumRange(int minSum) {
		this.minSum=minSum;
	}

	public int filter(int sum) {
		if(sum < minSum() || sum > maxSum()) 
			throw new RuntimeException(message(sum));
		return sum;		
	}

	private int minSum() {
		return minSum;
	}

	private int maxSum() {
		return Bowling.PINS*(1+(minSum/Bowling.PINS));
	}

	private String message(int sum) {
		return "EXPECTED PIN SUM: "+minSum()+" - "+maxSum()+". BUT FOUND: "+sum+".";
	}	
}
