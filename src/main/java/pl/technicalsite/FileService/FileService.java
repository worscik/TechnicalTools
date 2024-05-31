package pl.technicalsite.FileService;

import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;

import java.util.Optional;

public interface FileService {

    Optional<FileResponse> createFile(FileDto fileDto);

}
