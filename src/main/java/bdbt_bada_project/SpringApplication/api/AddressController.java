package bdbt_bada_project.SpringApplication.api;

import bdbt_bada_project.SpringApplication.entity.Address;
import bdbt_bada_project.SpringApplication.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AddressController {

    private final AddressRepository addressRepo;

    @GetMapping("/addresses")
    public String addressesList(Model model){
        List<Address> addressesList = addressRepo.findAll();
        model.addAttribute("addressesList", addressesList);
        return "addresses";
    }

    @GetMapping("/addresses/add")
    public String showNewDisciplineForm(Model model){
        model.addAttribute("address", new Address());
        return "addressAdd";
    }

    @GetMapping("/addresses/edit/{addressId}")
    public String showEditAddressForm(@PathVariable("addressId") Integer addressId, Model model){
        Address address = addressRepo.findById(addressId).get();
        model.addAttribute("address", address);
        return "addressAdd";
    }

    @GetMapping("/addresses/delete/{addressId}")
    public String deleteAddress(@PathVariable("addressId") Integer addressId, Model model){
        addressRepo.deleteById(addressId);
        return "redirect:/addresses";
    }

    @PostMapping("/addresses/save")
    public String saveDiscipline(Address address){
        addressRepo.save(address);
        return "redirect:/addresses";
    }

}
