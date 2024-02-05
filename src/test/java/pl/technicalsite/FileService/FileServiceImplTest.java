package pl.technicalsite.FileService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.technicalsite.FileComponents.CutLine.CutLineService;
import pl.technicalsite.FileComponents.Headers.HeadersService;
import pl.technicalsite.FileComponents.MatchLine.MatchLineService;
import pl.technicalsite.FileComponents.Structure.StructureFile;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.Template.TemplateService.TemplateService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FileServiceImplTest {

    @Mock
    private CutLineService cutLineService;
    @Mock
    private HeadersService headersService;
    @Mock
    private StructureFile structureFile;
    @Mock
    private MatchLineService matchLineService;
    @Mock
    private TemplateService templateService;


    public void shouldPreapreStandardFile(){
        FileDto fileDto = new FileDto();

    }


}