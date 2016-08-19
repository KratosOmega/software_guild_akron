/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.springmvc_sitelab;

/**
 *
 * @author Kratos
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/luckySevens"})
public class LuckySevensController {

    public LuckySevensController() {
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayLandingPage(){
        return "luckySevensIndex";
    }

    @RequestMapping(value = "/roll", method = RequestMethod.POST)
    public String playGame(String initialBet, Model model) {
        Map<String, Object> data = new HashMap<>();

        try {
            double bet = Double.parseDouble(initialBet);

            if (bet <= 0) {
                model.addAttribute("data", "Invalid Input (Negative or Zero Input)!!!");
                return "response_error";
            } else {
                Random random = new Random();
                int diceA = 0;
                int diceB = 0;
                int roll = 0;
                int rollAtMax = 0;
                double max = 0;
                double amount = 0;

                // start loop game until player enter something other than play
                max = bet;
                amount = bet;

                while (amount > 0) {
                    diceA = 1 + random.nextInt(6);
                    diceB = 1 + random.nextInt(6);
                    roll++;

                    if ((diceA + diceB) == 7) {
                        amount += 4;
                    } else {
                        amount--;
                    }

                    if (max < amount) {
                        max = amount;
                        rollAtMax = roll;
                    }
                }

                data.put("Starting Bet", bet);
                data.put("Total Roll", roll);
                data.put("Highest Amount", max);
                data.put("Highest Roll", rollAtMax);

                model.addAttribute("data", data);
                return "luckySevensResponse_result";
            }
        } catch (Exception e) {
            model.addAttribute("data", e);
            return "luckySevensResponse_error";
        }
    }
}
