/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplebank.controller;

import com.swcguild.simplebank.domain.Account;
import com.swcguild.simplebank.domain.AccountHolder;
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
@RequestMapping("/account")
public class AccountController {
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
    public String showAccount(@RequestParam("accountId") int id, Map<String, Object> model) {
        Account account = service.getAccount(id);
        AccountHolder holder = service.getAccountHolder(account.getAccountHolderId());
        model.put("account", account);
        model.put("accountHolder", holder);
        model.put("transactions", service.getAllDepsositsWithdrawalsForAccount(account));
        model.put("transfersIn", service.getAllIncomingTransfersForAccount(account));
        model.put("transfersOut", service.getAllOutgoingTransfersForAccount(account));
        return "account";
    }
}
