import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadByFile {

    public static List<User> ReadUsers(String filePath) {
        
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().equals("---")) {
                    // Skip the separator line
                    continue;
                }

                String username = line;
                String password = br.readLine();
                String firstName = br.readLine();
                String lastName = br.readLine();
                String dateOfBirth = br.readLine();
                String email = br.readLine();
                String homeAddress = br.readLine();
                String workAddress = br.readLine();

                // Consume the separator line after each user block
                line = br.readLine(); // this should be the "---" or end of file

                User user = new User(username, password, firstName, lastName, dateOfBirth, email, homeAddress, workAddress);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // for (User user : users) {
        //     System.out.println(user);
        // }
        
        // Return the list of users
        return users;

        // Print all users
        
    }

    public static List<Product> ReadProducts(String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().equals("---")) {
                    // Skip the separator line
                    continue;
                }

                String name = line;
                String color = br.readLine();
                String category = br.readLine();
                int stockInfo = Integer.parseInt(br.readLine());
                String weight = br.readLine();
                String description = br.readLine();
                // Consume the separator line after each product block
                line = br.readLine(); // this should be the "---" or end of file

                Product product = new Product(name, color, category, stockInfo, description, weight);
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return the list of products
        return products;
    }
}
