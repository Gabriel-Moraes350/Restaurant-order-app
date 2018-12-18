package restaurant.App.Factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import restaurant.App.Model.Period.Morning;
import restaurant.App.Model.Period.Night;
import restaurant.App.Model.Period.PeriodDay;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryPeriodTests {


	@Test
	public void shouldNotMapPeriod() {
		PeriodDay period = new FactoryPeriod("").makePeriod();
		assertNull(period);
	}
	
	
	@Test
	public void shouldReturnNight() {
		PeriodDay period = new FactoryPeriod("night").makePeriod();
		
		assertEquals(new Night().getClass(), period.getClass());
	}
	
	@Test
	public void shouldReturnNightUpperCase() {
		PeriodDay period = new FactoryPeriod("NIGHT").makePeriod();
		
		assertEquals(new Night().getClass(), period.getClass());
	}
	
	@Test
	public void shouldReturnMorning() {
		PeriodDay period = new FactoryPeriod("morning").makePeriod();
		
		assertEquals(new Morning().getClass(), period.getClass());
	}
		
}
