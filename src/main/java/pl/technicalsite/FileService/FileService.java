package pl.technicalsite.FileService;

import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;

public interface FileService {

    FileResponse createFile(FileDto fileDto);

}
