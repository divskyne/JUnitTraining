import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author divine 2018-09-19
 * AllTests.beforeClass
	MyTests1.beforeClass
	MyTests1.before
	MyTests1.test1
	MyTests1.after
	MyTests1.before
	MyTests1.test2
	MyTests1.after
	MyTests1.AfterClass
	MyTests2.beforeClass
	MyTests2.before
	MyTests2.test1
	MyTests2.after
	MyTests2.before
	MyTests2.test2
	MyTests2.after
	MyTests2.AfterClass
	AllTests.AfterClass
 */
@RunWith(Suite.class)
@SuiteClasses({ TestBoy.class, TestMan.class })
public class AllTests {
	static String sample = "AllTests";
	static int id = 0;
		@Test
		public void First()
		{
			id += 1;
			sample += id;
			System.out.println(sample);
		}
		@Test
		public void Second()
		{
			id += 1;
			sample += id;
			System.out.println(sample);
		}
		@AfterClass
		public static void Third()
		{
			System.out.println("bleh");
			id += 1;
			sample += id;
			System.out.println(sample);
		}
		@Test
		public void Fourth()
		{
			id += 1;
			sample += id;
			System.out.println(sample);
		}
}
