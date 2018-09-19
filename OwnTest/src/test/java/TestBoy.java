import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author divine 2018-09-19
 */
public class TestBoy {
	String sample = this.getClass().getSimpleName();
	static int id = 0;
	
	@Before
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
	@After
	public void Third()
	{
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
