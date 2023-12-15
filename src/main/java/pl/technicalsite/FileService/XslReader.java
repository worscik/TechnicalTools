package pl.technicalsite.FileService;

import java.util.Map;

public interface XslReader {

    Map<String, String> readFromXsl(String xsl);

    Map<String, String> resolveValuesAndKeys(Map<String, String> structureFile,
                                             Map<String, String> keys,
                                             Map<String, String> numeric,
                                             Map<String, String> values,
                                             Map<String, String> currency);


}
