package pl.technicalsite.WebController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.technicalsite.AppConfig.AppConfig;
import pl.technicalsite.AppConfig.AppVersionResponse;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.MappingsType;
import pl.technicalsite.FileService.FileReaderService;
import pl.technicalsite.FileService.FileServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@CrossOrigin(value = "*")
public class WebController {

    private final FileServiceImpl fileServiceImpl;
    private final FileReaderService fileReaderService;

    public WebController(FileServiceImpl fileServiceImpl, FileReaderService fileReaderService) {
        this.fileServiceImpl = fileServiceImpl;
        this.fileReaderService = fileReaderService;
    }

    @GetMapping("/login")
    public String homePage() {
        return "loginPage";
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody @Valid FileDto fileDto) {
        if (fileDto.getFieldsDto().getId() == null || fileDto.getFieldsDto().getId().isBlank()) {
            return ResponseEntity.badRequest().body("The ID field value cannot be empty");
        }
        Optional<String> result = Optional.ofNullable(fileServiceImpl.createFile(fileDto));
        return result.map(stringStringMap -> ResponseEntity.ok().body(stringStringMap))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/applicationVersion")
    @ResponseBody
    public AppVersionResponse applicationVersion() {
        AppVersionResponse appVersion = new AppVersionResponse();
        appVersion.setAppVersion(AppConfig.APP_VERSION);
        return appVersion;
    }

    @GetMapping("/previousApplicationVersion")
    @ResponseBody
    public AppVersionResponse previousApplicationVersion() {
        AppVersionResponse appVersion = new AppVersionResponse();
        appVersion.setAppVersion(AppConfig.OLD_APP_VERSION);
        return appVersion;
    }

    @PostMapping("/readFromFile")
    @ResponseBody
    public ResponseEntity<Map<String, String>> readFieldsFromFile(@RequestBody String xslFile) {
        Optional<Map<String, String>> resultOptional = Optional.ofNullable(fileReaderService.readFromXsl(xslFile));
        return resultOptional.map(stringStringMap -> ResponseEntity.ok().body(stringStringMap))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/structures")
    @ResponseBody
    public List<String> getAvailableStructure() {
        return MappingsType.listOfAvailableStructure;
    }

}