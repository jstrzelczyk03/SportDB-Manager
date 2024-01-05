package bdbt_bada_project.SpringApplication.api;

import bdbt_bada_project.SpringApplication.entity.Discipline;
import bdbt_bada_project.SpringApplication.entity.Place;
import bdbt_bada_project.SpringApplication.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceRepository repo;

    @GetMapping("/places")
    public String placesList(Model model){
        List<Place> placesList = repo.findAll();
        model.addAttribute("placesList", placesList);
        return "places";
    }


    @GetMapping("/places/add")
    public String showPlaceNewForm(Model model){
        model.addAttribute("place", new Place());
        return "placeAdd";
    }


    @PostMapping("/places/save")
    public String savePlace(Place place){
        repo.save(place);
        return "redirect:/places";
    }

}
