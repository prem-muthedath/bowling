package bowling.core;

public class Pinfall {
	private int pins;

	public Pinfall(int pins) {
		this(pins, Bowling.PINS);
	}

	private Pinfall(int pins, int maxPins) {
		set(pins, maxPins);
	}

	private void set(int pins, int maxPins) {
		if(pins < 0 || pins > maxPins) 
			throw new RuntimeException("PINFALL SHOULD BE BETWEEN 0 AND "+maxPins+". FOUND: "+pins+".");
		this.pins=pins;
	}

	public Pinfall add(Pinfall pinfall) {
		int sum=this.pins+pinfall.pins;
		int maxPins=Bowling.PINS*(1+(pins/Bowling.PINS));
		return new Pinfall(sum, maxPins);
	}

	public boolean allPins() {
		return pins==Bowling.PINS;
	}

	public int score() {
		return pins;
	}	
}