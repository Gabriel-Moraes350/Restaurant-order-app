package restaurant.App.Services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import restaurant.App.Factory.FactoryPeriod;
import restaurant.App.Model.OutputStrings;
import restaurant.App.Model.Period.PeriodDay;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutputServicesTests {
	PeriodDay morning;
	PeriodDay night;
	
	@Before
	public void initPeriods() {
		night = FactoryPeriod.make("night");
		
		morning = FactoryPeriod.make("morning");
	}
	
	@Test
	public void testIfOutputCorrectBasicMorning() {
		int[] arrayTestOutputCorrect = {1,2,3};
		// pass period and input
		OutputServices services = new OutputServices(morning, arrayTestOutputCorrect, new OutputStrings());
		
		assertEquals("eggs, toast, coffee", services.getResult());
	}
	
	@Test
	public void testIfOutputCorrectBasicMorningWithError() {
		int[] arrayTestOutputCorrect = {1,2,3, 4};
		// pass period and input
		OutputServices services = new OutputServices(morning, arrayTestOutputCorrect, new OutputStrings());
		
		assertEquals("eggs, toast, coffee, error", services.getResult());
	}
	

	@Test
	public void testIfOutputCorrectBasicNight() {
		int[] arrayTestOutputCorrect = {1,2,3, 4};
		// pass period and input
		OutputServices services = new OutputServices(night, arrayTestOutputCorrect, new OutputStrings());
		
		assertEquals("steak, potato, wine, cake", services.getResult());
	}
	
	@Test
	public void testIfOutputCorrectBasicNightWithError() {
		int[] arrayTestOutputCorrect = {1,2,3, 5};
		
		// pass period and input
		OutputServices services = new OutputServices(night, arrayTestOutputCorrect, new OutputStrings());
		
		assertEquals("steak, potato, wine, error", services.getResult());
	}
	
	@Test
	public void testIfOutputCorrectNightWithError() {
		int[] arrayTestOutputCorrect = {1,1,2,3,5};
		
		// pass period and input
		OutputServices services = new OutputServices(night, arrayTestOutputCorrect, new OutputStrings());
		
		assertEquals("steak, error", services.getResult());
	}
	
	@Test
	public void testIfOutputCorrectNightWitRepetition() {
		int[] arrayTestOutputCorrect = {1,2,2,4};
		
		// pass period and input
		OutputServices services = new OutputServices(night, arrayTestOutputCorrect, new OutputStrings());
		
		assertEquals("steak, potato(x2), cake", services.getResult());
	}
	
	@Test
	public void testIfOutputCorrectMorningWitRepetition() {
		int[] arrayTestOutputCorrect = {1,2,3,3,3};
		
		// pass period and input
		OutputServices services = new OutputServices(morning, arrayTestOutputCorrect, new OutputStrings());
		
		assertEquals("eggs, toast, coffee(x3)", services.getResult());
	}
	
	@Test
	public void testIfOutputExitWithError() {
		int[] arrayTestOutputCorrect = {5,0,1};
		
		// pass period and input
		OutputServices services = new OutputServices(morning, arrayTestOutputCorrect, new OutputStrings());
		
		assertEquals("error", services.getResult());
	}
	

}
