package pl.technicalsite.WebController;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;
import pl.technicalsite.FileService.FileService;

@Controller
public class WebController {

    private final FileService fileService;

    public WebController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/")
    public String homePage(){
        return "home page";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createXsls(@RequestBody FileDto fileDto){
        //TODO custom script
        if(fileDto.isCustom()){
            return "Custom is not ready yet";
        }
        return fileService.preapreStandardFile(fileDto);
    }


}
