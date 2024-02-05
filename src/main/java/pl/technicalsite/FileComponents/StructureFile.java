package pl.technicalsite.FileComponents;

import org.springframework.stereotype.Component;

import static pl.technicalsite.FileModel.MappingsType.listOfAvailableStructure;

@Component
public class StructureFile {

    public boolean resolveStructure(String structure) {
        for (String x : listOfAvailableStructure) {
            if (x.equals(structure)) {
                return true;
            }
        }
        return false;
    }

}
