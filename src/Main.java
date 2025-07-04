import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Cheese cheese = new Cheese("Cheese", 100, 10, LocalDate.now().plusDays(7), 0.2);
            Biscuits biscuits = new Biscuits("Biscuits", 150, 5, LocalDate.now().plusDays(30), 0.7);
            TV tv = new TV("TV", 500, 3, 15.0);
            MobileScratchCard scratchCard = new MobileScratchCard("ScratchCard", 25, 20);
            
            Customer customer = new Customer("Essam Hisham", 1000.0);
            
            Cart cart = new Cart();
            cart.addProduct(cheese, 2);
            cart.addProduct(biscuits, 1);
            cart.addProduct(scratchCard, 1);
            
            ECommerceSystem ecommerce = new ECommerceSystem();
            ecommerce.checkout(customer, cart);
            
            System.out.println("\n=== Testing Error Cases ===");
            
            try {
                Cart emptyCart = new Cart();
                ecommerce.checkout(customer, emptyCart);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            try {
                Cart expensiveCart = new Cart();
                expensiveCart.addProduct(tv, 3);
                ecommerce.checkout(customer, expensiveCart);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            try {
                Cheese expiredCheese = new Cheese("Expired Cheese", 50, 5, LocalDate.now().minusDays(1), 0.2);
                Cart expiredCart = new Cart();
                expiredCart.addProduct(expiredCheese, 1);
                ecommerce.checkout(customer, expiredCart);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
