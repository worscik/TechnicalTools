package pl.technicalsite.FileService;

import pl.technicalsite.FileModel.FieldsFileResponse;
import pl.technicalsite.FileModel.XslReaderRequest;

import java.util.Map;

public interface IXslReader {

    Map<String, String> readFromXsl(String xsl);

    Map<String, String> createMapWithKeysAndValues(Map<String, String> keys,
                                                   Map<String, String> values,
                                                   Map<String, String> currency);


}
