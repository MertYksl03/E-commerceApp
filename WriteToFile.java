import java.io.*;
import java.util.List;

public class WriteToFile { 
    
    public static void writeUsers(List<User> users, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                bw.write(user.getUsername());
                bw.newLine();
                bw.write(user.getPassword());
                bw.newLine();
                bw.write(user.getName());
                bw.newLine();
                bw.write(user.getSurname());
                bw.newLine();
                bw.write(user.getBirthDate());
                bw.newLine();
                bw.write(user.getEmail());
                bw.newLine();
                bw.write(user.getHomeAddress());
                bw.newLine();
                bw.write(user.getWorkAddress());
                bw.newLine();
                bw.write("---");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeProducts(List<Product> products, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                bw.write(product.getProductName());
                bw.newLine();
                bw.write(product.getProductColor());
                bw.newLine();
                bw.write(product.getProductCategory());
                bw.newLine();
                bw.write(String.valueOf(product.getProductStockInfo()));
                bw.newLine();
                bw.write(product.getProductWeight());
                bw.newLine();
                bw.write(product.getProductDescription());
                bw.newLine();
                bw.write("---");
                bw.newLine();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
            }
    }
}
