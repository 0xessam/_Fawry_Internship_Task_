import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    
    public Cart() {
        this.items = new ArrayList<>();
    }
    
    public void addProduct(Product product, int quantity) throws Exception {
        if (!product.isAvailable()) {
            throw new Exception("Product " + product.getName() + " is not available (out of stock or expired)");
        }
        
        if (!product.hasStock(quantity)) {
            throw new Exception("Not enough stock for " + product.getName() + 
                              ". We have: " + product.getQuantity() + ", You want: " + quantity);
        }
        
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                throw new Exception("Product already in cart. Please change existing item.");
            }
        }
        
        items.add(new CartItem(product, quantity));
    }
    
    public List<CartItem> getItems() {
        return items;
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
    
    public List<ShippableProduct> getShippableItems() {
        List<ShippableProduct> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            if (item.getProduct() instanceof ShippableProduct) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((ShippableProduct) item.getProduct());
                }
            }
        }
        return shippableItems;
    }
}
