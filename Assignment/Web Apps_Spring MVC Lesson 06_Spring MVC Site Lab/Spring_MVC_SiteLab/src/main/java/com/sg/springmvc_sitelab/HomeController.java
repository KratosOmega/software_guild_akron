package com.sg.springmvc_sitelab;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/chooseProgram"})
public class HomeController {

    public HomeController() {
    }
    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayLandingPage(){
        return "home";
    }

    @RequestMapping(value = "/choose", method = RequestMethod.POST)
    public String chooseProgram(String program) {
        switch (program) {
            case "luckySevens":
                return "luckySevensIndex";
            case "factorizor":
                return "factorizorIndex";
            case "interest":
                return "interestCalculatorIndex";
            case "flooring":
                return "flooringCalculatorIndex";
            case "tip":
                return "tipCalculatorIndex";
            case "unit":
                return "unitConverterIndex";
            default:
                return "";
        }
    }
}
