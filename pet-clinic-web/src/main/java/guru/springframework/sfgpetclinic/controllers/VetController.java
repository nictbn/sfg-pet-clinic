package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {
        Set<Vet> vets = vetService.findAll();
        System.out.println(vets.size());
        vets.forEach((vet) -> {
            System.out.print(vet.getFirstName());
            System.out.print(vet.getLastName());
            System.out.print(vet.getId());
            System.out.println();
        });
        model.addAttribute("vets", vets);
        return "vets/index";
    }
}
