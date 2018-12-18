package restaurant.App.Model.Period;

public abstract class PeriodDay {
	public final static String ERROR = "error";
	/**
	 * Method to get Items 
	 * 
	 * @return
	 */
	public abstract String[] getItems();
	
	public abstract int getExceptionOrder();
	
	
	/**
	 * Method to map and get items for orders
	 * 
	 * @param order
	 * @return
	 */
	public String mapOrdersByParam(int order) {
		String nameOrder = "";
		String[] orders = this.getItems();
		try {
			nameOrder = orders[order - 1];
		}catch(Exception arrayException) {
			nameOrder = ERROR;
		}
		
		return nameOrder;
	}

}
