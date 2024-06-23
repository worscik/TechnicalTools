package pl.technicalsite.FileComponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MatchLineServiceTest {

    public static final String RSS_CHANNEL_ITEM = "rss/channel/item";
    public static final String ROOT_ITEM = "root/item";
    public static final String PRODUCTS_PRODUCT = "products/product";
    public static final String FEED_ENTRY = "feed/entry";
    public static final String OFFERS_GROUP_O = "offers/group/o";

    @InjectMocks
    private MatchLineService matchLineService;


    @Test
    void resolveMatchLineWithRssChannelItem() {
       assertThat(matchLineService.resolveMatchLine(RSS_CHANNEL_ITEM))
               .isNotNull()
               .usingDefaultComparator()
               .isEqualTo("<xsl:template match=\"rss/channel/item\">");
    }

    @Test
    void resolveMatchLineWithRootItem() {
        assertThat(matchLineService.resolveMatchLine(ROOT_ITEM))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"root/item\">");
    }

    @Test
    void resolveMatchLineWithProductsProduct() {
        assertThat(matchLineService.resolveMatchLine(PRODUCTS_PRODUCT))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"products/product\">");
    }

    @Test
    void resolveMatchLineWithFeedEntry() {
        assertThat(matchLineService.resolveMatchLine(FEED_ENTRY))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"a:feed/a:entry\">");
    }

    @Test
    void resolveMatchLineWithOffersGroupO() {
        assertThat(matchLineService.resolveMatchLine(OFFERS_GROUP_O))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"offers/group/o\">");
    }

    @Test
    void resolveMatchLineWithSingleMatchLine() {
        assertThat(matchLineService.resolveMatchLine("matchLine"))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"matchLine\">");
    }

    @Test
    void resolveMatchLineWithMultiplyMatchLine() {
        assertThat(matchLineService.resolveMatchLine("matchLine1, matchLine2"))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:template match=\"matchLine1 | matchLine2\">");
    }





}