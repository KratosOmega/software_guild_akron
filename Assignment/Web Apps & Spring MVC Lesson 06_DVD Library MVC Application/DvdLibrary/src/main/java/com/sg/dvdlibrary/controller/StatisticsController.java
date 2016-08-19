/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryImplementation;
import com.sg.dvdlibrary.model.Dvd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kratos
 */
@Controller
public class StatisticsController {

    private DvdLibraryImplementation dao;

    @Inject
    public StatisticsController(DvdLibraryImplementation dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String statistics() {
        return "statistics";
    }

    @RequestMapping(value = "/avgAge", method = RequestMethod.GET)
    @ResponseBody
    public String avgAge() {
        return round(dao.fitlerAvgAge());
    }

    @RequestMapping(value = "/newest", method = RequestMethod.GET)
    @ResponseBody
    public Dvd newest() {
        return dao.fitlerNewestMovie();
    }

    @RequestMapping(value = "/oldest", method = RequestMethod.GET)
    @ResponseBody
    public Dvd oldest() {
        return dao.fitlerOldestMovie();
    }

    @RequestMapping(value = "/avgNote", method = RequestMethod.GET)
    @ResponseBody
    public String avgNote() {
        return round(dao.calculateAvgNotes());
    }

    public static String round(double value) {
        DecimalFormat decimalOf2 = new DecimalFormat("0.00");
        return decimalOf2.format(value);
    }
}
