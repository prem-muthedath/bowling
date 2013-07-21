package bowling;

public class Bowling {
	private java.util.ArrayList <Frame> frames=new java.util.ArrayList<Frame>();

    void advance() {
        frames.add(new Frame());        
    }

    public void roll(int pins) {
        if(frames.size()==0) advance();
        new Play(this, frames.size()).roll(pins);
    }

    void count(Play play, int currentFrame, int pins)  {
        for(int frame=0; frame < currentFrame; frame++)
            frames.get(frame).count(play, pins);  
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