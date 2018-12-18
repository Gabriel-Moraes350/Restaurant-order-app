package restaurant.App.Model;

import java.util.ArrayList;

import restaurant.App.Interfaces.Input;

public class InputStrings implements Input {

	private ArrayList<Integer> inputNumbers;
	
	public InputStrings(String separatedCommaString) {
		this.inputNumbers = new ArrayList<Integer>();
		
		String[] strings = separatedCommaString.split(",");
		for(String string: strings) {
			if(string.matches("\\d")) {
				inputNumbers.add(Integer.parseInt(string));
			}
		}
		
		this.sortInputNumber();
	}
	
	/**
	 * Method to order inputNumbers to send in order
	 */
	private void sortInputNumber() {
		this.inputNumbers.sort((p1, p2) -> p1.compareTo(p2));
	}
	
	
	/**
	 * Get sorted input
	 * @return Integer[]
	 */
	@Override
	public int[] getInput(){
		return this.inputNumbers.stream().mapToInt(i -> i).toArray();
	}
	
	
}
