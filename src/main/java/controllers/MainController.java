package controllers;

import dao.MineralSpecimensDAO;
import models.MineralSpecimens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    private MineralSpecimensDAO objectDAO = new MineralSpecimensDAO();

    @GetMapping("/")
    public String home(Model model) {
        List<MineralSpecimens> objects = objectDAO.getAll(MineralSpecimens.class);
        model.addAttribute("objects", objects);
        return "home";
    }

    @GetMapping("/specimens/add")
    public String specimensAdd(Model model) {
        return "specimens-add";
    }

    @PostMapping("/specimens/add")
    public String specimensSave(@RequestParam(required = false) Long specimens_id,
                                   @RequestParam String possibleOrigin,
                                   @RequestParam String source,
                                   @RequestParam String location,
                                   @RequestParam String coordinates,
                                   @RequestParam Long expeditionId,
                                   Model model) {
        MineralSpecimens object = null;
        MineralSpecimensDAO objectDAO = new MineralSpecimensDAO();

        if (specimens_id != null) {
            object = objectDAO.getById(MineralSpecimens.class, specimens_id);
            if (object != null) {
                object.setPossibleOrigin(possibleOrigin);
                object.setSource(source);
                object.setCoordinates(coordinates);
                object.setLocation(location);
                object.setExpeditionId(expeditionId);
                objectDAO.update(object);
            }
        }

        if (object == null) {
            object = new MineralSpecimens(possibleOrigin, source, location, coordinates, expeditionId);
            objectDAO.create(object);
        }

        return String.format("redirect:/specimens?specimens_id=%d", object.getId());
    }

}
