package pl.technicalsite.FileService;

import pl.technicalsite.FieldsModel.FileDto;
import pl.technicalsite.FieldsModel.FileResponse;

public interface FileService {

    FileResponse createFile(FileDto fileDto);

}
