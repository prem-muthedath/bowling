package bowling;

import bowling.Bowling;

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
	}

	private void testPerfectGame() {
		Bowling game=new Bowling();
		for (int i=0; i<12; i++)
      		game.roll(10);
    	System.out.println("300: "+game.score());
	}

	private void testHeartBreak()  {
		Bowling game=new Bowling();
    	for (int i=0; i<11; i++)
      		game.roll(10);
    	game.roll(9);
    	System.out.println("299: "+game.score());
  	}  

  	private void testTenthFrameSpare() {
		Bowling game=new Bowling();
	   	for (int i=0; i<9; i++)
      		game.roll(10);
    	game.roll(9);
    	game.roll(1);
    	game.roll(1);
    	System.out.println("270: "+game.score());
  	}

	public void testTwoThrowsNoMark() {
		Bowling game=new Bowling();
	    game.roll(5);
    	game.roll(4);
    	System.out.println("9: "+game.score());
  	}

	public void testFourThrowsNoMark() {
		Bowling game=new Bowling();
    	game.roll(5);
    	game.roll(4);
    	game.roll(7);
    	game.roll(2);
        System.out.println("18: "+game.score());
    	System.out.println("9: "+game.score(1));
    	System.out.println("18: "+game.score(2));
	}

	public void testSimpleSpare() {
		Bowling game=new Bowling();
    	game.roll(3);
    	game.roll(7);
    	game.roll(3);
    	System.out.println("13: "+game.score(1));
	}

	public void testSimpleFrameAfterSpare() {
		Bowling game=new Bowling();		
    	game.roll(3);
    	game.roll(7);
    	game.roll(3);
    	game.roll(2);
        System.out.println("13: "+game.score(1));
    	System.out.println("18: "+game.score(2));
    	System.out.println("18: "+game.score());	
	}

	public void testSimpleStrike()  {
		Bowling game=new Bowling();		
    	game.roll(10);
    	game.roll(3);
    	game.roll(6);
    	System.out.println("19: "+game.score(1));	
    	System.out.println("28: "+game.score());	
	}

	public void testEndOfArray()  {
		Bowling game=new Bowling();		
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
		Bowling game=new Bowling();		
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
        Bowling game=new Bowling();     
        for (int i=0; i<20; i++) {
            game.roll(1);
            game.roll(1);
        }
        System.out.println("20: "+game.score());
    }   

    public void testUnfinishedSpare()  {
        Bowling game=new Bowling();     
        game.roll(2);
        game.roll(1);
        game.roll(3);
        game.roll(7);        
        System.out.println("3: "+game.score());
    }  

    public void testUnfinishedStrike()  {
        Bowling game=new Bowling();     
        game.roll(10);
        game.roll(5);
        System.out.println("0: "+game.score(1));       
        System.out.println("0: "+game.score());
    }  

    public void testUnfinishedOpen()  {
        Bowling game=new Bowling();     
        game.roll(2);
        game.roll(1);
        game.roll(3);
        System.out.println("3: "+game.score());        
    }  

    public void testMoreThanAllowedFrames()  {
        Bowling game=new Bowling();     
        game.roll(2);
        game.roll(5);
        game.roll(3);
        System.out.println("7: "+game.score(200));        
    }  
}
