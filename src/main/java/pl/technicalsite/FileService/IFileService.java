package pl.technicalsite.FileService;

import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.FileModel.FileCustomDto;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;
import pl.technicalsite.Template.TemplateModel.TemplateComponents;

public interface IFileService {

    String preapreStandardFile(FileDto fileDto);

    String createFile(TemplateComponents templateComponents, FieldsBuilder fieldsBuilder);

}
