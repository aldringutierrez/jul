package com.aeg.jul.testin;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestDelete.class);
		suite.addTestSuite(TestInsert.class);
		//$JUnit-END$
		return suite;
	}

}
