package bowling.core;

public class PinCountFactory {
	public PinCount create(int pins) {
		return new PinCount().add(new PinCount(pins));
	}
}
