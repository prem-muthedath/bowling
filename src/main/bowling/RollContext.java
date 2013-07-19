package bowling;

public class RollContext {
    private  Bowling game;
    private int frame;

    public RollContext(Bowling game, int frame) {
        this.game=game;
        this.frame=frame;
    }

    public void advance() {
        if(notLastFrame()) game.advance();
    }

    private boolean notLastFrame() {
        return !Tenpin.TOTAL_FRAMES.equals(frame);
    }    
}
