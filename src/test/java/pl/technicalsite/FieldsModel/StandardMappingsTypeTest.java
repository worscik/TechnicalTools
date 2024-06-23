package pl.technicalsite.FieldsModel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class StandardMappingsTypeTest {

    @InjectMocks
    private StandardMappingsType standardMappingsType;

    public static final String RSS_CHANNEL_ITEM = "rss/channel/item";

    @Test
    void resolveStructureSuccess() {
        assertThat(standardMappingsType.resolveStructure(RSS_CHANNEL_ITEM))
                .isNotNull()
                .isTrue();
    }

    @Test
    void resolveStructureBadStructure() {
        assertThat(standardMappingsType.resolveStructure("randomStructure"))
                .isNotNull()
                .isFalse();
    }


}