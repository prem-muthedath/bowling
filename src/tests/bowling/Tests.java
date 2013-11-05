package bowling;

import bowling.core.Bowling;
import bowling.core.FrameCount;
import bowling.core.PinCount;
import bowling.core.Score;

import bowling.configuration.Configuration;

public class Tests {	
    public static void main(String[] args) {
        Tests tests=new Tests();
        tests.printHeader();
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
        return PinCount.instance(pins);
    }

    private FrameCount frameCount(int id) {
        return new FrameCount(id);
    }

    private void printHeader() {
        System.out.printf("%-40s %-25s  %-25s \n", "   TEST  ", "EXPECTED SCORE", "ACTUAL SCORE");
    }

    private void printScore(String test, int expected, Score actual) {
        System.out.printf("%-45s %-10s %-15s %-10s \n", test, expected, "", actual);
    }

    private void testPerfectGame() {
        Bowling game=bowling();
        for (int i=0; i<12; i++)
            game.roll(pinCount(10));
        printScore("testPerfectGame", 300, game.score());
    }

    private void testHeartBreak()  {
        Bowling game=bowling();
        for (int i=0; i<11; i++)
            game.roll(pinCount(10));
        game.roll(pinCount(9));
        printScore("testHeartBreak", 299, game.score());        
    }  

    private void testTenthFrameSpare() {
        Bowling game=bowling();
        for (int i=0; i<9; i++)
            game.roll(pinCount(10));
        game.roll(pinCount(9));
        game.roll(pinCount(1));
        game.roll(pinCount(1));
        printScore("testTenthFrameSpare", 270, game.score());                
    }

    public void testTwoThrowsNoMark() {
        Bowling game=bowling();
        game.roll(pinCount(5));
        game.roll(pinCount(4));
        printScore("testTwoThrowsNoMark", 9, game.score());                        
    }

    public void testFourThrowsNoMark() {
        Bowling game=bowling();
        game.roll(pinCount(5));
        game.roll(pinCount(4));
        game.roll(pinCount(7));
        game.roll(pinCount(2));
        printScore("testFourThrowsNoMark - GAME", 18, game.score());                        
        printScore("testFourThrowsNoMark - FRAME: 1", 9, game.score(frameCount(1)));                        
        printScore("testFourThrowsNoMark - FRAME: 2", 18, game.score(frameCount(2)));                    
    }

    public void testSimpleSpare() {
        Bowling game=bowling();
        game.roll(pinCount(3));
        game.roll(pinCount(7));
        game.roll(pinCount(3));
        printScore("testSimpleSpare - FRAME: 1", 13, game.score(frameCount(1)));                                
    }

    public void testSimpleFrameAfterSpare() {
        Bowling game=bowling();		
        game.roll(pinCount(3));
        game.roll(pinCount(7));
        game.roll(pinCount(3));
        game.roll(pinCount(2));
        printScore("testSimpleFrameAfterSpare - FRAME: 1", 13, game.score(frameCount(1)));                        
        printScore("testSimpleFrameAfterSpare - FRAME: 2", 18, game.score(frameCount(2)));                    
        printScore("testSimpleFrameAfterSpare - GAME", 18, game.score());                                	
    }

    public void testSimpleStrike()  {
        Bowling game=bowling();		
        game.roll(pinCount(10));
        game.roll(pinCount(3));
        game.roll(pinCount(6));
        printScore("testSimpleStrike - FRAME: 1", 19, game.score(frameCount(1)));                        
        printScore("testSimpleStrike - GAME", 28, game.score());                                          
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
        printScore("testEndOfArray", 20, game.score());                                                  
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
        printScore("testSampleGame", 133, game.score());                                                          
    }

    public void testFrameLimit()  {
        Bowling game=bowling();     
        for (int i=0; i<20; i++) {
            game.roll(pinCount(1));
            game.roll(pinCount(1));
        }
        printScore("testFrameLimit", 20, game.score());                                                                  
    }   

    public void testUnfinishedSpare()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        game.roll(pinCount(7));        
        printScore("testUnfinishedSpare", 3, game.score());                                                                          
    }  

    public void testUnfinishedStrike()  {
        Bowling game=bowling();     
        game.roll(pinCount(10));
        game.roll(pinCount(5));
        printScore("testUnfinishedStrike - FRAME: 1", 0, game.score(frameCount(1)));                                                                          
        printScore("testUnfinishedStrike - GAME", 0, game.score());                                                                                  
    }  

    public void testUnfinishedOpen()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        printScore("testUnfinishedOpen", 3, game.score());                                                                                         
    }  

    public void testMoreThanAllowedFrames()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(5));
        game.roll(pinCount(3));
        printScore("testMoreThanAllowedFrames", 7, game.score());                                                                                                       
    } 

    public void testZeroStrikeBonus()  {
        Bowling game=bowling();     
        game.roll(pinCount(10));
        game.roll(pinCount(0));
        game.roll(pinCount(0));
        game.roll(pinCount(5));        
        printScore("testZeroStrikeBonus", 10, game.score());                                                                                                                      
    }  

    public void testZeroSpareBonus()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(8));
        game.roll(pinCount(0));
        game.roll(pinCount(10));   
        game.roll(pinCount(10));                     
        printScore("testZeroSpareBonus", 30, game.score());                                                                                                                                    
    }                                

    public void testValidFrame()  {
        Bowling game=bowling();     
        game.roll(pinCount(2));
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        game.roll(pinCount(6));        
        printScore("testValidFrame - GAME", 12, game.score());                                                                                                                                    
        printScore("testValidFrame - FRAME: 1", 3, game.score(frameCount(1)));                                                                                                                                            
    }  

    public void testInvalidFrame()  {
        Bowling game=bowling();     
        game.roll(pinCount(4));
        game.roll(pinCount(1));
        game.roll(pinCount(3));
        game.roll(pinCount(6));        
        printScore("testInvalidFrame - GAME", 14, game.score());                                                                                                                                    
        printScore("testInvalidFrame - FRAME: -3", 0, game.score(frameCount(-3)));                                                                                                                                            
    }  

    public void testNegativePins()  {
        Bowling game=bowling(); 
        try {     
            game.roll(pinCount(-2));
            game.roll(pinCount(5));
            game.roll(pinCount(3));
            System.out.println("7: "+game.score(frameCount(200)));  
        } catch(Exception e) {
            printScore("testNegativePins: EXCEPTION THROWN", 0, game.score());                                                                                                                                    
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
            printScore("testMoreThanTenPins: EXCEPTION THROWN", 16, game.score());                                                                                                                                                
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
            printScore("testInvalidRoll: EXCEPTION THROWN", 0, game.score());                                                                                                                                                            
        }      
    }  
}
