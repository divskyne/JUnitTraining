import org.junit.Test;

/**
 * @author divine 2018-09-19
 */
public class TestMan {
	String sample = this.getClass().getSimpleName();
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
	@Test
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
