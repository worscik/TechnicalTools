package pl.technicalsite.FileService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.technicalsite.FileComponents.CutLineService;
import pl.technicalsite.FileComponents.HeadersService;
import pl.technicalsite.FileComponents.MatchLineService;
import pl.technicalsite.FileModel.FileDto;

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