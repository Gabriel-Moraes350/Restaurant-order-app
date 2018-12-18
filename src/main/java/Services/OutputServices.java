package Services;

import restaurant.App.Model.OutputStrings;
import restaurant.App.Model.Period.PeriodDay;

public class OutputServices {
	private int[] inputNumbers;
	private PeriodDay period;
	private StringBuilder sb;
	
	public OutputServices(PeriodDay period, int[] inputNumbers) {
		this.inputNumbers = inputNumbers;
		this.period = period;
		
	}
	
	
	public String makeOutput() {
		// new stringBuilder
		sb = new StringBuilder("");
		
		//map array input 
		OutputStrings output = new OutputStrings(this.mapInputToString());
		return output.getOutput();
	}
	
	private String mapInputToString() {
		int count = 0;
		int countRepeat = 0;
		
		for(int number: inputNumbers) {
			//add commas
			if(count++ > 0 && period.getExceptionOrder() != number) {
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
			if(period.getExceptionOrder() == number) {
				if(countRepeat == 0)
				{
					sb.append(", ");
					sb.append(string);
				}
				countRepeat++;
					
			} else {
				sb.append(string);
			}
			
		}
		return this.getStringToOutput(countRepeat);
	}
	
	
	private boolean hasErrors(String checkString, int number) {
		if(checkString.equals(PeriodDay.ERROR))
			return true;
		
		
		if(this.checkContainString(checkString) && period.getExceptionOrder() != number) {
			return true;
		}
		
		return false;
	}
	
	private boolean checkContainString(String checkString) {
		String completeStr = sb.toString();
		return completeStr.contains(checkString);
	}
	
	
	private String getStringToOutput(int repeated) {
		String str = sb.toString();
		
		if(repeated > 1) {
			String exception = period.mapOrdersByParam(period.getExceptionOrder());
			str = str.replaceAll(exception, exception + "(x"+repeated+")");
		}
		
			
		return str;
	}
	
	
}
