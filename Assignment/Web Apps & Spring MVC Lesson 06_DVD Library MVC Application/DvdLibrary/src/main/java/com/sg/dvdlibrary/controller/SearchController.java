/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryImplementation;
import com.sg.dvdlibrary.dao.SearchTerm;
import com.sg.dvdlibrary.model.Dvd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kratos
 */
@Controller
public class SearchController {

    private DvdLibraryImplementation dao;

    @Inject
    public SearchController(DvdLibraryImplementation dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {

        return "search";
    }

    @RequestMapping(value = "/search/dvds", method = RequestMethod.POST)
    @ResponseBody
    public List<Dvd> searchDvd(@RequestBody Map<String, String> jsonSearchMap) {
        Map<SearchTerm, String> criteria = new HashMap<>();

        if (!jsonSearchMap.get("title").isEmpty()) {
            criteria.put(SearchTerm.TITLE, jsonSearchMap.get("title"));
        }

        if (!jsonSearchMap.get("releaseDate").isEmpty()) {
            criteria.put(SearchTerm.RELEASE_DATE, jsonSearchMap.get("releaseDate"));
        }
        if (!jsonSearchMap.get("mpaaRating").isEmpty()) {
            criteria.put(SearchTerm.MPAA_RATING, jsonSearchMap.get("mpaaRating"));
        }
        if (!jsonSearchMap.get("director").isEmpty()) {
            criteria.put(SearchTerm.DIRECTOR, jsonSearchMap.get("director"));
        }
        if (!jsonSearchMap.get("studio").isEmpty()) {
            criteria.put(SearchTerm.STUDIO, jsonSearchMap.get("studio"));
        }
        if (!jsonSearchMap.get("note").isEmpty()) {
            criteria.put(SearchTerm.NOTE, jsonSearchMap.get("note"));
        }

        return dao.searchDvds(criteria);
    }

    @RequestMapping(value = "/searchEdit", method = RequestMethod.POST)
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

        return "search";
    }
    
    @RequestMapping(value = "/searchDelete", method = RequestMethod.POST)
    public String homeDelete(HttpServletRequest request){
        int removeId = Integer.parseInt(request.getParameter("id"));
        
        dao.remove(removeId);
        
        return "search";
    }
}
