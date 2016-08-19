package com.sg.interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/interestCalculator"})
public class InterestCalculatorController {

    public InterestCalculatorController() {
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(String interestRate, String principal, String years, String compoundPeriod, Model model) {
        List<Object> data = new ArrayList<>();
        List<Object> report;

        try {
            double rate = Double.parseDouble(interestRate);
            double initialPrincipal = Double.parseDouble(principal);
            double year = Double.parseDouble(years);

            if (rate <= 0 || initialPrincipal <= 0 || year <= 0) {
                model.addAttribute("error", "Invalid Input (Negative or Zero Input)!!!");
                return "response_error";
            } else {
                int counter = 0;
                double currentBalance;
                int annualPeriods = 0;

                // Update current balance
                currentBalance = initialPrincipal;

                // Determine periods #
                switch (compoundPeriod) {
                    case "quarterly":
                        annualPeriods = 4;
                        break;
                    case "monthly":
                        annualPeriods = 12;
                        break;
                    case "daily":
                        annualPeriods = 365;
                        break;
                    default:
                }

                while (year > 0) {
                    counter++;
                    if (year < 1) {
                        report = new ArrayList<>();
                        double lastPeriods = annualPeriods * year;
                        double beginningBalance = currentBalance;
                        for (int i = 0; i < lastPeriods; i++) {
                            currentBalance = currentBalance * (1 + (rate / annualPeriods) / 100);
                        }
                        report.add(round(beginningBalance, 2));
                        report.add(round(currentBalance - beginningBalance, 2));
                        report.add(round(currentBalance, 2));
                        data.add(report);
                    } else {
                        report = new ArrayList<>();
                        double beginningBalance = currentBalance;
                        for (int i = 0; i < annualPeriods; i++) {
                            currentBalance = currentBalance * (1 + (rate / annualPeriods) / 100);
                        }
                        report.add(round(beginningBalance, 2));
                        report.add(round(currentBalance - beginningBalance, 2));
                        report.add(round(currentBalance, 2));
                        data.add(report);
                    }
                    year--;
                }
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
