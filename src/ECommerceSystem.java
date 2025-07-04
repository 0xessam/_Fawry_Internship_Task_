import java.util.List;

public class ECommerceSystem {
    private ShippingService shippingService;
    
    public ECommerceSystem() {
        this.shippingService = new ShippingService();
    }
    
    public void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty");
        }
        
        for (CartItem item : cart.getItems()) {
            if (!item.getProduct().isAvailable()) {
                throw new Exception("Product " + item.getProduct().getName() + " is no longer available");
            }
            if (!item.getProduct().hasStock(item.getQuantity())) {
                throw new Exception("Not enough stock for " + item.getProduct().getName());
            }
        }
        
        double subtotal = cart.getSubtotal();
        List<ShippableProduct> shippableItems = cart.getShippableItems();
        double shippingFee = shippingService.calculateShippingFee(shippableItems);
        double totalAmount = subtotal + shippingFee;
        
        if (!customer.hasEnoughBalance(totalAmount)) {
            throw new Exception("Not enough money. Need: $" + totalAmount + 
                              ", You have: $" + customer.getBalance());
        }
        
        shippingService.processShipment(shippableItems);
        
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f%n", 
                item.getQuantity(), 
                item.getProduct().getName(), 
                item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        System.out.printf("Shipping         %.0f%n", shippingFee);
        System.out.printf("Amount           %.0f%n", totalAmount);
        System.out.println();
        
        customer.deductBalance(totalAmount);
        
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        
        System.out.printf("Customer money left: $%.2f%n", customer.getBalance());
    }
}
