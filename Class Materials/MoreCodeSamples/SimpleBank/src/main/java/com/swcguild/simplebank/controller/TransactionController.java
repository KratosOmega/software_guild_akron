/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplebank.controller;

import com.swcguild.simplebank.service.SimpleBankService;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author eric
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {
    // Uncomment if configuration is moved to annotation driven
    //    @Autowired
    //    @Qualifier("simpleBankService")

    private SimpleBankService service;

    // Comment out if configuration is moved to annotation driven
    @Inject
    public void setService(SimpleBankService service) {
        this.service = service;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String showTransaction(@RequestParam("transactionId") int id, Map<String, Object> model) {
        model.put("transaction", service.getDepositWithdrawal(id));
        return "transaction";
    }
}
