package bowling;

public interface Transition {
	public enum Event {
		FIRST_ROLL, 
		STRIKE, 
		SPARE, 
		OPEN, 
		STRIKE_BONUS_ONE, 
		STRIKE_BONUS_TWO, 
		SPARE_BONUS, 
		SCORED
	};

	public State next(State source, Event event);
}