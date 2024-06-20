package pl.technicalsite.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(value = "*")
public class LoginWebController {

    @GetMapping("/")
    public String mainDashboard() {
        return "mainDashboard.html";
    }

    @GetMapping("/newDashboard")
    public String newDashboard() {
        return "newDashboard.html";
    }

    @GetMapping("/loadMapping")
    public String loadMapping() {
        return "loadMapping.html";
    }

    @GetMapping("/login")
    public String homePage() {
        return "loginPage";
    }

}
