package bdbt_bada_project.SpringApplication.api;

import bdbt_bada_project.SpringApplication.entity.Address;
import bdbt_bada_project.SpringApplication.entity.Discipline;
import bdbt_bada_project.SpringApplication.entity.Trainer;
import bdbt_bada_project.SpringApplication.repository.AddressRepository;
import bdbt_bada_project.SpringApplication.repository.DisciplineRepository;
import bdbt_bada_project.SpringApplication.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerRepository trainerRepo;
    private final AddressRepository addressRepo;
    private final DisciplineRepository disciplineRepo;

    @GetMapping("/trainers")
    public String trainersList(Model model){
        List<Trainer> trainersList = trainerRepo.findAll();
        model.addAttribute("trainersList", trainersList);
        return "trainers";
    }

    @GetMapping("/trainers/add")
    public String showTrainerNewForm(Model model){
        List<Address> addressList = addressRepo.findAll();
        List<Discipline> disciplineList = disciplineRepo.findAll();
        model.addAttribute("trainer", new Trainer());
        model.addAttribute("addressList", addressList);
        model.addAttribute("disciplineList", disciplineList);
        return "trainerAdd";
    }

    @PostMapping("/trainers/save")
    public String saveTrainer(Trainer trainer){
        trainerRepo.save(trainer);
        return "redirect:/trainers";
    }

}
