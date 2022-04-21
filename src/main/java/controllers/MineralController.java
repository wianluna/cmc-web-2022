package controllers;

import dao.MineralSpeciesDAO;
import dao.MineralSpecimensDAO;
import dao.PhysicalPropertiesDAO;
import models.MineralSpecies;
import models.MineralSpecimens;
import models.PhysicalProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.MineralSpeciesServices;
import services.MineralSpecimensService;

import java.util.List;

@Controller
public class MineralController {
    private MineralSpeciesDAO mineralDAO = new MineralSpeciesDAO();
    private PhysicalPropertiesDAO propertiesDAO = new PhysicalPropertiesDAO();
    private MineralSpeciesServices mineralSpeciesServices = new MineralSpeciesServices();
    
    @GetMapping("/minerals")
    public String minerals(Model model) {
        List<MineralSpecies> objects = mineralDAO.getAll(MineralSpecies.class);
        model.addAttribute("objects", objects);
        return "minerals";
    }

    @PostMapping("/minerals")
    public String mineralsSearch(@RequestParam(name = "species_name", required = false) String speciesName,
                                 Model model) {
        List<MineralSpecies> objects = mineralSpeciesServices.getBySpeciesName(speciesName);
        model.addAttribute("objects", objects);
        return "minerals";
    }

    @GetMapping("/minerals/{minerals_id}")
    public String mineralsDetails(@PathVariable(value = "minerals_id") Long mineralsId,
                                   Model model) {
        MineralSpecies object = mineralDAO.getById(MineralSpecies.class, mineralsId);
        PhysicalProperties properties = propertiesDAO.getById(PhysicalProperties.class, mineralsId);
        if (object == null) {
            return "redirect:/minerals";
        }
        model.addAttribute("object", object);
        model.addAttribute("properties", properties);
        return "minerals-details";
    }

    @PostMapping("/minerals/{species_id}/specimens")
    public String mineralsSpecimens(@PathVariable(value = "species_id") Long speciesId,
                                       Model model) {
        MineralSpecimensService specimensService = new MineralSpecimensService();

        MineralSpecies object = mineralDAO.getById(MineralSpecies.class, speciesId);
        if (object == null) {
            return "redirect:/minerals";
        }

        List<MineralSpecimens> objects = specimensService.getBySpecies(speciesId);
        model.addAttribute("objects", objects);
        return "home";
    }

    @GetMapping("/minerals/{minerals_id}/edit")
    public String mineralsEdit(@PathVariable(value = "minerals_id") Long speciesId,
                                Model model) {
        MineralSpecies object = mineralDAO.getById(MineralSpecies.class, speciesId);
        PhysicalProperties properties = propertiesDAO.getById(PhysicalProperties.class, speciesId);
        if (object == null || properties == null) {
            return "redirect:/minerals";
        }
        model.addAttribute("object", object);
        model.addAttribute("properties", properties);
        return "minerals-edit";
    }

    @PostMapping("/minerals/{minerals_id}/edit")
    public String mineralsUpdate(@PathVariable(value = "minerals_id") Long speciesId,
                                  @RequestParam(name = "species_name") String speciesName,
                                  @RequestParam(name = "chemical_formula") String chemicalFormula,
                                  @RequestParam(name = "origin") String origin,
                                  @RequestParam(name = "lattice_type") String latticeType,
                                  @RequestParam(name = "hardness") float hardness,
                                  @RequestParam(name = "lustre") String lustre,
                                  @RequestParam(name = "color") String color,
                                  @RequestParam(name = "magnetism") String magnetism,
                                  Model model) {
        MineralSpecies object = mineralDAO.getById(MineralSpecies.class, speciesId);
        PhysicalProperties properties = propertiesDAO.getById(PhysicalProperties.class, speciesId);

        if (object == null || properties == null) {
            return "redirect:/minerals";
        }

        object.setSpeciesName(speciesName);
        object.setChemicalFormula(chemicalFormula);
        object.setOrigin(origin);
        object.setClassId(1L);
        mineralDAO.update(object);

        properties.setColor(color);
        properties.setHardness(hardness);
        properties.setLatticeType(latticeType);
        properties.setLustre(lustre);
        properties.setMagnetism(magnetism);
        propertiesDAO.update(properties);

        return "redirect:/minerals";
    }

    @PostMapping("/minerals/{species_id}/remove")
    public String mineralsDelete(@PathVariable(value = "species_id") Long speciesId,
                                  Model model) {
        MineralSpecies object = mineralDAO.getById(MineralSpecies.class, speciesId);
        PhysicalProperties properties = propertiesDAO.getById(PhysicalProperties.class, speciesId);

        if (object == null || properties == null) {
            return "redirect:/minerals";
        }

        mineralDAO.remove(object);
        propertiesDAO.remove(properties);
        return "redirect:/minerals";
    }

    @GetMapping("/minerals/add")
    public String mineralsAdd(Model model) {
        return "minerals-add";
    }

    @PostMapping("/minerals/add")
    public String mineralsSave(@RequestParam(name = "species_name") String speciesName,
                                @RequestParam(name = "chemical_formula") String chemicalFormula,
                                @RequestParam(name = "origin") String origin,
                                @RequestParam(name = "lattice_type") String latticeType,
                                @RequestParam(name = "hardness") float hardness,
                                @RequestParam(name = "lustre") String lustre,
                                @RequestParam(name = "color") String color,
                                @RequestParam(name = "magnetism") String magnetism,
                                Model model) {
        MineralSpecies object = new MineralSpecies(speciesName, chemicalFormula, origin, 1L);
        mineralDAO.create(object);
        PhysicalProperties properties = new PhysicalProperties(object.getId(), latticeType, hardness, lustre, color, magnetism);
        propertiesDAO.create(properties);
        return "redirect:/minerals";
    }
}