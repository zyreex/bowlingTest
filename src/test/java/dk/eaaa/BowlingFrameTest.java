package dk.eaaa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BowlingFrameTest {

	private Frame frame;
	@Before
	public void initializeFrame() {
		frame = new Frame();
	}
	
	@Test
	public void testGetScore() throws Exception {
		assertEquals(0, frame.getScore());
		frame.rollFirst(5);
		assertEquals(5, frame.getScore());
		frame.rollSecond(1);
		assertEquals(6, frame.getScore());
	}
	
	@Test
	public void testIsStrike() throws Exception {
		frame.rollFirst(10);
		assertTrue(frame.isStrike());
	}
	
	@Test
	public void testIsNotStrike() throws Exception {
		assertFalse(frame.isStrike());
	}
	
	@Test
	public void testIsSpare() throws Exception {
		frame.rollFirst(5);
		frame.rollSecond(5);
		assertTrue(frame.isSpare());
	}
	
	@Test
	public void testIsNotSpareItIsStrike() throws Exception {
		frame.rollFirst(10);
		assertFalse(frame.isSpare());
		assertTrue(frame.isStrike());
	}
	
	@Test
	public void testIsNotSpare() throws Exception {
		frame.rollFirst(6);
		frame.rollSecond(3);
		assertFalse(frame.isSpare());
	}
	
	@Test(expected = Exception.class)
	public void testInvalidNumberOfPinsNegativeNumbr() throws Exception {
		frame.rollFirst(-1);
	}

	@Test(expected = Exception.class)
	public void testInvalidNumberOfPinsMoreThanTen() throws Exception {
		frame.rollFirst(11);
	}
	
	@Test(expected = Exception.class) 
	public void testNoSecondRollAllowedAfterStrike() throws Exception {
		frame.rollFirst(10);
		frame.rollSecond(10);
	}

}
