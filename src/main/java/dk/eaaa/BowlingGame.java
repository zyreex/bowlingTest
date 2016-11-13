package dk.eaaa;
import java.util.ArrayList;

public class BowlingGame {

	private Frame[] frames;
	private int currentFrame;
	private boolean firstRollInFrame;

	public BowlingGame() {
		frames = new Frame[10];
		frames[0] = new Frame();
		firstRollInFrame = true;
	}

	public void roll(int pins) throws Exception {
		if (firstRollInFrame) {
			frames[currentFrame].rollFirst(pins);
			if (pins == 10) { // Strike
				newFrame();
			} else {
				firstRollInFrame = false;
			}
		} else {
			frames[currentFrame].rollSecond(pins);
			newFrame();
		}
	}

	private void newFrame() {
		if (currentFrame < 9) {
			frames[++currentFrame] = new Frame();
			firstRollInFrame = true;
		}
	}

	public int getScore() {
		int score = 0;
		
		for (int i = 0; i < frames.length; i++) {
			score += frames[i].getScore();
			if (frames[i].isSpare()) {
				score += frames[i+1].getFirstRoll();
			}
			if (frames[i].isStrike()) {
				score += frames[i+1].getScore();
			}
		}
		return score;
	}

}
