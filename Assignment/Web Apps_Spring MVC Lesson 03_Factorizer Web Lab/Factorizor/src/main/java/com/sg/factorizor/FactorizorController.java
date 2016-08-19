package com.sg.factorizor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/factorizor"})
public class FactorizorController {

    public FactorizorController() {
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String factorize(String numToFactor, Model model) {
        Map<String, Object> data = new HashMap<>();

        try {
            int num = Integer.parseInt(numToFactor);

            if (num <= 0) {
                data.put("Error", "Invalid Input (Negative or Zero Input)!!!");
            } else {
                String factors = "The factor of " + num + " are:";
                int perfectSum = 0;
                int primeCount = 0;

                for (int i = 1; i < num; i++) {
                    if (num % i == 0) {
                        factors += (" " + i);
                        primeCount++;
                        perfectSum += i;
                    }
                }

                data.put("1", factors);

                if (perfectSum == num) {
                    data.put("2", num + " is a perfect number");
                } else {
                    data.put("2", num + " is not a perfect number");
                }

                if (primeCount == 1) {
                    data.put("3", num + " is a prime number");
                } else {
                    data.put("3", num + " is not a prime number");
                }
            }

        } catch (Exception e) {
            data.put("Error", e);
        }

        model.addAttribute("data", data);
        return "response";
    }
}
