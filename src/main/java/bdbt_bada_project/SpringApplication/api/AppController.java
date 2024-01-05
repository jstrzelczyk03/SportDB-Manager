package bdbt_bada_project.SpringApplication.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

}


//import bdbt_bada_project.SpringApplication.Poczty.Poczta;
//import bdbt_bada_project.SpringApplication.Poczty.PocztyDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@Controller
//public class AppController implements WebMvcConfigurer {
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("index1");
//        registry.addViewController("/").setViewName("index1");
//        registry.addViewController("/main").setViewName("main");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/poczty").setViewName("poczty");
//
//        registry.addViewController("/main_administrator").setViewName("administrator/main_administrator");
//        registry.addViewController("/main_trener").setViewName("trener/main_trener");
//        registry.addViewController("/main_zawodnik").setViewName("zawodnik/main_zawodnik");
//
//    }
//    @GetMapping("")
//    public String viewHomePage(){
//        return "index1";
//    }
//
//    @Controller
//    public class DashboardController
//    {
//        @RequestMapping
//                ("/main"
//                )
//        public String defaultAfterLogin
//                (HttpServletRequest request) {
//            if
//            (request.isUserInRole
//                    ("ADMINISTRATOR")) {
//                return "redirect:/main_administrator";
//            }
//            else if
//            (request.isUserInRole
//                            ("TRENER")) {
//                return "redirect:/main_trener";
//            }
//            else if
//            (request.isUserInRole
//                            ("ZAWODNIK")) {
//                return "redirect:/main_zawodnik";
//            }
//            else
//            {
//                return "redirect:/index";
//            }
//        }
//    }
//
//    @RequestMapping(value={"/main_administrator"})
//    public String showAdministratorPage(Model model) {
//        return "administrator/main_administrator";
//    }
//    @RequestMapping(value={"/main_trener"})
//    public String showTrenerPage(Model model) {
//        return "trener/main_trener";
//    }
//    @RequestMapping(value={"/main_zawodnik"})
//    public String showZawodnikPage(Model model) {
//        return "zawodnik/main_zawodnik";
//    }
//
//    @Autowired
//    private PocztyDAO dao;
//
//    @RequestMapping("/")
//    public String viewHomePage(Model model){
//        /* Import java.util.List */
//        List<Poczta> listPoczta = dao.list();
//        model.addAttribute("listPoczta", listPoczta);
//        return "index1";
//    }
//
//
//
//}