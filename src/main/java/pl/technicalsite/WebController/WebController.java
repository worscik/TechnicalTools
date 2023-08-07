package pl.technicalsite.WebController;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.technicalsite.FileModel.FileCustomDto;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileService.FileService;

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
    public String createXsls(@RequestBody @Valid FileDto fileDto, FileCustomDto fileCustomDto, BindingResult bindingResult) {

      if(fileDto.getFieldsDto().getId() == null){
          return "ID can not be null";
      }

        //TODO custom script
        if (fileDto.isCustom()) {
//            fileService.prepareCustomFile(fileDto, fileCustomDto);
            return "Custom is not ready yet";
        }
        return fileService.preapreStandardFile(fileDto, fileCustomDto);
    }


}
