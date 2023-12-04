package pl.technicalsite.FileService;

import java.util.Map;

public interface XslReader {

    Map<String, String> readFromXsl(String xsl);

    Map<String, String> createMapWithKeysAndValues(Map<String, String> keys,
                                                   Map<String, String> values,
                                                   Map<String, String> currency);


}
