package restaurant.App.Model;

import restaurant.App.Interfaces.Output;

public class OutputStrings implements Output{
	private String output;
	
	public OutputStrings(String output) {
		this.output = output;
	}
	
	@Override
	public String getOutput() {
		return output;
	}
	
}
