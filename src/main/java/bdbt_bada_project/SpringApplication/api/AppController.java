package bdbt_bada_project.SpringApplication.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

//@Controller
//public class AppController {
//    @GetMapping("")
//    public String viewHomePage(){
//        return "index";
//    }
//
//}

@Controller
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/contact").setViewName("contact");

        registry.addViewController("/main_administrator").setViewName("administrator/main_administrator");
        registry.addViewController("/main_trener").setViewName("trener/main_trener");
        registry.addViewController("/main_zawodnik").setViewName("zawodnik/main_zawodnik");

    }
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @Controller
    public class DashboardController
    {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMINISTRATOR")) {
                return "redirect:/main_administrator";
            }
            else if
            (request.isUserInRole
                            ("TRENER")) {
                return "redirect:/main_trener";
            }
            else if
            (request.isUserInRole
                            ("ZAWODNIK")) {
                return "redirect:/main_zawodnik";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value={"/main_administrator"})
    public String showAdministratorPage(Model model) {
        return "administrator/main_administrator";
    }
    @RequestMapping(value={"/main_trener"})
    public String showTrenerPage(Model model) {
        return "trener/main_trener";
    }
    @RequestMapping(value={"/main_zawodnik"})
    public String showZawodnikPage(Model model) {
        return "zawodnik/main_zawodnik";
    }

}