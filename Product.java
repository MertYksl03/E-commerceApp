public class Product {
    private String productName;
    private String productColor;
    private String productCategory;
    private int productStockInfo;
    private String productWeight;
    private String productDescription;


    public Product(String productName, String productColor, String productCategory,int productStockInfo, String productWeight, String productDescription) {
        this.productName = productName;
        this.productColor = productColor;
        this.productCategory = productCategory;
        this.productStockInfo = productStockInfo;
        this.productWeight = productWeight;
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductStockInfo() {
        return productStockInfo;
    }

    public void setProductStockInfo(int productStockInfo) {
        this.productStockInfo = productStockInfo;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    //decrease stock when product is bought
    public void decreaseStock(int quantity){
        this.productStockInfo -= quantity;
    }

    @Override
    public String toString() {
        return "Name: " + productName + "\nColor: " + productColor + "\nCategory " + productCategory + "\nStock Info: " + productStockInfo + "\nWeight: " + productWeight + "\nDescription: " + productDescription +"\n---";    
    }
}