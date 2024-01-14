package bdbt_bada_project.SpringApplication.api;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
@Controller
public class MyErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return "errors/403";
            }
            else if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "errors/404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "errors/500";
            }
            else if(statusCode == HttpStatus.GATEWAY_TIMEOUT.value()) {
                return "errors/504";
            }else {
                return "errors/other";
            }
        }
        return "errors/other";
    }
    @RequestMapping ("/logout")
    public String logout(HttpServletRequest request, Model model) {
        // Your existing logout logic

        // Check if the timeout parameter is present
        String timeoutParam = request.getParameter("timeout");
        if ("true".equals(timeoutParam)) {
            model.addAttribute("timeoutMessage", "Zostałeś wylogowany z powodu zbyt długiego czasu bezczynności.");
        }

        return "redirect:/login"; // Redirect to the login page or any other page
    }
}
