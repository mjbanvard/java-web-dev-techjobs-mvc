package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    // <form th:action="@{/search/results}" method = "post">

    @RequestMapping(value = "search")
    public ArrayList<Job> displaySearchResults(Model model, String searchType, String searchTerm) {
        if (searchTerm == "all" || searchTerm == "") {
            ArrayList<Job> jobs = JobData.findAll();
            return jobs;
        } else {
            ArrayList<Job> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            return jobs;
        }
        search(Model model)
    }

}
