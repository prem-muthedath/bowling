package bowling.core;

class PinCountSum {
	private int augend;

	PinCountSum(int augend) {
		this.augend=augend;
	}

	int add(int addend) {
		int sum=augend+addend;
		if(sum >= minimum() && sum <= maximum()) return sum;
		throw new RuntimeException(message(sum));
	}

	private int minimum() {
		return augend;
	}

	private int maximum() {
		int maximum=Bowling.PINS*(1+(minimum()/Bowling.PINS));
		int ceiling=3*Bowling.PINS;
		return Math.min(maximum, ceiling);
	}

	private String message(int count) {
		return "EXPECTED PIN COUNT: "+minimum()+" - "+maximum()+". BUT FOUND: "+count+".";
	}	
}
