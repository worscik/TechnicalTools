package pl.technicalsite.WebController;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.technicalsite.AppConfig.AppConfig;
import pl.technicalsite.AppConfig.AppVersionResponse;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;
import pl.technicalsite.FileService.FileReaderService;
import pl.technicalsite.FileService.FileServiceImpl;

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
    public ResponseEntity<FileResponse> create(@RequestBody @Valid FileDto fileDto) {
        FileResponse fileResponse = new FileResponse("");
        if (fileDto.getFieldsDto().getId() == null || fileDto.getFieldsDto().getId().isBlank()) {
            fileResponse.setResult("The ID field value cannot be empty");
            return new ResponseEntity<>(fileResponse, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(fileServiceImpl.createFile(fileDto));
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
        return resultOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

}