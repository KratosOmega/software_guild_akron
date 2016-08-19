/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.model.Dvd;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.sg.dvdlibrary.dao.DvdLibraryApi;

/**
 *
 * @author Kratos
 */
@Controller
public class HomeController {

    private DvdLibraryApi dao;

    @Inject
    public HomeController(DvdLibraryApi dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
        return "search";
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Dvd getAddress(@PathVariable("id") int id) {
        return dao.getDvdById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Dvd addAddress(@Valid @RequestBody Dvd dvd) {
        dao.addDvd(dvd);
        return dvd;
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAddress(@PathVariable("id") String id) {
        dao.deleteDvd(Integer.parseInt(id));
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editAddress(@PathVariable("id") int id, @Valid @RequestBody Dvd dvd) {
        dao.editDvd(dvd);

    }

    @RequestMapping(value = "/dvd", method = RequestMethod.GET)
    @ResponseBody
    public List<Dvd> getAllDvds() {
        return dao.getAllDvds();
    }
    
//- Search Dvd
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Dvd> searchDvds(@Valid @RequestBody Dvd dvd) {
        return dao.getDvdBySearch(dvd);
    }

}
