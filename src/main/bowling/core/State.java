package bowling.core;

public interface State {
	public boolean roll(Frame frame, Pinfall count);
	public State next(Pinfall pinfall);
	public int score(Pinfall pinfall);
}