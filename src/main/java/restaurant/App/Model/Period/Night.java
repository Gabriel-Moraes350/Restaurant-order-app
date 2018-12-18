package restaurant.App.Model.Period;

public class Night extends PeriodDay{
	private String[] orders = {
			"steak", "potato", "wine", "cake"
	};
	private final int POTATO = 2;
	
	@Override
	public String[] getItems() {
		return orders;
	}
	
	@Override
	public int getExceptionOrder() {
		return  POTATO;
	}
}
