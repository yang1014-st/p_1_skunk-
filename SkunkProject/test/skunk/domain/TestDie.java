package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{

	@Test
	public void test_die_not_equal_to_7()
	{
		Die die = new Die();
		die.roll();
		assertFalse(die.lastRoll==7);
	}
	
	@Test
	public void test_die_not_equal_to_0()
	{
		fail();
	}


}
