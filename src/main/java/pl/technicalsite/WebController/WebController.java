package pl.technicalsite.WebController;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.technicalsite.AppConfig.AppConfig;
import pl.technicalsite.AppConfig.AppVersionResponse;
import pl.technicalsite.FileModel.FieldsFileResponse;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;
import pl.technicalsite.FileService.FileServiceImpl;
import pl.technicalsite.FileService.XslReaderImpl;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Controller
@CrossOrigin(value = "*")
public class WebController {

    private final FileServiceImpl fileServiceImpl;
    private final XslReaderImpl xslReaderImpl;

    public WebController(FileServiceImpl fileServiceImpl, XslReaderImpl xslReaderImpl) {
        this.fileServiceImpl = fileServiceImpl;
        this.xslReaderImpl = xslReaderImpl;
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
        String result = fileServiceImpl.preapreStandardFile(fileDto);
        fileResponse.setResult(result);
        return new ResponseEntity<>(fileResponse, HttpStatus.OK);
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
    public ResponseEntity<FieldsFileResponse> readFromFile(@RequestBody String xslFile) {
        if (!Objects.nonNull(xslFile)) {
            return new ResponseEntity(Collections.EMPTY_MAP, HttpStatus.BAD_REQUEST);
        }
        Map<String, String> result = xslReaderImpl.readFromXsl(xslFile);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
