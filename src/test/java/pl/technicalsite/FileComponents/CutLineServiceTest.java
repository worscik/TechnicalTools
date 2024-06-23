package pl.technicalsite.FileComponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CutLineServiceTest {

    public static final String RSS_CHANNEL_ITEM = "rss/channel/item";
    public static final String ROOT_ITEM = "root/item";
    public static final String PRODUCTS_PRODUCT = "products/product";
    public static final String FEED_ENTRY = "feed/entry";
    public static final String OFFERS_GROUP_O = "offers/group/o";
    public static final String CUSTOM_CUT_LINE = "custom/cut,line";

    @InjectMocks
    private CutLineService cutLineService;

    @Test
    void resolveCutLineWithNull() {
        assertThat(cutLineService.resolveCutLine(null))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo(" ");
    }

    @Test
    void resolveCutLineWithRootItem() {
        assertThat(cutLineService.resolveCutLine(ROOT_ITEM))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("");
    }

    @Test
    void resolveCutLineWithOffersGroupO() {
        assertThat(cutLineService.resolveCutLine(OFFERS_GROUP_O))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("");
    }

    @Test
    void resolveCutLineWithProductsProduct() {
        assertThat(cutLineService.resolveCutLine(PRODUCTS_PRODUCT))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("");
    }

    @Test
    void resolveCutLineWithRssChannelItem() {
        assertThat(cutLineService.resolveCutLine(RSS_CHANNEL_ITEM))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"rss/channel/title | rss/channel/link | rss/channel/description\"/>");
    }

    @Test
    void resolveCutLineWithFeedEntry() {
        assertThat(cutLineService.resolveCutLine(FEED_ENTRY))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"a:feed/a:title | a:feed/a:link | a:feed/a:updated\" />");
    }

    @Test
    void resolveCutLineWithCustomCutLine() {
        assertThat(cutLineService.resolveCutLine(CUSTOM_CUT_LINE))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"custom/cut | line\"/>");
    }

}