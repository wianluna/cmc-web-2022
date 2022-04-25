package controllers;

import dao.MineralSpecimensDAO;
import dao.SpecimensCompositionDAO;
import models.MineralSpecimens;
import models.SpecimensComposition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.CompositionService;
import services.MineralSpecimensService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private MineralSpecimensDAO objectDAO = new MineralSpecimensDAO();
    private MineralSpecimensService objectService = new MineralSpecimensService();
    private CompositionService compositionService = new CompositionService();
    private SpecimensCompositionDAO specimensCompositionDAO = new SpecimensCompositionDAO();

    @GetMapping("/")
    public String home(Model model) {
        List<MineralSpecimens> objects = objectDAO.getAll(MineralSpecimens.class);
        model.addAttribute("objects", objects);
        return "home";
    }

    @PostMapping("/")
    public String specimensSearch(@RequestParam(name = "specimens_id", required = false) String specimensId,
                                  @RequestParam(name = "possible_origin") String possibleOrigin,
                                  @RequestParam(name = "source") String source,
                                  Model model) {
        List<MineralSpecimens> res = new ArrayList<>();
        if (!specimensId.isEmpty()) {
            MineralSpecimens object = objectDAO.getById(MineralSpecimens.class, Long.valueOf(specimensId));
            if (object != null) {
                res.add(object);
            }
        } else {
            if (source.isEmpty()) {
                source = null;
            }
            if (possibleOrigin.isEmpty()) {
                possibleOrigin = null;
            }
            List<MineralSpecimens> objects = objectService.getBySourceAndOrigin(source, possibleOrigin);
            res.addAll(objects);
        }
        model.addAttribute("objects", res);
        return "home";
    }

    @GetMapping("/specimens/{specimens_id}")
    public String specimensDetails(@PathVariable(value = "specimens_id") Long specimensId,
                                   Model model) {
        List<SpecimensComposition> composition = compositionService.getBySpecimenId(specimensId);
        model.addAttribute("composition", composition);

        MineralSpecimens object = objectDAO.getById(MineralSpecimens.class, specimensId);
        model.addAttribute("object", object);

        if (object == null) {
            return "redirect:/";
        }
        return "specimens-details";
    }

    @GetMapping("/specimens/{specimens_id}/edit")
    public String specimensEdit(@PathVariable(value = "specimens_id") Long specimensId,
                                   Model model) {
        MineralSpecimens object = objectDAO.getById(MineralSpecimens.class, specimensId);

        if (object == null) {
            return "redirect:/";
        }
        model.addAttribute("object", object);
        return "specimens-edit";
    }

    @PostMapping("/specimens/{specimens_id}/edit")
    public String specimensUpdate(@PathVariable(value = "specimens_id") Long specimensId,
                                  @RequestParam(name = "possible_origin") String possibleOrigin,
                                  @RequestParam(name = "source") String source,
                                  @RequestParam(name = "location") String location,
                                  @RequestParam(name = "coordinates") String coordinates,
                                  @RequestParam(name = "expedition_id") Long expeditionId,
                                  Model model) {
        MineralSpecimens object = objectDAO.getById(MineralSpecimens.class, specimensId);

        if (object == null) {
            return "redirect:/";
        }

        object.setPossibleOrigin(possibleOrigin);
        object.setSource(source);
        object.setCoordinates(coordinates);
        object.setLocation(location);
        if (expeditionId != null) {
            object.setExpeditionId(expeditionId);
        }
        objectDAO.update(object);

        return "redirect:/";
    }

    @PostMapping("/specimens/{specimens_id}/remove")
    public String specimensDelete(@PathVariable(value = "specimens_id") Long specimensId,
                                Model model) {
        MineralSpecimens object = objectDAO.getById(MineralSpecimens.class, specimensId);

        if (object == null) {
            return "redirect:/";
        }

        objectDAO.remove(object);
        return "redirect:/";
    }

    @GetMapping("/specimens/add")
    public String specimensAdd(Model model) {
        return "specimens-add";
    }

    @PostMapping("/specimens/add")
    public String specimensSave(@RequestParam(name = "possible_origin") String possibleOrigin,
                                   @RequestParam(name = "source") String source,
                                   @RequestParam(name = "location") String location,
                                   @RequestParam(name = "coordinates") String coordinates,
                                   @RequestParam(name = "expedition_id") Long expeditionId,
                                   Model model) {
        MineralSpecimensDAO objectDAO = new MineralSpecimensDAO();

        MineralSpecimens object = new MineralSpecimens(possibleOrigin, location, coordinates, source, expeditionId);
        objectDAO.create(object);

        return "redirect:/";
    }

    @PostMapping("/specimens/{specimens_id}/add_composition")
    public String specimenCompositionAdd(@PathVariable(value = "specimens_id") Long specimensId,
                                         @RequestParam(name = "species_name") String speciesName,
                                         @RequestParam(name = "species_id") Long speciesId,
                                         @RequestParam(name = "inclusion_type") String inclusionType,
                                         @RequestParam(name = "percentage") float percentage,
                                         Model model) {
        SpecimensComposition object = new SpecimensComposition(specimensId, speciesId, speciesName,
                inclusionType, percentage);

        specimensCompositionDAO.create(object);
        return String.format("redirect:/specimens/%d", specimensId);
    }

    @PostMapping("/specimens/{specimens_id}/remove_composition/{species_id}")
    public String specimenCompositionDelete(@PathVariable(value = "specimens_id") Long specimensId,
                                            @PathVariable(value = "species_id") Long speciesId,
                                            Model model) {
        SpecimensComposition object = specimensCompositionDAO.getById(specimensId, speciesId);
        specimensCompositionDAO.remove(object);

        return String.format("redirect:/specimens/%d", specimensId);
    }
}
