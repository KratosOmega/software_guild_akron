package com.swcguild.simplebank.controller;

import com.swcguild.simplebank.domain.AccountHolder;
import com.swcguild.simplebank.service.SimpleBankService;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "home"})
public class HomeController {
    
    // Uncomment if configuration is moved to annotation driven
    //    @Autowired
    //    @Qualifier("simpleBankService")
    private SimpleBankService service;
    
    public HomeController() {
    }
    
    // Comment out if configuration is moved to annotation driven
    @Inject
    public void setService(SimpleBankService service) {
        this.service = service;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String showHomePage(Map<String, Object> model) {
        List<AccountHolder> holders = service.getAllAccountHolders();
        model.put("accountHolders", holders );
        return "home";
    }
}
