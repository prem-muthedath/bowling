package bowling;

import bowling.core.Bowling;
import bowling.core.FrameCount;
import bowling.core.PinCount;
import bowling.core.PinCountFactory;

import bowling.configuration.Configuration;

public class Tests {	
    public static void main(String[] args) {
        Tests tests=new Tests();
        tests.testPerfectGame();
        tests.testHeartBreak();
        tests.testTenthFrameSpare();
        tests.testTwoThrowsNoMark();
        tests.testFourThrowsNoMark();
        tests.testSimpleSpare();
        tests.testSimpleFrameAfterSpare();
        tests.testSimpleStrike();
        tests.testEndOfArray();
        tests.testSampleGame();
        tests.testFrameLimit();
        tests.testUnfinishedSpare();
        tests.testUnfinishedStrike();
        tests.testUnfinishedOpen();
        tests.testMoreThanAllowedFrames();
        tests.testZeroStrikeBonus();   
        tests.testZeroSpareBonus();  
        tests.testValidFrame();   
        tests.testInvalidFrame();   
        tests.testNegativePins();
        tests.testMoreThanTenPins();   
        tests.testInvalidRoll();  
    }

    private Bowling bowling() {
        return new Configuration().game();
    }

    private PinCount pinCount(int pins) {
        return new PinCountFactory().create(pins);
    }

    private FrameCount frameCount(int id) {
        return new FrameCount(id);
    }

    private void testPerfectGame() {
        Bowling game=bowling();
        for (int i=0; i<12; i++)
            game.roll(pinCount(10));
        System.out.println("300: "+game.score());
    }

    private void testHeartBreak()  {
        Bowling game=bowling();
        for (int i=0; i<11; i++)
            game.roll(pinCount(10));
        game.roll(pinCount(9));
        System.out.println("299: "+game.score());
    }  

    private void testTenthFrameSpare() {
        Bowling game=bowling();
        for (int i=0; i<9; i++)
            game.roll(pinCount(10));
        game.roll(pinCount(9));
        game.roll(pinCount(1));
        game.roll(pinCount(1));
        System.out.println("270: "+game.score());
    }

    public void testTwoThrowsNoMark() {
        Bowling game=bowling();
        game.roll(pinCount(5));
        game.roll(pinCount(4));
        System.out.println("9: "+game.score());
    }

    public void testFourThrowsNoMark() {
        Bowling game=bowling();
        game.roll(pinCount(5));
        game.roll(pinCount(4));
        game.roll(pinCount(7));
        game.roll(pinCount(2));
        System.out.println("18: "+game.score());
        System.out.println("9: "+game.score(frameCount(1)));
        System.out.println("18: "+game.score(frameCount(2)));
    }

    public void testSimpleSpare() {
        Bowling game=bowling();
        game.roll(pinCount(3));
        game.roll(pinCount(7));
        game.roll(pinCount(3));
        System.out.println("13: "+game.score(frameCount(1)));
    }

    public void testSimpleFrameAfterSpare() {
        Bowling game=bowling();		
        game.roll(pinCount(3));
        game.roll(pinCount(7));
        game.roll(pinCount(3));
        game.roll(pinCount(2));
        System.out.println("13: "+game.score(frameCount(1)));
        System.out.println("18: "+game.score(frameCount(2)));
        System.out.println("18: "+game.score());	
    }

    public void testSimpleStrike()  {
        Bowling game=bowling();		
        game.roll(pinCount(10));
        game.roll(pinCount(3));
        game.roll(pinCount(6));
        System.out.println("19: "+game.score(frameCount(1)));	
        System.out.println("28: "+game.score());	
    }

    public void testEndOfArray()  {
        Bowling game=bowling();		
        for (int i=0; i<9; i++) {
            game.roll(pinCount(0));
            game.roll(pinCount(0));
        }
        game.roll(pinCount(2));
        game.roll(pinCount(8)); // 10th frame spare
        game.roll(pinCount(10)); // Strike in last position of array.
        System.out.println("20: "+game.score());
    }

    public void testSampleGame()  {
        Bowling game=bowling();		
        game.roll(pinCount(1));
        game.roll(pinCount(4));
        game.roll(pinCount(4));
        game.roll(pinCount(5));
        game.roll(pinCount(6));
        game.roll(pinCount(4));
        game.roll(pinCount(5));
        game.roll(pinCount(5));
        game.roll(pinCount(10));
        game.roll(pinCount(0));
        game.roll(pinCount(1));
        game.roll(pinCount(7));
        game.roll(pinCount(3));
        game.roll(pinCount(6));
        game.roll(pinCount(4));
        game.roll(pinCount(10));
        game.roll(pinCount(2));
        game.roll(pinCount(8));
        game.roll(pinCount(6));
        System.out.println("133: "+game.score());
    }

    public void testFrameLimit()  {
        Bowling game=bowling();     
        for (int i=0; i<20; i++) {
            game.roll(pinCount(1));
            game.roll(pinCount(1));
        }
        System.out.println("20: "+game.score());
    }   

    public void testUnfinishedSpare()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        game.roll(pinCount(7));        
        System.out.println("3: "+game.score());
    }  

    public void testUnfinishedStrike()  {
        Bowling game=bowling();     
        game.roll(pinCount(10));
        game.roll(pinCount(5));
        System.out.println("0: "+game.score(frameCount(1)));       
        System.out.println("0: "+game.score());
    }  

    public void testUnfinishedOpen()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        System.out.println("3: "+game.score());        
    }  

    public void testMoreThanAllowedFrames()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(5));
        game.roll(pinCount(3));
        System.out.println("7: "+game.score(frameCount(200)));        
    } 

    public void testZeroStrikeBonus()  {
        Bowling game=bowling();     
        game.roll(pinCount(10));
        game.roll(pinCount(0));
        game.roll(pinCount(0));
        game.roll(pinCount(5));        
        System.out.println("10: "+game.score());        
    }  

    public void testZeroSpareBonus()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(8));
        game.roll(pinCount(0));
        game.roll(pinCount(10));   
        game.roll(pinCount(10));                     
        System.out.println("30: "+game.score());        
    }                                

    public void testValidFrame()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        game.roll(pinCount(6));        
        System.out.println("12: "+game.score());
        System.out.println("3: "+game.score(frameCount(1)));
    }  

    public void testInvalidFrame()  {
        Bowling game=bowling();     
        game.roll(pinCount(4));
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        game.roll(pinCount(6));        
        System.out.println("14: "+game.score());
        System.out.println("0: "+game.score(frameCount(-3)));
    }  

    public void testNegativePins()  {
        Bowling game=bowling(); 
        try {     
            game.roll(pinCount(-2));
            game.roll(pinCount(5));
            game.roll(pinCount(3));
            System.out.println("7: "+game.score(frameCount(200)));  
        } catch(Exception e) {
            System.out.println("NEGATIVE PINS TEST: "+e.toString()+" 0: "+game.score());
        }      
    } 

    public void testMoreThanTenPins()  {
        Bowling game=bowling(); 
        try {     
            game.roll(pinCount(2));
            game.roll(pinCount(5));
            game.roll(pinCount(3));
            game.roll(pinCount(6));
            game.roll(pinCount(11));
            System.out.println("7: "+game.score(frameCount(200)));  
        } catch(Exception e) {
            System.out.println("TOO MANY PINS TEST: "+e.toString()+" 16: "+game.score());
        }      
    }  

    public void testInvalidRoll()  {
        Bowling game=bowling(); 
        try {     
            game.roll(pinCount(10));
            game.roll(pinCount(5));
            game.roll(pinCount(6));
            game.roll(pinCount(7));
            game.roll(pinCount(1));
            game.roll(pinCount(10));            
            System.out.println("7: "+game.score(frameCount(200)));  
        } catch(Exception e) {
            System.out.println("INVALID ROLL TEST: "+e.toString()+" 0: "+game.score());
        }      
    }  
}
