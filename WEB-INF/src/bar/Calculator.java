package bar;

public class Calculator {
	
	public int multiply(int x, int y){
		return x * y;
	}
	
	public double divide(int x, int y){
		
		if(y == 0){
			throw new IllegalArgumentException("divide by zero");
		}
		
		return (double)x / (double)y;		
	}
	
	
}
