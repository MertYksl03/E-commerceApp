import java.util.List;
public class Order{
    public static void buyProduct(List <User> users, List <Product> products, int userIndex, int productIndex, int creditCardIndex, int quantity ) {
        if (products.get(productIndex).getProductStockInfo() >= quantity) {
            products.get(productIndex).decreaseStock(quantity);
            users.get(userIndex).getOrderedProducts().add(products.get(productIndex));
            System.out.println("Product bought successfully!");
        } else {
            System.out.println("Product is out of stock!");
        }
    }
}