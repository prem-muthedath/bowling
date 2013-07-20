package bowling;

public class GameState {
    private Bowling game;
    private int currentFrame;

    public GameState(Bowling game, int currentFrame) {
        this.game=game;
        this.currentFrame=currentFrame;
    }

    public void roll(int pins) {        
    	game.count(this, currentFrame, pins);
    }

    void advance() {
        if(notDone()) game.advance();
    }

    private boolean notDone() {
        return !Tenpin.TOTAL_FRAMES.equals(framesPlayed());
    }   

    private int framesPlayed() {
        return currentFrame;
    }    
}
