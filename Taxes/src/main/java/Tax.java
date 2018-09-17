
public class Tax {
	
	public int percentageTaxed(double salary)
	{
		int tax = 0;
		if(salary>=0&&salary<15000)
		{
			// already set as 0
		}
		else if(salary>=15000&&salary<20000)
		{
			tax = 10;
		}
		else if(salary>=20000&&salary<30000)
		{
			tax = 15;
		}
		else if(salary>=30000&&salary<45000)
		{
			tax = 20;
		}
		else if(salary>=45000)
		{
			tax = 25;
		}
		return tax;
	}
	
	public double exactTax(double salary)
	{	
		return percentageTaxed(salary)*salary/100;
	}
}
