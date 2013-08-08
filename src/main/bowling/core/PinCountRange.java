package bowling.core;

public class PinCountRange {
	private int minCount;
	private int maxCount;

	public PinCountRange(int minCount, int maxCount) {
		this.minCount=minCount;
		this.maxCount=maxCount;
	}

	public int filter(int count) {
		if(count < minCount || count > maxCount) 
			throw new RuntimeException(message(count));
		return count;		
	}

	private String message(int count) {
		return "EXPECTED PIN COUNT: "+minCount+" - "+maxCount+". FOUND: "+count+".";
	}	
}