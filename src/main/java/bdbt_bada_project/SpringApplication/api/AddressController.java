package bdbt_bada_project.SpringApplication.api;

import bdbt_bada_project.SpringApplication.entity.Address;
import bdbt_bada_project.SpringApplication.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AddressController {

    private final AddressRepository repo;

    @GetMapping("/addresses")
    public String addressesList(Model model){
        List<Address> addressesList = repo.findAll();
        model.addAttribute("addressesList", addressesList);
        return "addresses";
    }

    @GetMapping("/addresses/add")
    public String showDisciplineNewForm(Model model){
        model.addAttribute("address", new Address());
        return "addressAdd";
    }



    @PostMapping("/addresses/save")
    public String saveDiscipline(Address address){
        repo.save(address);
        return "redirect:/addresses";
    }

}
