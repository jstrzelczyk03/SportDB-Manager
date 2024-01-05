package bdbt_bada_project.SpringApplication.api;

import bdbt_bada_project.SpringApplication.entity.Player;
import bdbt_bada_project.SpringApplication.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository playerRepo;

    @GetMapping("/players")
    public String playersList(Model model){
        List<Player> playersList = playerRepo.findAll();
        model.addAttribute("playersList", playersList);
        return "players";
    }

    @GetMapping("/players/add")
    public String showPlayerNewForm(Model model){
        model.addAttribute("player", new Player());
        return "playerAdd";
    }

    @PostMapping("/players/save")
    public String savePlayer(Player player){
        playerRepo.save(player);
        return "redirect:/players";
    }

}
