package pl.technicalsite.FileComponents.Structure;

import org.springframework.stereotype.Component;

import static pl.technicalsite.FileModel.MappingsType.*;

@Component
public class StructureFile {

    public boolean resolveStructure(String structure) {
        for (String x : listOfAvailableStructure){
            if (x.equals(structure)){
                return true;
            }
        }
        return false;
    }

}
