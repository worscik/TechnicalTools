package pl.technicalsite.FileService;

import pl.technicalsite.FileModel.FileCustomDto;
import pl.technicalsite.FileModel.FileDto;

public interface IFileService {

    String preapreStandardFile(FileDto fileDto,  FileCustomDto fileCustomDto);
    String prepareCustomFile(FileDto fileDto, FileCustomDto fileCustomDto);

    String buildTemplete();

}
