package bdbt_bada_project.SpringApplication.api;

import bdbt_bada_project.SpringApplication.entity.Discipline;
import bdbt_bada_project.SpringApplication.repository.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DisciplineController {

    private final DisciplineRepository disciplineRepo;

    @GetMapping("/disciplines")
    public String disciplinesList(Model model){
        List<Discipline> disciplinesList = disciplineRepo.findAll();
        model.addAttribute("disciplinesList", disciplinesList);
        return "disciplines";
    }

    @GetMapping("/disciplines/add")
    public String showNewDisciplineForm(Model model){
        model.addAttribute("discipline", new Discipline());
        return "disciplineAdd";
    }

    @GetMapping("/disciplines/edit/{disciplineId}")
    public String showEditDisciplineForm(@PathVariable("disciplineId") Integer disciplineId, Model model){
        Discipline discipline = disciplineRepo.findById(disciplineId).get();
        model.addAttribute("discipline", discipline);
        return "disciplineAdd";
    }
    @GetMapping("/disciplines/delete/{disciplineId}")
    public String deleteDiscipline(@PathVariable("disciplineId") Integer disciplineId, Model model){
        try{
            disciplineRepo.deleteById(disciplineId);
            return "redirect:/disciplines";
        }
        catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Naruszono więzy spójności");
            return "errors/ora02292";
        }
    }

    @PostMapping("/disciplines/save")
    public String saveDiscipline(Discipline discipline){
        disciplineRepo.save(discipline);
        return "redirect:/disciplines";
    }

}
