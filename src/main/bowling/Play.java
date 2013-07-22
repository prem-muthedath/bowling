package bowling;

public class Play {
    private Bowling game;
    private int currentFrame;

    public Play(Bowling game, int currentFrame) {
        this.game=game;
        this.currentFrame=currentFrame;
    }

    public void advance() {
        if(notLast()) game.advance();
    }

    private boolean notLast() {
        return !Tenpin.TOTAL_FRAMES.equals(framesPlayed());
    }   

    private int framesPlayed() {
        return currentFrame+1;
    }    
}
