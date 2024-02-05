package pl.technicalsite.FileService;

import java.util.Map;

public interface IFileReader {

    Map<String, String> readFromXsl(String xsl);

    Map<String, String> mergeMaps(Map<String, String> structureFile,
                                  Map<String, String> keys,
                                  Map<String, String> numeric,
                                  Map<String, String> values,
                                  Map<String, String> currency);


}
