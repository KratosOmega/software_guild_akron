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
@RequestMapping({"/flooringCalculator"})
public class FlooringCalculatorController {

    public FlooringCalculatorController() {
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayLandingPage(){
        return "flooringCalculatorIndex";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String sayHi(String floorWidth, String floorLength, String flooringPrice, Model model) {
        try {
            Map<String, Object> data = new HashMap<>();

            double width = Double.parseDouble(floorWidth);
            double length = Double.parseDouble(floorLength);
            double materialPrice = Double.parseDouble(flooringPrice);

            if (width <= 0 || length <= 0 || materialPrice <= 0) {
                model.addAttribute("error", "Invalid Input (Negative or Zero Input)!!!");
                return "flooringCalculatorResponse_error";
            } else {
                double floorArea = width * length;
                double materialCost = 0;
                double laborCost = 0;
                double incrementLaborPrice = 86 * 0.25;
                int intervalCount = 0;
                double time = floorArea / 20 * 60;

                if (time % 15 == 0) {
                    intervalCount = (int) (time / 15);
                } else {
                    intervalCount = (int) (time / 15) + 1;
                }

                materialCost = floorArea * materialPrice;
                laborCost = intervalCount * incrementLaborPrice;

                data.put("materialCost", round(materialCost));
                data.put("laborCost", round(laborCost));
                data.put("totalCost", round(materialCost + laborCost));

                model.addAttribute("data", data);
                return "flooringCalculatorResponse_result";
            }
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "flooringCalculatorResponse_error";
        }
    }

    public static String round(double value) {
        DecimalFormat decimalOf2 = new DecimalFormat("0.00");
        return decimalOf2.format(value);
    }
}
