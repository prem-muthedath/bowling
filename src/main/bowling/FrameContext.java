package bowling;

public class FrameContext {
    private  Bowling game;
    private int index;

    public FrameContext(Bowling game, int index) {
        this.game=game;
        this.index=index;
    }

    public void advance() {
        if(notLast()) game.advance();
    }

    private boolean notLast() {
        return !Tenpin.TOTAL_FRAMES.equals(index+1);
    }    
}
