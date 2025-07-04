import java.util.List;

public class ShippingService {
    private static final double SHIPPING_RATE_PER_KG = 10.0;
    private static final double BASE_SHIPPING_FEE = 5.0;
    
    public double calculateShippingFee(List<ShippableProduct> items) {
        if (items.isEmpty()) {
            return 0.0;
        }
        
        double totalWeight = items.stream().mapToDouble(ShippableProduct::getWeight).sum();
        
        return BASE_SHIPPING_FEE + (totalWeight * SHIPPING_RATE_PER_KG);
    }
    
    public void processShipment(List<ShippableProduct> items) {
        if (items.isEmpty()) {
            return;
        }
        
        System.out.println("** Shipment notice **");
        
        items.stream()
            .collect(java.util.stream.Collectors.groupingBy(
                ShippableProduct::getName,
                java.util.stream.Collectors.summingDouble(ShippableProduct::getWeight)
            ))
            .forEach((name, weight) -> {
                long count = items.stream().filter(item -> item.getName().equals(name)).count();
                System.out.printf("%dx %-12s %.0fg%n", count, name, weight * 1000);
            });
        
        double totalWeight = items.stream().mapToDouble(ShippableProduct::getWeight).sum();
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
        System.out.println();
    }
}
