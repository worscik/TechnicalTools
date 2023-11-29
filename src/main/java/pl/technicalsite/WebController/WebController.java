package pl.technicalsite.WebController;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.technicalsite.FileModel.FieldsFileResponse;
import pl.technicalsite.FileModel.FileResponse;
import pl.technicalsite.FileModel.XslReaderRequest;
import pl.technicalsite.FileService.FileService;
import pl.technicalsite.AppConfig.AppConfig;
import pl.technicalsite.AppConfig.AppVersionResponse;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileService.XslReader;

import java.util.Map;

@Controller
@CrossOrigin(value = "*")
public class WebController {

    private final FileService fileService;
    private final XslReader xslReader;

    public WebController(FileService fileService, XslReader xslReader) {
        this.fileService = fileService;
        this.xslReader = xslReader;
    }

    @RequestMapping("/")
    public String homePage() {
        return "index.html";
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<FileResponse> create(@RequestBody @Valid FileDto fileDto) {
        FileResponse fileResponse = new FileResponse("");
        if (fileDto.getFieldsDto().getId() == null || fileDto.getFieldsDto().getId().isBlank()) {
            fileResponse.setResult("The ID field value cannot be empty");
            return new ResponseEntity<>(fileResponse, HttpStatus.BAD_REQUEST);
        }
        String result = fileService.preapreStandardFile(fileDto);
        fileResponse.setResult(result);
        return new ResponseEntity<>(fileResponse, HttpStatus.OK);
    }

    @GetMapping("/applicationVersion")
    @ResponseBody
    public AppVersionResponse applicationVersion(){
       AppVersionResponse appVersion = new AppVersionResponse();
       appVersion.setAppVersion(AppConfig.APP_VERSION);
       return appVersion;
    }

    @PostMapping("/read")
    @ResponseBody
    public FieldsFileResponse readFromFile(@RequestBody String xslFile){
        Map<String,String> result = xslReader.readFromXsl(xslFile);
         return new FieldsFileResponse(result);
    }
}
