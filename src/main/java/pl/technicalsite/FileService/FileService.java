package pl.technicalsite.FileService;

import pl.technicalsite.FieldsModel.FileBasicRequest;
import pl.technicalsite.FieldsModel.FileResponse;

public interface FileService {

    FileResponse createFile(FileBasicRequest fileBasicRequest);

}
