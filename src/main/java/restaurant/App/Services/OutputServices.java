package restaurant.App.Services;

import restaurant.App.Interfaces.Output;
import restaurant.App.Model.Period.PeriodDay;

public class OutputServices {
	private int[] inputNumbers;
	private PeriodDay period;
	private StringBuilder sb;
	private int countRepeated;
	private Output out;
	
	public OutputServices(PeriodDay period, int[] inputNumbers, Output out) {
		this.inputNumbers = inputNumbers;
		this.period = period;
		this.out = out;
	}
	
	/**
	 * Method to get result
	 * 
	 * @return stringResult
	 */
	public String getResult() {
		// new stringBuilder
		sb = new StringBuilder("");
		
		//map array input 
		this.mapInputToString();
		
		//set value on output
		out.setOutput(this.formatStringToOutput());
		
		return out.getOutput();
	}
	
	/**
	 * Method to map input to string
	 */
	private void mapInputToString() {
		int count = 0;
		countRepeated = 0;
		
		for(int number: inputNumbers) {
			//add commas
			if(count++ > 0 && !this.equalsToExceptionOrder(number)) {
				sb.append(", ");
			}
			
			//get dish
			String string = period.mapOrdersByParam(number);
			
			//check for erros
			if(this.hasErrors(string, number)) {
				sb.append(PeriodDay.ERROR);
				break;
			}
			
			//check if is exception
			if(this.equalsToExceptionOrder(number)) {
				if(countRepeated == 0)
				{
					sb.append(count != 1 ? ", " + string : "" + string);
				}
				countRepeated++;
					
			} else {
				sb.append(string);
			}
			
		}
	}
	
	/**
	 * Method to check of string given has errors
	 * 
	 * @param checkString
	 * @param number
	 * @return
	 */
	private boolean hasErrors(String checkString, int number) {
		if(checkString.equals(PeriodDay.ERROR))
			return true;
		
		
		if(this.checkContainString(checkString) && period.getExceptionOrder() != number) {
			return true;
		}
		
		return false;
	}
	
	
	
	/**
	 * Method to check if Stringbuilder contains another string
	 * 
	 * @param checkString
	 * @return
	 */
	private boolean checkContainString(String checkString) {
		String completeStr = sb.toString();
		return completeStr.contains(checkString);
	}
	
	
	/**
	 * Method to format final string
	 * 
	 * @param repeated
	 * @return
	 */
	private String formatStringToOutput() {
		String str = sb.toString();
		
		if(this.countRepeated > 1) {
			String exception = period.mapOrdersByParam(period.getExceptionOrder());
			str = str.replaceAll(exception, exception + "(x"+this.countRepeated+")");
		}
		
			
		return str;
	}
	
	/**
	 * Method to test if number equals to order exception
	 * 
	 * @param number
	 * @return
	 */
	private boolean equalsToExceptionOrder(int number) {
		return period.getExceptionOrder() == number;
	}
	
	
}
