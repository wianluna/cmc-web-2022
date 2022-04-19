package controllers;

import dao.MineralSpeciesDAO;
import dao.MineralSpecimensDAO;
import models.MineralSpecies;
import models.MineralSpecimens;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MineralController {
    private MineralSpeciesDAO mineralDAO = new MineralSpeciesDAO();

    @GetMapping("/minerals")
    public String mineral(Model model) {
        List<MineralSpecies> objects = mineralDAO.getAll(MineralSpecies.class);
        model.addAttribute("objects", objects);
        return "minerals";
    }

    @GetMapping("/minerals/add")
    public String mineralsAdd(Model model) {
        return "minerals-add";
    }
}