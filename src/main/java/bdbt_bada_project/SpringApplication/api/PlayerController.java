package bdbt_bada_project.SpringApplication.api;

import bdbt_bada_project.SpringApplication.entity.Address;
import bdbt_bada_project.SpringApplication.entity.Discipline;
import bdbt_bada_project.SpringApplication.entity.Player;
import bdbt_bada_project.SpringApplication.repository.AddressRepository;
import bdbt_bada_project.SpringApplication.repository.DisciplineRepository;
import bdbt_bada_project.SpringApplication.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository playerRepo;
    private final AddressRepository addressRepo;
    private final DisciplineRepository disciplineRepo;

    @GetMapping("/players")
    public String playersList(Model model){
        List<Player> playersList = playerRepo.findAll();
        model.addAttribute("playersList", playersList);
        return "players";
    }

    @GetMapping("/players/add")
    public String showNewPlayerForm(Model model){
        List<Address> addressList = addressRepo.findAll();
        List<Discipline> disciplineList = disciplineRepo.findAll();
        model.addAttribute("player", new Player());
        model.addAttribute("addressList", addressList);
        model.addAttribute("disciplineList", disciplineList);
        return "playerAdd";
    }

    @GetMapping("/players/edit/{playerId}")
    public String showEditPlayerForm(@PathVariable("playerId") Integer playerId, Model model){
        Player player = playerRepo.findById(playerId).get();
        model.addAttribute("player", player);

        List<Address> addressList = addressRepo.findAll();
        List<Discipline> disciplineList = disciplineRepo.findAll();
        model.addAttribute("addressList", addressList);
        model.addAttribute("disciplineList", disciplineList);
        return "playerAdd";
    }

    @GetMapping("/players/delete/{playerId}")
    public String deletePlayer(@PathVariable("playerId") Integer playerId, Model model){
        playerRepo.deleteById(playerId);
        return "redirect:/players";
    }

    @PostMapping("/players/save")
    public String savePlayer(Player player){
        playerRepo.save(player);
        return "redirect:/players";
    }

}
