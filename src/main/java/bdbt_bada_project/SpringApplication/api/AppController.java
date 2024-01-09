package bdbt_bada_project.SpringApplication.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/contact").setViewName("contact");

        registry.addViewController("/mainAdmin").setViewName("admin/mainAdmin");
        registry.addViewController("/mainTrainer").setViewName("trainer/mainTrainer");
        registry.addViewController("/mainPlayer").setViewName("player/mainPlayer");

    }
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMINISTRATOR")) {
                System.out.println("Użytkownik ma rolę ADMINISTRATOR");
                return "redirect:/mainAdmin";
            } else if (request.isUserInRole("TRENER")) {
                System.out.println("Użytkownik ma rolę TRENER");
                return "redirect:/mainTrainer";
            } else if (request.isUserInRole("ZAWODNIK")) {
                System.out.println("Użytkownik ma rolę ZAWODNIK");
                return "redirect:/mainPlayer";
            } else {
                System.out.println("Użytkownik nie ma rozpoznanej roli");
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value={"/mainAdmin"})
    public String showAdminPage(Model model) {
        return "admin/mainAdmin";
    }
    @RequestMapping(value={"/mainTrainer"})
    public String showTrainerPage(Model model) {
        return "trainer/mainTrainer";
    }
    @RequestMapping(value={"/mainPlayer"})
    public String showPlayerPage(Model model) {
        return "player/mainPlayer";
    }



}