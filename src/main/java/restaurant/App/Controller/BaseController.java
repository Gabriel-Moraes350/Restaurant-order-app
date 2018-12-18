package restaurant.App.Controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restaurant.App.Factory.FactoryPeriod;
import restaurant.App.Model.InputStrings;
import restaurant.App.Model.Period.PeriodDay;
import restaurant.App.Services.OutputServices;
import restaurant.App.Utils.ResponseUtils;

@RestController
public class BaseController {

	@RequestMapping("/")
	public ResponseUtils index() {
		return new ResponseUtils(true, "funcionando...");
	}
	
	@RequestMapping("/orders")
	public ResponseUtils getOrders(@RequestParam(name="period") String periodParam,
@RequestParam(name="orders") String ordersParam, HttpServletResponse response){
		PeriodDay period = new FactoryPeriod(periodParam).makePeriod();
		
		//check periodo
		if(period == null) {
			response.setStatus(response.SC_BAD_REQUEST);
			return new ResponseUtils(false, "", "Period not supported");
		}
		
		InputStrings input = new InputStrings(ordersParam);
		
		if(input.getInput().length == 0) {
			response.setStatus(response.SC_BAD_REQUEST);
			return new ResponseUtils(false, "", "None type of dishes was passed");
		}
		
		OutputServices outputServices = new OutputServices(period, input.getInput());
		
		return new ResponseUtils(true, outputServices.makeOutput());
	}
}
