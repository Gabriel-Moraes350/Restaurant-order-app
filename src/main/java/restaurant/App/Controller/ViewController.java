package restaurant.App.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import restaurant.App.Model.Period.Night;

@Controller
@RequestMapping(value="/view")
public class ViewController {

    @GetMapping("/test")
    public String greeting(Model model){
        model.addAttribute(new Night());

        return "test";
    }
}
