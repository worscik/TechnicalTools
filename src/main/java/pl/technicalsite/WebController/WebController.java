package pl.technicalsite.WebController;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;
import pl.technicalsite.FileService.FileService;

import java.security.Principal;

@Controller
@CrossOrigin(value = "*")
public class WebController {

    private final FileService fileService;

    public WebController(FileService fileService) {
        this.fileService = fileService;
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

}
