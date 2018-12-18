package restaurant.App.Model;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputTests {
	
	@Test
	public void shouldReturnEmpty() {
		InputStrings input = new InputStrings("");
		int[] array = {};
		assertArrayEquals(array,input.getInput());
	}
	
	@Test 
	public void testIfDoesntReorder() {
		InputStrings input = new InputStrings("1,2,3");
		int[] array = {1,2,3};
		assertArrayEquals(array, input.getInput());
	}
	
	@Test
	public void testIfOrderCorrect() {
		InputStrings input = new InputStrings("2,1,3");
		int[] array = {1,2,3};
		assertArrayEquals(array, input.getInput());
	}
	
	@Test
	public void testIfOrderCorrectWithRepetition() {
		InputStrings input = new InputStrings("2,2,1,3");
		int[] array = {1,2,2,3};
		assertArrayEquals(array, input.getInput());
	}
	
	@Test
	public void testIfOrderCorrectWithRepetition2() {
		InputStrings input = new InputStrings("1,1,3,2");
		int[] array = {1,1,2,3};
		assertArrayEquals(array, input.getInput());
	}
}
