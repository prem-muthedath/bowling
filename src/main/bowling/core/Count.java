package bowling.core;

public class Count {
	private int pins;

	public Count(int pins) {
		set(pins);
	}

	private void set(int pins) {
		if(pins < 0 || pins > Bowling.PINS) throw new RuntimeException(message(pins));
		this.pins=pins;
	}

	private String message(int pins) {
		return "PIN COUNT SHOULD BE BETWEEN 0 AND "+Bowling.PINS+".  FOUND: "+pins+".";
	}

	public Pinfall addTo(Pinfall pinfall) {
		return pinfall.add(pinfall());
	}

	private Pinfall pinfall() {
		return new Pinfall(pins);
	}
}