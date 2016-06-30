public class FirstCalc {
	
	public static void main(String[] arg){
		
		System.out.println("Calculate");
		
		if (arg.length == 2)
		{
			double result;
			double param_1 = Double.valueOf(arg[0]);
			double param_2 = Double.valueOf(arg[1]);
			
			result = param_1 + param_2;
			System.out.printf("sum      %.2f\n", result);
			
			result = param_1 - param_2;
			System.out.printf("subtrac %.2f\n", result);
			
			result = param_1 * param_2;
			System.out.printf("mult     %.2f\n", result);
			
			if (param_2 == 0)
			{
				System.out.println("Error: You can not divide by zero");
			}
			else
			{
				result = param_1 / param_2;
				System.out.printf("div      %.2f\n", result);
			}
			
			result = Math.pow(param_1 , param_2);
			System.out.printf("pow      %.2f\n", result); 
			
		}
		else
		{
			System.out.println("Please enter two parameters");
		}
	}
}