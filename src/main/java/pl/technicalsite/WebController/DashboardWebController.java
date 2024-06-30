package pl.technicalsite.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import pl.technicalsite.AppConfig.AppConfig;
import pl.technicalsite.AppConfig.AppVersionResponse;

@Controller
@CrossOrigin(value = "*")
public class DashboardWebController {

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

    @GetMapping("/applicationVersion")
    public AppVersionResponse applicationVersion() {
        AppVersionResponse appVersion = new AppVersionResponse();
        appVersion.setAppVersion(AppConfig.APP_VERSION);
        return appVersion;
    }

    @GetMapping("/previousApplicationVersion")
    public AppVersionResponse previousApplicationVersion() {
        AppVersionResponse appVersion = new AppVersionResponse();
        appVersion.setAppVersion(AppConfig.OLD_APP_VERSION);
        return appVersion;
    }

}
