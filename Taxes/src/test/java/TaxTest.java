import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Parameterized.class)
@SuiteClasses(value = { Tax.class })
public class TaxTest {
	
	Tax taxTest = new Tax();
	
	@Parameters
	public static List<Double[]> data() {
		return Arrays.asList(new Double[][] {{0.0,0.0},{10.0,15000.0},{0.0,14999.0},{20.0, 44999.5}});
	}
	
	private double input;
	private double output;
	
	public TaxTest(double expected, double updated) {
		input = updated;
		output = expected;
	}
	@Test
	public void percentagetaxAll() {
		assertEquals(output, taxTest.percentageTaxed(input),0);
	}
}
