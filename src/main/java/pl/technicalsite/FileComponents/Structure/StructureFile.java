package pl.technicalsite.FileComponents.Structure;

import org.springframework.stereotype.Component;

import static pl.technicalsite.FileModel.MappingsType.listOfAvailableStructure;

@Component
public class StructureFile {

    public boolean resolveStructure(String structure) {
        for (String x : listOfAvailableStructure) {
            if (x.equals(structure)) {
                System.out.println("Structure correct: " + structure);
                return true;

            }
        }
        return false;
    }

}
