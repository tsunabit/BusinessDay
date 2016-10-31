import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import bar.Calculator;


public class CalculatorTest {
	
	@Test
	public void multiplyMethodTest3x4() {
//		fail("Not yet implemented");
		//SetUp
		Calculator calc = new Calculator();
		int expected = 12;
		//Exercise
		int actual = calc.multiply(3, 4);
		//Verify
		assertThat(actual, is(expected));
		//tear down
	}
	
	@Test
	public void multiplyMethodTest5x7() {
		//SetUp
		Calculator calc = new Calculator();
		int expected = 35;
		//Exercise
		int actual = calc.multiply(5, 7);
		//Verify
		assertThat(actual, is(expected));
		//tear down
	}
	
	@Test
	public void divideMethodTest3waru2() {
		//SetUp
		Calculator calc = new Calculator();
		double expected = 1.5;
		//Exercise
		double actual = calc.divide(3, 2);
		//Verify
		assertThat(actual, is(expected));
		//tear down
		
	}
	
	@Test
	public void divideMethodTest7waru7() {
		//SetUp
		Calculator calc = new Calculator();
		double expected = 1.0;
		//Exercise
		double actual = calc.divide(7, 7);
		//Verify
		assertThat(actual, is(expected));
		//tear down
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divideMethodTestwaru0() {
		//SetUp
		Calculator calc = new Calculator();
		//Exercise
		calc.divide(3, 0);
		//Verify
		//tear down
	}
	
	
}
