package restaurant.App.Model.Period;

public class Morning extends PeriodDay{
	private String[] orders = {
			"eggs", "toast", "coffee"
	};
	private final int COFFEE = 3;

	@Override
	public String[] getItems() {
		return orders;
	}
	
	@Override
	public int getExceptionOrder() {
		return  COFFEE;
	}
}
