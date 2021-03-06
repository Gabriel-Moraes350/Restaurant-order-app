package restaurant.App.Factory;

import restaurant.App.Exceptions.NotFoundException;
import restaurant.App.Model.Period.Morning;
import restaurant.App.Model.Period.Night;
import restaurant.App.Model.Period.PeriodDay;

public class FactoryPeriod {
	
	private final static String NIGHT = "night";
	private final static String MORNING = "morning";


	/**
	 * Method to produce a period instance
	 * 
	 * @param param
	 * @return
	 */
	public static PeriodDay make(String periodParam) throws NotFoundException {
		PeriodDay period;

		periodParam = periodParam.toLowerCase();


		switch(periodParam) {
			case NIGHT:
				 period = new Night();
				break;
			case MORNING:
				period = new Morning();
				break;
			default:
				throw new NotFoundException("Periodo desconhecido");

		}
		
		return period;
		
	}
	
}
