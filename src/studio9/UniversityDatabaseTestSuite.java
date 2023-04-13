package studio9;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import studio9.tests.UniversityDatabaseTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ UniversityDatabaseTest.class })
public class UniversityDatabaseTestSuite {
}
