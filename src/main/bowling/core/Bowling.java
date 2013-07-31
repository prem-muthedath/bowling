package bowling.core;

 public class Bowling {
    private Frame[] frames;
    public static final int FRAMES=10;
    public static final int PINS=10;

    public Bowling(Frame[] frames) {
        this.frames=java.util.Arrays.copyOfRange(frames, 0, Bowling.FRAMES);
    }

    public void roll(int pins)  {
        for(Frame each : frames)
            if(each.roll(new Count(pins))) return;
    }

    public int score() {
        return score(frames.length);
    }

    public int score(int aFrame) {
        int score=0;
        for(int frame=0; frame < Math.min(aFrame, frames.length); frame++)
            score+=frames[frame].score();
        return score;
    }
}
