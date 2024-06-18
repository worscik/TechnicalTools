package pl.technicalsite.WebController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.technicalsite.AppConfig.AppConfig;
import pl.technicalsite.AppConfig.AppVersionResponse;
import pl.technicalsite.FieldsModel.FileDto;
import pl.technicalsite.FieldsModel.FileResponse;
import pl.technicalsite.FieldsModel.StandardMappingsType;
import pl.technicalsite.FileService.FileReaderImpl;
import pl.technicalsite.FileService.FileService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/template")
@CrossOrigin(value = "*")
public class FileWebController {

    private final FileService fileService;
    private final FileReaderImpl fileReaderImpl;

    public FileWebController(FileService fileService, FileReaderImpl fileReaderImpl) {
        this.fileService = fileService;
        this.fileReaderImpl = fileReaderImpl;
    }

    @PutMapping()
    public ResponseEntity<FileResponse> create(@RequestBody @Valid FileDto fileDto, BindingResult result) {
        FileResponse fileResponse = new FileResponse();

        if (result.hasErrors()) {
            List<String> errorMessages = result
                    .getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            fileResponse.setErrorMessages(errorMessages);
            return ResponseEntity.badRequest().body(fileResponse);
        }
        return ResponseEntity.ok().body(fileService.createFile(fileDto));
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

    @PostMapping()
    public ResponseEntity<Map<String, String>> readFieldsFromFile(@RequestBody String xslFile) {
        Map<String, String> result = fileReaderImpl.readFromXsl(xslFile);
        if (Objects.nonNull(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/structures")
    public List<String> getAvailableStructure() {
        return StandardMappingsType.listOfAvailableStructure;
    }

}