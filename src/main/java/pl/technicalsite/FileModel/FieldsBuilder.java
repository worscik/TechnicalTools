package pl.technicalsite.FileModel;

public class FieldsBuilder {

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
    private String addidtionalImage;
    private String intDetail1;
    private String intDetail2;
    private String intDetail3;

    @Override
    public String toString() {
        return "TemplateDto{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", newProductKey='" + newProductKey + '\'' +
                ", newProductValue='" + newProductValue + '\'' +
                ", availableKey='" + availableKey + '\'' +
                ", availableValue='" + availableValue + '\'' +
                ", bestsellerKey='" + bestsellerKey + '\'' +
                ", bestsellerValue='" + bestsellerValue + '\'' +
                ", brand='" + brand + '\'' +
                ", categories='" + categories + '\'' +
                ", categoryMain='" + categoryMain + '\'' +
                ", description='" + description + '\'' +
                ", detail1='" + detail1 + '\'' +
                ", detail2='" + detail2 + '\'' +
                ", detail3='" + detail3 + '\'' +
                ", detail4='" + detail4 + '\'' +
                ", detail5='" + detail5 + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", pricePromo='" + pricePromo + '\'' +
                ", quantity='" + quantity + '\'' +
                ", urlProduct='" + urlProduct + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", genderKey='" + genderKey + '\'' +
                ", genderValue='" + genderValue + '\'' +
                ", urlCategory='" + urlCategory + '\'' +
                ", urlCategoryMark='" + urlCategoryMark + '\'' +
                ", popularity='" + popularity + '\'' +
                ", season='" + season + '\'' +
                ", color='" + color + '\'' +
                ", addidtionalImage='" + addidtionalImage + '\'' +
                ", intDetail1='" + intDetail1 + '\'' +
                ", intDetail2='" + intDetail2 + '\'' +
                ", intDetail3='" + intDetail3 + '\'' +
                '}';
    }

    private FieldsBuilder(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.newProductKey = builder.newProductKey;
        this.newProductValue = builder.newProductValue;
        this.availableKey = builder.availableKey;
        this.availableValue = builder.availableValue;
        this.bestsellerKey = builder.bestsellerKey;
        this.bestsellerValue = builder.bestsellerValue;
        this.brand = builder.brand;
        this.categories = builder.categories;
        this.categoryMain = builder.categoryMain;
        this.description = builder.description;
        this.detail1 = builder.detail1;
        this.detail2 = builder.detail2;
        this.detail3 = builder.detail3;
        this.detail4 = builder.detail4;
        this.detail5 = builder.detail5;
        this.manufacturer = builder.manufacturer;
        this.price = builder.price;
        this.currency = builder.currency;
        this.pricePromo = builder.pricePromo;
        this.quantity = builder.quantity;
        this.urlProduct = builder.urlProduct;
        this.urlImg = builder.urlImg;
        this.genderKey = builder.genderKey;
        this.genderValue = builder.genderValue;
        this.urlCategory = builder.urlCategory;
        this.urlCategoryMark = builder.urlCategoryMark;
        this.popularity = builder.popularity;
        this.season = builder.season;
        this.color = builder.color;
        this.addidtionalImage = builder.addidtionalImage;
        this.intDetail1 = builder.intDetail1;
        this.intDetail2 = builder.intDetail2;
        this.intDetail3 = builder.intDetail3;



    }

    public static class Builder{
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
        private String addidtionalImage;
        private String intDetail1;
        private String intDetail2;
        private String intDetail3;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder newProductKey(String newProductKey) {
            this.newProductKey = newProductKey;
            return this;
        }

        public Builder newProductValue(String newProductValue) {
            this.newProductValue = newProductValue;
            return this;
        }

        public Builder availableKey(String availableKey) {
            this.availableKey = availableKey;
            return this;
        }

        public Builder availableValue(String availableValue) {
            this.availableValue = availableValue;
            return this;
        }

        public Builder bestsellerKey(String bestsellerKey) {
            this.bestsellerKey = bestsellerKey;
            return this;
        }

        public Builder bestsellerValue(String bestsellerValue) {
            this.bestsellerValue = bestsellerValue;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder categories(String categories) {
            this.categories = categories;
            return this;
        }

        public Builder categoryMain(String categoryMain) {
            this.categoryMain = categoryMain;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder detail1(String detail1) {
            this.detail1 = detail1;
            return this;
        }

        public Builder detail2(String detail2) {
            this.detail2 = detail2;
            return this;
        }

        public Builder detail3(String detail3) {
            this.detail3 = detail3;
            return this;
        }

        public Builder detail4(String detail4) {
            this.detail4 = detail4;
            return this;
        }

        public Builder detail5(String detail5) {
            this.detail5 = detail5;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder pricePromo(String pricePromo) {
            this.pricePromo = pricePromo;
            return this;
        }

        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder urlProduct(String urlProduct) {
            this.urlProduct = urlProduct;
            return this;
        }

        public Builder urlImg(String urlImg) {
            this.urlImg = urlImg;
            return this;
        }

        public Builder genderKey(String genderKey) {
            this.genderKey = genderKey;
            return this;
        }

        public Builder genderValue(String genderValue) {
            this.genderValue = genderValue;
            return this;
        }

        public Builder urlCategory(String urlCategory) {
            this.urlCategory = urlCategory;
            return this;
        }

        public Builder urlCategoryMark(String urlCategoryMark) {
            this.urlCategoryMark = urlCategoryMark;
            return this;
        }

        public Builder popularity(String popularity) {
            this.popularity = popularity;
            return this;
        }

        public Builder season(String season) {
            this.season = season;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder addidtionalImage(String addidtionalImage) {
            this.addidtionalImage = addidtionalImage;
            return this;
        }

        public Builder intDetail1(String intDetail1) {
            this.intDetail1 = intDetail1;
            return this;
        }

        public Builder intDetail2(String intDetail2) {
            this.intDetail2 = intDetail2;
            return this;
        }

        public Builder intDetail3(String intDetail3) {
            this.intDetail3 = intDetail3;
            return this;
        }

        public FieldsBuilder build(){
            return new FieldsBuilder(this);
        }

    }

}
