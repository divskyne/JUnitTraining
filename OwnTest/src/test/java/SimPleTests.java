import java.lang.reflect.Method;

/**
 * @author divine 2018-09-19
 */
public class SimPleTests {
	private String simple() {
		Method to_Return = null;
		try {
			to_Return = this.getClass().getMethod("doIt",null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} 
		return to_Return.getName();
	}
	public void doIt()
	{
		System.out.println("Do");
	}
	public void init() throws NoSuchMethodException, SecurityException
	{
		System.out.println("Meth Name: "+simple());
		doIt();
	}
}
