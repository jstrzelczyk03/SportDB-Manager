package bdbt_bada_project.SpringApplication;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DyscyplinaKontroler {
    @Autowired
    private DyscyplinaRepozytorium repo;

    @GetMapping("/dyscypliny")
    public String listaDyscyplin(Model model){
        List<Category> listaDyscyplin = repo.findAll();
        model.addAttribute("listaDyscypplin", listaDyscyplin);

        return "dyscypliny";
    }

}
