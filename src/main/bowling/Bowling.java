package bowling;

public class Bowling {
	private java.util.ArrayList <Frame> frames=new java.util.ArrayList<Frame>();

    public Bowling() {
        advance();
    }

    void advance() {
        frames.add(new Frame());        
    }

    public void roll(int pins) {
        new GameState(this, frames.size()).roll(pins);
    }

    void count(GameState state, int currentFrame, int pins)  {
        for(int frame=0; frame < currentFrame; frame++)
            frames.get(frame).count(state, pins);          
    }

    public int score() {
        return score(frames.size());
    }

    public int score(int theFrame) {
        int score=0;
        for(int frame=0; frame < theFrame; frame++)
            score+=frames.get(frame).score();
        return score;
    }
}