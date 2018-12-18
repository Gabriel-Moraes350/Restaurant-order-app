package restaurant.App.Factory;

import restaurant.App.Model.Period.Morning;
import restaurant.App.Model.Period.Night;
import restaurant.App.Model.Period.PeriodDay;

public class FactoryPeriod {
	
	private final static String NIGHT = "night";
	private final static String MORNING = "morning";
	
	private String periodParam;
	
	public FactoryPeriod(String param) {
		this.periodParam = param.toLowerCase();
	}

	/**
	 * Method to  build a period instance
	 * 
	 * @param param
	 * @return
	 */
	public PeriodDay makePeriod() {
		PeriodDay period;
		switch(this.periodParam) {
			case NIGHT:
				 period = new Night();
				break;
			case MORNING:
				period = new Morning();
				break;
			default:
				period = null;
				break;
		}
		
		return period;
		
	}
	
}
