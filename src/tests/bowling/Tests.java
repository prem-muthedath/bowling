package bowling;

import bowling.core.Bowling;
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
        tests.testNegativePins();
        tests.testMoreThanTenPins();   
        tests.testInvalidRoll();     
	}

    private Bowling bowling() {
        return new Configuration().game();
    }

	private void testPerfectGame() {
		Bowling game=bowling();
		for (int i=0; i<12; i++)
      		game.roll(10);
    	System.out.println("300: "+game.score());
	}

	private void testHeartBreak()  {
		Bowling game=bowling();
    	for (int i=0; i<11; i++)
      		game.roll(10);
    	game.roll(9);
    	System.out.println("299: "+game.score());
  	}  

  	private void testTenthFrameSpare() {
		Bowling game=bowling();
	   	for (int i=0; i<9; i++)
      		game.roll(10);
    	game.roll(9);
    	game.roll(1);
    	game.roll(1);
    	System.out.println("270: "+game.score());
  	}

	public void testTwoThrowsNoMark() {
		Bowling game=bowling();
	    game.roll(5);
    	game.roll(4);
    	System.out.println("9: "+game.score());
  	}

	public void testFourThrowsNoMark() {
		Bowling game=bowling();
    	game.roll(5);
    	game.roll(4);
    	game.roll(7);
    	game.roll(2);
        System.out.println("18: "+game.score());
    	System.out.println("9: "+game.score(1));
    	System.out.println("18: "+game.score(2));
	}

	public void testSimpleSpare() {
		Bowling game=bowling();
    	game.roll(3);
    	game.roll(7);
    	game.roll(3);
    	System.out.println("13: "+game.score(1));
	}

	public void testSimpleFrameAfterSpare() {
		Bowling game=bowling();		
    	game.roll(3);
    	game.roll(7);
    	game.roll(3);
    	game.roll(2);
        System.out.println("13: "+game.score(1));
    	System.out.println("18: "+game.score(2));
    	System.out.println("18: "+game.score());	
	}

	public void testSimpleStrike()  {
		Bowling game=bowling();		
    	game.roll(10);
    	game.roll(3);
    	game.roll(6);
    	System.out.println("19: "+game.score(1));	
    	System.out.println("28: "+game.score());	
	}

	public void testEndOfArray()  {
		Bowling game=bowling();		
    	for (int i=0; i<9; i++) {
      		game.roll(0);
      		game.roll(0);
    	}
    	game.roll(2);
    	game.roll(8); // 10th frame spare
    	game.roll(10); // Strike in last position of array.
    	System.out.println("20: "+game.score());
	}

	public void testSampleGame()  {
		Bowling game=bowling();		
    	game.roll(1);
    	game.roll(4);
    	game.roll(4);
    	game.roll(5);
    	game.roll(6);
    	game.roll(4);
    	game.roll(5);
    	game.roll(5);
    	game.roll(10);
    	game.roll(0);
    	game.roll(1);
    	game.roll(7);
    	game.roll(3);
    	game.roll(6);
    	game.roll(4);
    	game.roll(10);
    	game.roll(2);
    	game.roll(8);
    	game.roll(6);
    	System.out.println("133: "+game.score());
	}

    public void testFrameLimit()  {
        Bowling game=bowling();     
        for (int i=0; i<20; i++) {
            game.roll(1);
            game.roll(1);
        }
        System.out.println("20: "+game.score());
    }   

    public void testUnfinishedSpare()  {
        Bowling game=bowling();     
        game.roll(2);
        game.roll(1);
        game.roll(3);
        game.roll(7);        
        System.out.println("3: "+game.score());
    }  

    public void testUnfinishedStrike()  {
        Bowling game=bowling();     
        game.roll(10);
        game.roll(5);
        System.out.println("0: "+game.score(1));       
        System.out.println("0: "+game.score());
    }  

    public void testUnfinishedOpen()  {
        Bowling game=bowling();     
        game.roll(2);
        game.roll(1);
        game.roll(3);
        System.out.println("3: "+game.score());        
    }  

    public void testMoreThanAllowedFrames()  {
        Bowling game=bowling();     
        game.roll(2);
        game.roll(5);
        game.roll(3);
        System.out.println("7: "+game.score(200));        
    } 

    public void testNegativePins()  {
        Bowling game=bowling(); 
        try {     
            game.roll(-2);
            game.roll(5);
            game.roll(3);
            System.out.println("7: "+game.score(200));  
        } catch(Exception e) {
            System.out.println("NEGATIVE PINS TEST: "+e.toString()+" 0: "+game.score());
        }      
    } 

    public void testMoreThanTenPins()  {
        Bowling game=bowling(); 
        try {     
            game.roll(2);
            game.roll(5);
            game.roll(3);
            game.roll(6);
            game.roll(11);
            System.out.println("7: "+game.score(200));  
        } catch(Exception e) {
            System.out.println("TOO MANY PINS TEST: "+e.toString()+" 16: "+game.score());
        }      
    }  

    public void testInvalidRoll()  {
        Bowling game=bowling(); 
        try {     
            game.roll(10);
            game.roll(5);
            game.roll(6);
            game.roll(7);
            game.roll(1);
            game.roll(10);            
            System.out.println("7: "+game.score(200));  
        } catch(Exception e) {
            System.out.println("INVALID ROLL TEST: "+e.toString()+" 0: "+game.score());
        }      
    }            
}
