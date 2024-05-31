package pl.technicalsite.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(value = "*")
public class LoginWebController {

    @GetMapping("/")
    public String mainDasboard() {
        return "/mainDasboard/index.html";
    }

    @GetMapping("/newDasboard")
    public String newDasboard() {
        return "/newDasboard/index.html";
    }

    @GetMapping("/loadMapping")
    public String loadMapping() {
        return "/loadMapping/index.html";
    }

    @GetMapping("/login")
    public String homePage() {
        return "loginPage";
    }

}
