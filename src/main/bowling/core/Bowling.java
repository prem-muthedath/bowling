package bowling.core;

 public class Bowling {
    public static final int FRAMES=10;
    public static final int PINS=10;

    private Frame[] frames;

    public Bowling(Frame[] frames) {
        this.frames=java.util.Arrays.copyOfRange(frames, 0, Bowling.FRAMES);
    }

    public void roll(int pins)  {
        for(Frame each : frames)
            if(each.roll(new PinCount(pins))) return;
    }

    public Score score() {
        return score(frames.length);
    }

    public Score score(int aFrame) {
        Score score=new Score();
        for(int frame=0; frame < Math.min(aFrame, frames.length); frame++)
            frames[frame].score(score);
        return score;
    }
}
