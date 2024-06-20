package pl.technicalsite.FieldsModel;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public class FieldsDto {

    @NotBlank(message = "id may not be blank")
    private String id;
    private String name;
    private String newProductKey;
    private String newProductValue;
    private String availableKey;
    private String availableValue;
    private String bestsellerKey;
    private String bestsellerValue;
    private String brand;
    private String categories;
    private String categoryMain;
    private String description;
    private String detail1;
    private String detail2;
    private String detail3;
    private String detail4;
    private String detail5;
    private String manufacturer;
    private String price;
    private String currency;
    private String pricePromo;
    private String quantity;
    private String urlProduct;
    private String urlImg;
    private String genderKey;
    private String genderValue;
    private String urlCategory;
    private String urlCategoryMark;
    private String popularity;
    private String season;
    private String color;
    private String additionalImage;
    private String intDetail1;
    private String intDetail2;
    private String intDetail3;

    public FieldsDto(String id,
                     String name,
                     String newProductKey,
                     String newProductValue,
                     String availableKey,
                     String availableValue,
                     String bestsellerKey,
                     String bestsellerValue,
                     String brand,
                     String categories,
                     String categoryMain,
                     String description,
                     String detail1,
                     String detail2,
                     String detail3,
                     String detail4,
                     String detail5,
                     String manufacturer,
                     String price,
                     String currency,
                     String pricePromo,
                     String quantity,
                     String urlProduct,
                     String urlImg,
                     String genderKey,
                     String genderValue,
                     String urlCategory,
                     String urlCategoryMark,
                     String popularity,
                     String season,
                     String color,
                     String additionalImage,
                     String intDetail1,
                     String intDetail2,
                     String intDetail3) {
        this.id = id;
        this.name = name;
        this.newProductKey = newProductKey;
        this.newProductValue = newProductValue;
        this.availableKey = availableKey;
        this.availableValue = availableValue;
        this.bestsellerKey = bestsellerKey;
        this.bestsellerValue = bestsellerValue;
        this.brand = brand;
        this.categories = categories;
        this.categoryMain = categoryMain;
        this.description = description;
        this.detail1 = detail1;
        this.detail2 = detail2;
        this.detail3 = detail3;
        this.detail4 = detail4;
        this.detail5 = detail5;
        this.manufacturer = manufacturer;
        this.price = price;
        this.currency = currency;
        this.pricePromo = pricePromo;
        this.quantity = quantity;
        this.urlProduct = urlProduct;
        this.urlImg = urlImg;
        this.genderKey = genderKey;
        this.genderValue = genderValue;
        this.urlCategory = urlCategory;
        this.urlCategoryMark = urlCategoryMark;
        this.popularity = popularity;
        this.season = season;
        this.color = color;
        this.additionalImage = additionalImage;
        this.intDetail1 = intDetail1;
        this.intDetail2 = intDetail2;
        this.intDetail3 = intDetail3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewProductKey() {
        return newProductKey;
    }

    public void setNewProductKey(String newProductKey) {
        this.newProductKey = newProductKey;
    }

    public String getNewProductValue() {
        return newProductValue;
    }

    public void setNewProductValue(String newProductValue) {
        this.newProductValue = newProductValue;
    }

    public String getAvailableKey() {
        return availableKey;
    }

    public void setAvailableKey(String availableKey) {
        this.availableKey = availableKey;
    }

    public String getAvailableValue() {
        return availableValue;
    }

    public void setAvailableValue(String availableValue) {
        this.availableValue = availableValue;
    }

    public String getBestsellerKey() {
        return bestsellerKey;
    }

    public void setBestsellerKey(String bestsellerKey) {
        this.bestsellerKey = bestsellerKey;
    }

    public String getBestsellerValue() {
        return bestsellerValue;
    }

    public void setBestsellerValue(String bestsellerValue) {
        this.bestsellerValue = bestsellerValue;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCategoryMain() {
        return categoryMain;
    }

    public void setCategoryMain(String categoryMain) {
        this.categoryMain = categoryMain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public String getDetail3() {
        return detail3;
    }

    public void setDetail3(String detail3) {
        this.detail3 = detail3;
    }

    public String getDetail4() {
        return detail4;
    }

    public void setDetail4(String detail4) {
        this.detail4 = detail4;
    }

    public String getDetail5() {
        return detail5;
    }

    public void setDetail5(String detail5) {
        this.detail5 = detail5;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPricePromo() {
        return pricePromo;
    }

    public void setPricePromo(String pricePromo) {
        this.pricePromo = pricePromo;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUrlProduct() {
        return urlProduct;
    }

    public void setUrlProduct(String urlProduct) {
        this.urlProduct = urlProduct;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getGenderKey() {
        return genderKey;
    }

    public void setGenderKey(String genderKey) {
        this.genderKey = genderKey;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getUrlCategory() {
        return urlCategory;
    }

    public void setUrlCategory(String urlCategory) {
        this.urlCategory = urlCategory;
    }

    public String getUrlCategoryMark() {
        return urlCategoryMark;
    }

    public void setUrlCategoryMark(String urlCategoryMark) {
        this.urlCategoryMark = urlCategoryMark;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAdditionalImage() {
        return additionalImage;
    }

    public void setAdditionalImage(String additionalImage) {
        this.additionalImage = additionalImage;
    }

    public String getIntDetail1() {
        return intDetail1;
    }

    public void setIntDetail1(String intDetail1) {
        this.intDetail1 = intDetail1;
    }

    public String getIntDetail2() {
        return intDetail2;
    }

    public void setIntDetail2(String intDetail2) {
        this.intDetail2 = intDetail2;
    }

    public String getIntDetail3() {
        return intDetail3;
    }

    public void setIntDetail3(String intDetail3) {
        this.intDetail3 = intDetail3;
    }
}
