package com.sg.springmvc_sitelab;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/tipCalculator"})
public class TipCalculatorController {

    public TipCalculatorController() {
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayLandingPage(){
        return "tipCalculatorIndex";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String sayHi(String amount, String tipRate, Model model) {
        try {
            double subTotal = Double.parseDouble(amount);
            double rate = Double.parseDouble(tipRate);

            if (subTotal <= 0 || rate <= 0) {
                model.addAttribute("error", "Invalid Input (Negative or Zero) !!!");
                return "tipCalculatorResponse_error";
            } else {
                Map<String, Object> data = new HashMap<>();
                double tip = subTotal * rate / 100;
                double total = subTotal + tip;

                data.put("subTotal", round(subTotal));
                data.put("tipRate", tipRate);
                data.put("tip", round(tip));
                data.put("total", round(total));

                model.addAttribute("data", data);
                return "tipCalculatorResponse_result";
            }
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "tipCalculatorResponse_error";
        }
    }

    public static String round(double value) {
        DecimalFormat decimalOf2 = new DecimalFormat("0.00");
        return decimalOf2.format(value);
    }
}
