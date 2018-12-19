package restaurant.App.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import restaurant.App.Factory.FactoryPeriod;
import restaurant.App.Model.Period.PeriodDay;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PeriodTests {
	
	PeriodDay night;
	PeriodDay morning;
	
	@Before
	public void initPeriods() {
		night = FactoryPeriod.make("night");
		
		morning = FactoryPeriod.make("morning");
	}
	
	@Test
	public void shouldReturnEggss() {	
		assertEquals("eggs", morning.mapOrdersByParam(1));
	}
	
	@Test
	public void shouldReturnToast() {
		assertEquals("toast", morning.mapOrdersByParam(2));
	}
	
	@Test
	public void shouldReturnCoffee() {
		assertEquals("coffee", morning.mapOrdersByParam(3));
	}
	
	@Test
	public void shouldReturnErrorMorning() {
		assertEquals("error", morning.mapOrdersByParam(4));
	}
	
	
	@Test
	public void shouldReturnSteak() {
		assertEquals("steak", night.mapOrdersByParam(1));
	}
	
	@Test
	public void shouldReturnPotato() {
		assertEquals("potato", night.mapOrdersByParam(2));
	}
	
	@Test
	public void shouldReturnCake() {
		assertEquals("cake", night.mapOrdersByParam(4));
	}
	
	@Test
	public void shouldReturnWine() {
		assertEquals("wine", night.mapOrdersByParam(3));
	}
	
	@Test
	public void shouldReturnErrorNight() {
		assertEquals("error", night.mapOrdersByParam(5));
	}
}
