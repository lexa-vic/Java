public class Calculate {
	public static void main(String[] arg){
		
		System.out.println("Calculate");
		
		if (arg.length == 2)
		{
			if (isDouble(arg[0]) != true )
			{
				System.out.println("first parametr err");
				return;
			}
			
			if (isDouble(arg[1]) != true)
			{
				System.out.println("second parametr err");
				return;
			}
	
			if ((isInteger(arg[0]) == true ) &&
				(isInteger(arg[1]) == true ))
			{
				int first  = Integer.valueOf(arg[0]);
				int second = Integer.valueOf(arg[1]);
				
				System.out.println("first + second = " + (first+second));
			}
			else
			{
				double first  = Double.valueOf(arg[0]);
				double second = Double.valueOf(arg[1]);
				
				System.out.println("first + second = " + (first+second));
			}
			
			
			

		}
		else
		{
			System.out.println("Expect only two parametrs");
		}
		
		
		
		
		
	

		//System.out.println("first + second = " + (first+second));
		
		
	}
	
	public static boolean isInteger( String input )
	{
	   try
	   {
		  Integer.parseInt( input );
		  return true;
	   }
	   catch( Exception e)
	   {
		  return false;
	   }
	}
	
	public static boolean isDouble( String input )
	{
	   try
	   {
		  Double.parseDouble( input );
		  return true;
	   }
	   catch( Exception e)
	   {
		  return false;
	   }
	}
}