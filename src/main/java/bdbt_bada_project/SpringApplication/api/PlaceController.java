package bdbt_bada_project.SpringApplication.api;

import bdbt_bada_project.SpringApplication.entity.Address;
import bdbt_bada_project.SpringApplication.entity.Place;
import bdbt_bada_project.SpringApplication.repository.AddressRepository;
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

    private final PlaceRepository placeRepo;

    private final AddressRepository addressRepo;

    @GetMapping("/places")
    public String placesList(Model model){
        List<Place> placesList = placeRepo.findAll();
        model.addAttribute("placesList", placesList);
        return "places";
    }


    @GetMapping("/places/add")
    public String showPlaceNewForm(Model model){
        List<Address> addressList = addressRepo.findAll();
        model.addAttribute("place", new Place());
        model.addAttribute("addressList", addressList);
        return "placeAdd";
    }


    @PostMapping("/places/save")
    public String savePlace(Place place){
        placeRepo.save(place);

        return "redirect:/places";
    }

}
