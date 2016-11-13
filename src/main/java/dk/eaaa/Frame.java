package dk.eaaa;

public class Frame {

	private int firstRoll;
	private int secondRoll;
	
	public void rollFirst(int pins) throws Exception {
		isLegalNumberOfPins(pins);
		firstRoll = pins;
	}
	
	public void rollSecond(int pins) throws Exception {
		isLegalNumberOfPins(pins);
		if (firstRoll == 10) {
			throw new Exception("First roll was a strike, frame is closed");
		}
		secondRoll = pins;
	}
	private void isLegalNumberOfPins(int pins) throws Exception {
		if (pins < 0 || pins > 10) {
			throw new Exception("Number of pins should be between 0 and 10");
		}
	}
	
	public int getScore() {
		return firstRoll + secondRoll;
	}
	
	public int getFirstRoll() {
		return firstRoll;
	}
	
	public boolean isStrike() {
		return firstRoll == 10;
	}
	
	public boolean isSpare() {
		return firstRoll != 10 && (firstRoll + secondRoll) == 10;
	}
}
