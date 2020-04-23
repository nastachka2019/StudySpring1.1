package com.company.sh.controller;

import com.company.sh.model.Composition;
import com.company.sh.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping ("/songs")
public class CompositionController {
    @Autowired
    private CompositionService compositionService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMovies(Model model) {
        List<Composition> compositions = compositionService.getAllCompositions();
        model.addAttribute("songs", compositions);
        return "allSongs";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable Integer id, Model model) {
        Composition composition=compositionService.findComposition(id);
        model.addAttribute("song", composition);
        return "selectedSong";
    }
}
