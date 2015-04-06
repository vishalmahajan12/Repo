package com.pack2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LargestTest extends TestCase{

	public LargestTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testLagest() {
		assertEquals(9, Largest.largest(new int[] { 7, 8, 9 }));
		assertEquals(9, Largest.largest(new int[] { 9, 8, 7 }));
		assertEquals(9, Largest.largest(new int[] { 7, 9, 8 }));
		assertEquals(9, Largest.largest(new int[] { 9, 7, 8, 9 }));

	}

	public void testLargestInNegative() {
		assertEquals(8, Largest.largest(new int[] { -7, 8, -2 }));
	}

	public void testLagestFromEmptyList() {
		try {
			Largest.largest(new int[] {});
			fail("Exception should be thrown");

		} catch (RuntimeException e) {
			// assertTrue(true);
		}

	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new LargestTest("testLagestFromEmptyList"));
		suite.addTest(new LargestTest("testLagest"));

		return suite;
	}

}
