package bdbt_bada_project.SpringApplication;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DyscyplinaKontroler {
    @Autowired
    private DyscyplinaRepozytorium repo;

    @GetMapping("/dyscypliny")
    public String listaDyscyplin(Model model){
        List<Dyscyplina> listaDyscyplin = repo.findAll();
        model.addAttribute("listaDyscyplin", listaDyscyplin);

        return "dyscypliny";
    }

    @GetMapping("/dyscypliny/dodaj")
    public String showDyscyplinaNewForm(Model model){
        model.addAttribute("dyscyplina", new Dyscyplina());
        return "dyscyplina_dodaj";
    }

    @PostMapping("/dyscypliny/zapisz")
    public String zapiszDyscyplinę(Dyscyplina dyscyplina){
        repo.save(dyscyplina);
        return "redirect:/dyscypliny";
    }

}
