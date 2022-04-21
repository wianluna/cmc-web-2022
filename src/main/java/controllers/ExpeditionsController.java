package controllers;

import dao.ExpeditionsDAO;
import dao.MineralSpecimensDAO;
import models.Expeditions;
import models.MineralSpecimens;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.MineralSpecimensService;

import java.sql.Date;
import java.util.List;

@Controller
public class ExpeditionsController {
    private ExpeditionsDAO expeditionDao = new ExpeditionsDAO();

    @GetMapping("/expeditions")
    public String expeditions(Model model) {
        List<Expeditions> objects = expeditionDao.getAll(Expeditions.class);
        model.addAttribute("objects", objects);
        return "expeditions";
    }

    @GetMapping("/expeditions/{expedition_id}")
    public String expeditionsDetails(@PathVariable(value = "expedition_id") Long expeditionId,
                                   Model model) {
        Expeditions object = expeditionDao.getById(Expeditions.class, expeditionId);

        if (object == null) {
            return "redirect:/expeditions";
        }
        model.addAttribute("object", object);
        return "expeditions-details";
    }

    @PostMapping("/expeditions/{expedition_id}/specimens")
    public String expeditionsSpecimens(@PathVariable(value = "expedition_id") Long expeditionId,
                                     Model model) {
        MineralSpecimensService specimensService = new MineralSpecimensService();

        Expeditions object = expeditionDao.getById(Expeditions.class, expeditionId);
        if (object == null) {
            return "redirect:/expeditions";
        }

        List<MineralSpecimens> objects = specimensService.getByExpedition(expeditionId);
        model.addAttribute("objects", objects);
        return "home";
    }

    @GetMapping("/expeditions/{expedition_id}/edit")
    public String expeditionsEdit(@PathVariable(value = "expedition_id") Long expeditionId,
                                Model model) {
        Expeditions object = expeditionDao.getById(Expeditions.class, expeditionId);

        if (object == null) {
            return "redirect:/expeditions";
        }
        model.addAttribute("object", object);
        return "expeditions-edit";
    }

    @PostMapping("/expeditions/{expedition_id}/edit")
    public String expeditionsUpdate(@PathVariable(value = "expedition_id") Long expeditionId,
                                    @RequestParam(name = "date_start") String dateStart,
                                    @RequestParam(name = "date_end") String dateEnd,
                                    @RequestParam(name = "members") String members,
                                    @RequestParam(name = "description") String description,
                                    Model model) {
        Expeditions object = expeditionDao.getById(Expeditions.class, expeditionId);

        if (object == null) {
            return "redirect:/expeditions";
        }

        object.setDateStart(Date.valueOf(dateStart));
        object.setDateEnd(Date.valueOf(dateEnd));
        object.setMembers(members);
        object.setDescription(description);
        expeditionDao.update(object);

        return "redirect:/expeditions";
    }

    @PostMapping("/expeditions/{expedition_id}/remove")
    public String expeditionsDelete(@PathVariable(value = "expedition_id") Long expeditionId,
                                  Model model) {
        Expeditions object = expeditionDao.getById(Expeditions.class, expeditionId);

        if (object == null) {
            return "redirect:/expeditions";
        }

        expeditionDao.remove(object);
        return "redirect:/expeditions";
    }

    @GetMapping("/expeditions/add")
    public String expeditionsAdd(Model model) {
        return "expeditions-add";
    }

    @PostMapping("/expeditions/add")
    public String expeditionsSave(@RequestParam(name = "date_start") String dateStart,
                                @RequestParam(name = "date_end") String dateEnd,
                                @RequestParam(name = "members") String members,
                                @RequestParam(name = "description") String description,
                                Model model) {
        Expeditions object = new Expeditions(Date.valueOf(dateStart), Date.valueOf(dateEnd), members, description);
        expeditionDao.create(object);
        return "redirect:/expeditions";
    }
}