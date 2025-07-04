import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;
    
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    
    @Override
    public boolean isAvailable() {
        return quantity > 0 && !isExpired();
    }
    
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
    
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
