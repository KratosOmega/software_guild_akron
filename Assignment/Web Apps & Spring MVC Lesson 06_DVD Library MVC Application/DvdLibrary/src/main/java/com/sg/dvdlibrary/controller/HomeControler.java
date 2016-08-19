/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryImplementation;
import com.sg.dvdlibrary.model.Dvd;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kratos
 */
@Controller
public class HomeControler {

    private DvdLibraryImplementation dao;

    @Inject
    public HomeControler(DvdLibraryImplementation dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        if (dao.listAll().isEmpty()) {
            loadTestData();
        }

        model.addAttribute("emptyDvdForAdd", new Dvd());

        return "home";
    }

    @RequestMapping(value = "/getDvds", method = RequestMethod.GET)
    @ResponseBody
    public List<Dvd> getDvds() {
        return dao.listAll();
    }

    public void loadTestData() {
        Dvd testDvd1 = new Dvd();

        testDvd1.setTitle("Xin");
        testDvd1.setReleaseDate(1990);
        testDvd1.setMpaaRating("PG-13");
        testDvd1.setDirector("Li");
        testDvd1.setStudio("Blizzard");
        testDvd1.setNote("TestNote Data");

        dao.add(testDvd1);

        Dvd testDvd2 = new Dvd();

        testDvd2.setTitle("Illidan");
        testDvd2.setReleaseDate(1999);
        testDvd2.setMpaaRating("PG-12");
        testDvd2.setDirector("Stormrage");
        testDvd2.setStudio("Blizzard");
        testDvd2.setNote("TestNote Data");

        dao.add(testDvd2);

        Dvd testDvd3 = new Dvd();

        testDvd3.setTitle("Kratos");
        testDvd3.setReleaseDate(2000);
        testDvd3.setMpaaRating("PG-13");
        testDvd3.setDirector("Omega");
        testDvd3.setStudio("GOW");
        testDvd3.setNote("TestNote Data");

        dao.add(testDvd3);
    }

    // !!! Note: @ModelAttribute -> has to be followed by the ("emptyDvdForAdd") which contains,
    //           the form's corresponding -> modelAttribute="emptyDvdForAdd",
    //           otherwise, will be Status 500 error
    @RequestMapping(value = "/addValidationCheck", method = RequestMethod.POST)
    public String addValidationCheck(@Valid @ModelAttribute("emptyDvdForAdd") Dvd dvd, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "home";
        }

        dao.add(dvd);

        model.addAttribute("emptyDvdForAdd", new Dvd());
        return "home";
    }

    @RequestMapping(value = "/homeEdit", method = RequestMethod.POST)
    public String homeEdit(HttpServletRequest request, Model model) {
        Dvd editedDvd = new Dvd();

        editedDvd.setId(Integer.parseInt(request.getParameter("id")));
        editedDvd.setTitle(request.getParameter("title"));
        editedDvd.setReleaseDate(Integer.parseInt(request.getParameter("releaseDate")));
        editedDvd.setMpaaRating(request.getParameter("mpaaRating"));
        editedDvd.setDirector(request.getParameter("director"));
        editedDvd.setStudio(request.getParameter("studio"));
        editedDvd.setNote(request.getParameter("note"));

        dao.edit(editedDvd);

        model.addAttribute("emptyDvdForAdd", new Dvd());

        return "home";
    }

    @RequestMapping(value = "/homeDelete", method = RequestMethod.POST)
    public String homeDelete(HttpServletRequest request, Model model) {
        int removeId = Integer.parseInt(request.getParameter("id"));

        dao.remove(removeId);

        model.addAttribute("emptyDvdForAdd", new Dvd());

        return "home";
    }
}
