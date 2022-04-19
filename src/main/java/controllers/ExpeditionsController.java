package controllers;

import dao.ExpeditionsDAO;
import models.Expeditions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExpeditionsController {
    private ExpeditionsDAO expeditionDao = new ExpeditionsDAO();

    @GetMapping("/expeditions")
    public String mineral(Model model) {
        List<Expeditions> objects = expeditionDao.getAll(Expeditions.class);
        model.addAttribute("objects", objects);
        return "expeditions";
    }

    @GetMapping("/expeditions/add")
    public String expeditionsAdd(Model model) {
        return "expeditions-add";
    }
}