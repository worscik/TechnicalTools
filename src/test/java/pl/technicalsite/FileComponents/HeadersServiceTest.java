package pl.technicalsite.FileComponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class HeadersServiceTest {

    public static final String RSS_CHANNEL_ITEM = "rss/channel/item";
    public static final String ROOT_ITEM = "root/item";
    public static final String PRODUCTS_PRODUCT = "products/product";
    public static final String FEED_ENTRY = "feed/entry";
    public static final String OFFERS_GROUP_O = "offers/group/o";
    public static final String UNKNOWN_STRUCTURE = "unknown/structure";

    @InjectMocks
    private HeadersService headersService;

    @Test
    void resolveHeadersWithRssChannelItem() {
        assertThat(headersService.resolveHeaders(RSS_CHANNEL_ITEM))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"\n" +
                        "\t\txmlns:g=\"http://base.google.com/ns/1.0\">");
    }

    @Test
    void resolveHeadersWithRootItem() {
        assertThat(headersService.resolveHeaders(ROOT_ITEM))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">");
    }

    @Test
    void resolveHeadersWithProductsProduct() {
        assertThat(headersService.resolveHeaders(PRODUCTS_PRODUCT))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">");
    }

    @Test
    void resolveHeadersWithFeedEntry() {
        assertThat(headersService.resolveHeaders(FEED_ENTRY))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"\n" +
                        "\t\txmlns:g=\"http://base.google.com/ns/1.0\"\n" +
                        "\t\txmlns:a=\"http://www.w3.org/2005/Atom\">");
    }

    @Test
    void resolveHeadersWithOffersGroupO() {
        assertThat(headersService.resolveHeaders(OFFERS_GROUP_O))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">");
    }

    @Test
    void resolveHeadersWithUnknownStructure() {
        assertThat(headersService.resolveHeaders(UNKNOWN_STRUCTURE))
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo("<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">");
    }

}