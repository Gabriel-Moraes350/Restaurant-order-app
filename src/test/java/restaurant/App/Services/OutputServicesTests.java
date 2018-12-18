package restaurant.App.Services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Services.OutputServices;
import restaurant.App.Factory.FactoryPeriod;
import restaurant.App.Model.Period.PeriodDay;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutputServicesTests {
	PeriodDay morning;
	PeriodDay night;
	
	@Before
	public void initObjects() {
		morning = new FactoryPeriod("morning").makePeriod();
		night = new FactoryPeriod("night").makePeriod();
	}

	@Test
	public void testIfOutputCorrectBasicMorning() {
		int[] arrayTestOutputCorrect = {1,2,3};
		// pass period and input
		OutputServices services = new OutputServices(morning, arrayTestOutputCorrect);
		
		assertEquals("eggs, toast, coffee", services.makeOutput());
	}
	
	@Test
	public void testIfOutputCorrectBasicMorningWithError() {
		int[] arrayTestOutputCorrect = {1,2,3, 4};
		// pass period and input
		OutputServices services = new OutputServices(morning, arrayTestOutputCorrect);
		
		assertEquals("eggs, toast, coffee, error", services.makeOutput());
	}
	

	@Test
	public void testIfOutputCorrectBasicNight() {
		int[] arrayTestOutputCorrect = {1,2,3, 4};
		// pass period and input
		OutputServices services = new OutputServices(night, arrayTestOutputCorrect);
		
		assertEquals("steak, potato, wine, cake", services.makeOutput());
	}
	
	@Test
	public void testIfOutputCorrectBasicNightWithError() {
		int[] arrayTestOutputCorrect = {1,2,3, 5};
		
		// pass period and input
		OutputServices services = new OutputServices(night, arrayTestOutputCorrect);
		
		assertEquals("steak, potato, wine, error", services.makeOutput());
	}
	
	@Test
	public void testIfOutputCorrectNightWithError() {
		int[] arrayTestOutputCorrect = {1,1,2,3,5};
		
		// pass period and input
		OutputServices services = new OutputServices(night, arrayTestOutputCorrect);
		
		assertEquals("steak, error", services.makeOutput());
	}
	
	@Test
	public void testIfOutputCorrectNightWitRepetition() {
		int[] arrayTestOutputCorrect = {1,2,2,4};
		
		// pass period and input
		OutputServices services = new OutputServices(night, arrayTestOutputCorrect);
		
		assertEquals("steak, potato(x2), cake", services.makeOutput());
	}
	
	@Test
	public void testIfOutputCorrectMorningWitRepetition() {
		int[] arrayTestOutputCorrect = {1,2,3,3,3};
		
		// pass period and input
		OutputServices services = new OutputServices(morning, arrayTestOutputCorrect);
		
		assertEquals("eggs, toast, coffee(x3)", services.makeOutput());
	}
	
	@Test
	public void testIfOutputExitWithError() {
		int[] arrayTestOutputCorrect = {5,0,1};
		
		// pass period and input
		OutputServices services = new OutputServices(morning, arrayTestOutputCorrect);
		
		assertEquals("error", services.makeOutput());
	}
	

}
