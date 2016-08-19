package com.sg.springmvc_sitelab;

import java.text.DecimalFormat;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/unitConverter"})
public class UnitConverterController {

    public UnitConverterController() {
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayLandingPage(){
        return "unitConverterIndex";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public String vo(String type, String convertFrom, String convertTo, String input, Model model) {
        model.addAttribute("type", type);
        model.addAttribute("convertFrom", convertFrom);
        model.addAttribute("convertTo", convertTo);

        try {
            double param = Double.parseDouble(input);
            String unit = "";
            double result = 0;
            
            String fromTo = convertFrom + "-" + convertTo;

            switch (fromTo) {
                // ******************** Temperature
                case "celsius-kelvin":
                    result = param + 273.15;
                    unit = "K&deg;";
                    break;
                case "kelvin-celsius":
                    result = param - 273.15;
                    unit = "C&deg;";
                    break;
                // ******************** Currency
                case "dollar-euro":
                    result = param * 0.904;
                    unit = "Euros";
                    break;
                case "dollar-rmb":
                    result = param * 6.69;
                    unit = "RMBs";
                    break;
                case "euro-dollar":
                    result = param * 1.11;
                    unit = "Dollars";
                    break;
                case "euro-rmb":
                    result = param * 7.39;
                    unit = "RMBs";
                    break;
                case "rmb-dollar":
                    result = param * 0.15;
                    unit = "Dollars";
                    break;
                case "rmb-euro":
                    result = param * 0.14;
                    unit = "Euros";
                    break;
                // ******************** Volume
                case "oz-qt":
                    result = param * 0.03125;
                    unit = "qt";
                    break;
                case "oz-gal":
                    result = param * 0.0078125;
                    unit = "gal";
                    break;
                case "qt-oz":
                    result = param * 32;
                    unit = "oz";
                    break;
                case "qt-gal":
                    result = param * 0.25;
                    unit = "gal";
                    break;
                case "gal-oz":
                    result = param * 128;
                    unit = "oz";
                    break;
                case "gal-qt":
                    result = param * 4;
                    unit = "qt";
                    break;
                // ******************** Mass
                case "kg-lb":
                    result = param * 2.20462;
                    unit = "kg";
                    break;
                case "lb-kg":
                    result = param * 0.453592;
                    unit = "kg";
                    break;
                default:
                    model.addAttribute("warning", "You selected the same units to process conversion!");
                    return "unitConverterResponse_warning";
            }

            model.addAttribute("data", round(result));
            model.addAttribute("unit", unit);
            return "unitConverterResponse_result";

        } catch (Exception e) {
            model.addAttribute("error", e);
            return "unitConverterResponse_error";
        }
    }

    public static String round(double value) {
        DecimalFormat decimalOf2 = new DecimalFormat("0.00");
        return decimalOf2.format(value);
    }
}
