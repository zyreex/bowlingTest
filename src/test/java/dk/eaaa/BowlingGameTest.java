package dk.eaaa;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame game;
	
	@Before
	public void initialize() {
		game = new BowlingGame();
	}
	
	@Test
	public void testGutterGame() throws Exception {
		rollMany(20, 0);
		assertEquals(0, game.getScore());
	}

	@Test
	public void testAllOnePinGame() throws Exception {
		rollMany(20, 1);
		assertEquals(20, game.getScore());
	}
	
	@Test
	public void testCanRollSpare() throws Exception {
		game.roll(5);
		game.roll(5);
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.getScore());
	}

	@Test
	public void testCanRollStrike() throws Exception {
		game.roll(10);
		game.roll(5);
		game.roll(3);
		rollMany(16, 0);
		assertEquals(26, game.getScore());
	}
	
	private void rollMany(int rolls, int pins) throws Exception {
		for (int i = 0; i < rolls; i++) {
			game.roll(pins);
		}
	}
}
