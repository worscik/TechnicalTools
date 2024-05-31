package pl.technicalsite.WebController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.technicalsite.AppConfig.AppConfig;
import pl.technicalsite.AppConfig.AppVersionResponse;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;
import pl.technicalsite.FileModel.MappingsType;
import pl.technicalsite.FileService.FileReaderService;
import pl.technicalsite.FileService.FileService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(value = "*")
public class FileWebController {

    private final FileService fileService;
    private final FileReaderService fileReaderService;

    public FileWebController(FileService fileService, FileReaderService fileReaderService) {
        this.fileService = fileService;
        this.fileReaderService = fileReaderService;
    }

    @PostMapping("/create")
    public ResponseEntity<FileResponse> create(@RequestBody @Valid FileDto fileDto, BindingResult result) {
        FileResponse fileResponse = new FileResponse();

        if(result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            fileResponse.setErrorMessages(errorMessages);
            return ResponseEntity.badRequest().body(fileResponse);
        }

        return fileService.createFile(fileDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
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

    @PostMapping("/readFromFile")
    public ResponseEntity<Map<String, String>> readFieldsFromFile(@RequestBody String xslFile) {
        Optional<Map<String, String>> resultOptional = Optional.ofNullable(fileReaderService.readFromXsl(xslFile));
        return resultOptional.map(stringStringMap -> ResponseEntity.ok().body(stringStringMap))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/structures")
    public List<String> getAvailableStructure() {
        return MappingsType.listOfAvailableStructure;
    }

}