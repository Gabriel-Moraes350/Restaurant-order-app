package restaurant.App.Controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import restaurant.App.Factory.FactoryPeriod;
import restaurant.App.Model.InputStrings;
import restaurant.App.Model.OutputStrings;
import restaurant.App.Model.Period.PeriodDay;
import restaurant.App.Services.OutputServices;
import restaurant.App.Utils.ResponseUtils;
import springfox.documentation.schema.Example;

@RestController
@Api(value="Base", description = "Orders Restaurant")
public class BaseController {

	@GetMapping("/")
	@ApiOperation(value="index")
	public ResponseEntity<ResponseUtils> index() {
			String s = "teste";
 			return ResponseEntity.ok().body(new ResponseUtils(true, "working..."));
	}
	
	
	@RequestMapping(value="/dishes", method=RequestMethod.GET, produces="application/json")
	@ApiOperation(value="EndPoint to get dishes by order numbers and period of the day", response= ResponseUtils.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 404, message="Something wrong with params", response = ResponseUtils.class)
	})
	public ResponseUtils getOrders(	@ApiParam(required= true, value="Period of the day", example = "night")
									@RequestParam(name="period", defaultValue = "") String periodParam,
									
									@ApiParam(required = true, value="List of orders separated by commas", example = "1,2,3")
									@RequestParam(name="orders", defaultValue = "") String ordersParam,
									HttpServletResponse response)
	{

		PeriodDay period = FactoryPeriod.make(periodParam);
		
		//input
		InputStrings input = new InputStrings(ordersParam);
		
		//map output
		OutputServices outputServices = new OutputServices(period, input.getInput(), new OutputStrings());
		
		return new ResponseUtils(true, outputServices.getResult());
	}

}
