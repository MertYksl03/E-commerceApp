import java.util.Scanner;


import java.util.List;

public class Test {

    private static List<User> users = ReadByFile.ReadUsers("DataTexts/Users.txt");
    private static List<Product> products = ReadByFile.ReadProducts("DataTexts/Products.txt");
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); // clears the console
        System.out.println("***Welcome to the Online Shopping System***\n");

        Scanner input = new Scanner(System.in);
        int choice = 0;
        int userIndex = -1;

        while (true) {
            printLoginMenu();
            try {
                choice = input.nextInt();
                input.nextLine();
                if (choice == 3) {
                    System.out.println("Exiting the system...");
                    System.out.println("Goodbye!");
                    break;
                }
                switch (choice) {
                    case 1:
                        userIndex = isLoginSuccessful(input);
                        if (userIndex != -1) {
                            mainMenu(input, userIndex);
                        }
                        break;
                    case 2:
                        registerUser(input);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine(); // Clear the invalid input
            }
        }

        input.close();
    }

    public static void mainMenu(Scanner input, int userIndex) {
        
        while (true) {    
            System.out.println("---Main Menu---");
            System.out.println("1. View products");
            System.out.println("2. Buy products");
            System.out.println("3. Add prodcuts to favorite list");
            System.out.println("4. View favorite list");
            System.out.println("5. Add CreditCard");
            System.out.println("6. View CreditCards");
            System.out.println("7. Add Product");
            System.out.println("8. Logout");
            int productIndex = 0;

            try {
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        // viewProducts;
                        printProducts();
                        break;
                    case 2:
                        // buyProducts;
                        if (users.get(userIndex).getCreditCards().size() == 0) {
                            System.out.println("No credit cards found.");
                            System.out.println("Please add a credit card to buy a product.");
                        
                        } else {
                            printProducts();
                            System.out.println("\nEnter the product number you want to buy: ");
                            productIndex = input.nextInt();
                            input.nextLine();
                            System.out.println("Enter the quantity: ");
                            int quantity = input.nextInt();
                            input.nextLine(); 

                        if (quantity <= 0) {
                            System.out.println("Invalid quantity. Please try again.");
                            break;
                        }
                            printCreditCards(userIndex);
                            System.out.println("Enter the credit card number you want to use: ");
                            int creditCardIndex = input.nextInt();
                            input.nextLine();
                            

                            if (users.get(userIndex).getCreditCards().size() < creditCardIndex) {
                                System.out.println("Invalid credit card number. Please try again.");
                                break;
                            }

                            Order.buyProduct(users, products, userIndex, productIndex - 1, creditCardIndex - 1, quantity);

                            // Write the updated products to the file
                            WriteToFile.writeProducts(products, "DataTexts/Products.txt");
                        }    

                        break;
                    case 3:
                        // addFavoriteList;
                        printProducts();
                        System.out.println("\nEnter the product number you want to add to your favorite list: ");
                        productIndex = input.nextInt();
                        input.nextLine();
                        users.get(userIndex).addFavoriteOrder(products.get(productIndex - 1));
                        break;
                    case 4:
                        // viewFavoriteList;
                        if (users.get(userIndex).getFavoriteOrders().size() == 0) {
                            System.out.println("No favorite orders found.");
                        } else {
                            System.out.println("Favorite Products: " + users.get(userIndex).getFavoriteOrders() );
                        }
                        break;
                    case 5:
                        //addCreditCard;
                        System.out.println("Enter your credit card number: ");
                        String creditCardNumber = input.nextLine();
                        System.out.println("Enter your name: ");
                        String name = input.nextLine();
                        System.out.println("Enter your cvv: ");
                        String cvv = input.nextLine();
                        System.out.println("Enter your expiration date: ");
                        String expirationDate = input.nextLine();
                        
                        users.get(userIndex).addCreditCard(new CreditCard(creditCardNumber, name,cvv, expirationDate));
                        System.out.print("\033[H\033[2J");
                        break;
                    case 6:
                        //viewCreditCards;
                        printCreditCards(userIndex);
                        break;
                    case 7:
                        //addProduct;
                        System.out.println("Enter the product name: ");
                        String productName = input.nextLine();
                        System.out.println("Enter the product color: ");
                        String productColor = input.nextLine();
                        System.out.println("Enter the product category: ");
                        String productCategory = input.nextLine();
                        System.out.println("Enter the product stock info: ");
                        int productStockInfo = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter the product weight: ");
                        String productWeight = input.nextLine();
                        System.out.println("Enter the product description: ");
                        String productDescription = input.nextLine();

                        products.add(new Product(productName, productColor, productCategory, productStockInfo, productWeight, productDescription));

                        // Write the updated products to the file
                        WriteToFile.writeProducts(products, "DataTexts/Products.txt");
                        break;
                    case 8:
                        System.out.println("Logging out...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    input.nextLine(); // Clear the invalid input
            } finally {
                    
            }
            }
        }

    public static void printCreditCards(int userIndex) {
        System.out.print("\033[H\033[2J");
        int creditCardIndex = 1;
        if (users.get(userIndex).getCreditCards().size() == 0) {
            System.out.println("No credit cards found.");
        } else {
            for (CreditCard creditCard : users.get(userIndex).getCreditCards()) {
                System.out.println("CREDIT CARD: " + creditCardIndex++ + ":");
                System.out.println(creditCard);
            }
        }        
    }

    public static void printProducts() {
        System.out.print("\033[H\033[2J");
        int index = 1;
        for (Product product : products) {
            System.out.println("PRODUCT: " + index++ + ":");
            System.out.println(product);
        }

    }
    public static void printLoginMenu() {
        System.out.println("---Login Menu---");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void registerUser(Scanner input) {
        System.out.println("Enter your username: ");
        String username = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter your surname: ");
        String surname = input.nextLine();
        System.out.println("Enter your birth date: ");
        String birthDate = input.nextLine();
        System.out.println("Enter your email: ");
        String email = input.nextLine();
        System.out.println("Enter your home address: ");
        String homeAddress = input.nextLine();
        System.out.println("Enter your work address: ");
        String workAddress = input.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please try again.");
                registerUser(input);
                return;
            }
        }

        users.add(new User(username, password, name, surname, birthDate, email, homeAddress, workAddress));
        WriteToFile.writeUsers(users, "DataTexts/Users.txt");
    }

    public static int isLoginSuccessful(Scanner input) {
        int loginAttempts = 0;

        while (loginAttempts < 3) {
            System.out.println("Enter your username: ");
            String username = input.nextLine();
            System.out.println("Enter your password: ");
            String password = input.nextLine();
            int userIndex = 0;

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Login successful");
                    System.out.println("Welcome " + user.getName() + " " + user.getSurname() + "!");
                    return userIndex;
                }
                userIndex++;
            }
            loginAttempts++;
            System.out.println("Login failed. Please try again.\n");
        }

        System.out.println("You have exceeded the maximum number of login attempts. Please try again later.");

        return -1;
    }


    //TODO: Delete this 
    public static void readAndWritetest() {
        List<User> users = ReadByFile.ReadUsers("DataTexts/Users.txt");
        users.add(new User("newUser", "newPassword", "newName", "newSurname", "newBirthDate", "newEmail", "newHomeAddress", "newWorkAddress"));
        
        for (User user : users) {
            System.out.println(user);
        }
        users.remove(2);
        WriteToFile.writeUsers(users, "DataTexts/Users.txt");

        List<Product> products = ReadByFile.ReadProducts("DataTexts/Products.txt");
        products.add(new Product("newProduct", "newColor", "newCategory", 0, "newWeight", "newDescription"));

        for (Product product : products) {
            System.out.println(product);
        }

        products.remove(2);
        WriteToFile.writeProducts(products, "DataTexts/Products.txt");
    }
}
