/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplebank.controller;

import com.swcguild.simplebank.domain.AccountHolder;
import com.swcguild.simplebank.service.SimpleBankService;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author eric
 */
@Controller
@RequestMapping("/accountHolder")
public class AccountHolderController {

    // Uncomment if configuration is moved to annotation driven
    //    @Autowired
    //    @Qualifier("simpleBankService")
    private SimpleBankService service;

    public AccountHolderController() {
    }

    // Comment out if configuration is moved to annotation driven
    @Inject
    public void setService(SimpleBankService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showAccountHolder(@RequestParam("accountHolderId") String id, Map<String, Object> model) {
        AccountHolder holder = service.getAccountHolder(Integer.parseInt(id));
        model.put("accountHolder", holder);
        model.put("accounts", service.getAccountsForAccountHolder(holder));
        return "accountHolder/view";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String displayAccountHolderForm(Map<String, Object> model) {
        model.put("accountHolder", new AccountHolder());
        return "accountHolder/edit";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String createAccountHolderFromForm(@ModelAttribute("accountHolder") AccountHolder accountHolder,
                                                BindingResult bindingResult,
                                                Map<String, Object> model,
                                                HttpServletRequest req) {
        
        service.createAccountHolder(accountHolder);
        
        return "redirect:/accountHolder?accountHolderId=" + accountHolder.getId();
    }
    
    // REST handlers
    
    @RequestMapping(value="/rest/{id}", method=RequestMethod.GET)
    @ResponseBody public AccountHolder getAccountHolder(@PathVariable("id") int id) {
        return service.getAccountHolder(id);
    }
    
    @RequestMapping(value="/rest/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putAccountHolder(@PathVariable("id") int id, @RequestBody AccountHolder accountHolder) {
        service.updateAccountHolder(accountHolder);   
    }
    
    @RequestMapping(value="/rest", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody AccountHolder createAccountHolder(@RequestBody AccountHolder holder) {
        service.createAccountHolder(holder);
        return holder;
    }
}
