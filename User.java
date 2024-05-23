import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String birthDate;
    private String email;
    private String homeAddress;
    private String workAddress;
    private ArrayList<Product> orderedProducts = new ArrayList<>(); 
    private ArrayList<CreditCard> creditCards = new ArrayList<>();
    private ArrayList<Product> favoriteOrders = new ArrayList<>();


    // Constructor
    public User(String username, String password, String name, String surname, String birthDate,
                String email, String homeAddress, String workAddress) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.orderedProducts = new ArrayList<>();
        this.creditCards = new ArrayList<>();
        this.favoriteOrders = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public ArrayList<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public ArrayList<Product> getFavoriteOrders() {
        return favoriteOrders;
    }

    // Add ordered product

    public void addOrderedProduct(Product product) {
        orderedProducts.add(product);
    }

    // Add credit card

    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    // Add favorite order

    public void addFavoriteOrder(Product product) {
        favoriteOrders.add(product);
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }



    // Remove ordered product   

    public void removeOrderedProduct(Product product) {
        orderedProducts.remove(product);
    }

    // Remove credit card

    public void removeCreditCard(CreditCard creditCard) {
        creditCards.remove(creditCard);
    }

    // Remove favorite order

    public void removeFavoriteOrder(Product product) {
        favoriteOrders.remove(product);
    }
    

    @Override
    public String toString() {
        return "User{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", firstName='" + name + '\'' +
        ", lastName='" + surname + '\'' +
        ", dateOfBirth='" + birthDate + '\'' +
        ", email='" + email + '\'' +
        ", homeAddress='" + homeAddress + '\'' +
        ", workAddress='" + workAddress + '\'' +
        '}';
    }
}