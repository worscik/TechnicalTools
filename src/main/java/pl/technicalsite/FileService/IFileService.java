package pl.technicalsite.FileService;

import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.FileModel.FileCustomDto;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.Template.TemplateModel.TemplateComponents;

public interface IFileService {

    String preapreStandardFile(FileDto fileDto, FileCustomDto fileCustomDto);

    String prepareCustomFile(FileDto fileDto, FileCustomDto fileCustomDto);

    String createFile(TemplateComponents templateComponents, FieldsBuilder fieldsBuilder);

}
