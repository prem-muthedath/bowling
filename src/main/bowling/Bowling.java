package bowling;

public class Bowling {
    private java.util.ArrayList <Frame> frames=new java.util.ArrayList<Frame>();

    public void roll(int pins) {
        if(frames.size()==0) advance();                
        count(pins, frames.size());
    }

    public void advance() {
        if(notDone()) frames.add(FrameFactory.create(this));        
    }

    private boolean notDone() {
        return !Tenpin.TOTAL_FRAMES.equals(frames.size());
    }   

    private void count(int pins, int currentFrame)  {
        for(int frame=0; frame < currentFrame; frame++)
            frames.get(frame).count(pins);  
    }

    public int score() {
        return score(frames.size());
    }

    public int score(int aFrame) {
        int score=0;
        for(int frame=0; frame < Math.min(aFrame, frames.size()); frame++)
            score+=frames.get(frame).score();
        return score;
    }
}