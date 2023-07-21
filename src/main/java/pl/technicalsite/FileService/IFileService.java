package pl.technicalsite.FileService;

import pl.technicalsite.FileModel.FileDto;

public interface IFileService {

    String preapreStandardFile(FileDto fileDto);

    String buildTemplete();

}
