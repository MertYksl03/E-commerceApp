public class CreditCard {
    private String cardNumber;
    private String cardUser;
    private String securityCode;
    private String expirationDate;

    // Constructor

    public CreditCard(String cardNumber, String cardUser, String securityCode, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardUser = cardUser;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
    }

    // Getters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardUser() {
        return cardUser;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    // Setters
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardUser(String cardUser) {
        this.cardUser = cardUser;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return cardNumber + ", " + cardUser + ", " + securityCode + ", " + expirationDate;
    }
}