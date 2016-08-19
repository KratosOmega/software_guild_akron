package com.sg.flooringcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String sayHi(String floorWidth, String floorLength, String flooringPrice, Model model) {
        try {
            Map<String, Object> data = new HashMap<>();

            double width = Double.parseDouble(floorWidth);
            double length = Double.parseDouble(floorLength);
            double materialPrice = Double.parseDouble(floorLength);

            if (width <= 0 || length <= 0 || materialPrice <= 0) {
                model.addAttribute("error", "Invalid Input (Negative or Zero Input)!!!");
                return "response_error";
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

                data.put("materialCost", round(materialCost, 2));
                data.put("laborCost", round(laborCost, 2));
                data.put("totalCost", round(materialCost + laborCost, 2));

                model.addAttribute("data", data);
                return "response";
            }
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "response_error";
        }
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
