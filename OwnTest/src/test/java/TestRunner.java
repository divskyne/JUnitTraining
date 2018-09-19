import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		SimPleTests sim = new SimPleTests();
		sim.init();
      Result result = JUnitCore.runClasses(AllTests.class);
      
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      if(!result.wasSuccessful())
	  {
    	  System.out.println("You have Failed Me, Senpai!");
	  }
      else
      {
    	  System.out.println("More Dialogues to keep conversation going...");
      }
   }
}  