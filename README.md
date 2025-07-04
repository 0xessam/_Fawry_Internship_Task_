# Fawry Rise Journey
## Full Stack Development Internship Challenge

<p align="center">
  <img src="https://i.ibb.co/ZpCgxjKR/images.png" alt="Challenge Photo">
</p>

**Java OOP E-Commerce System Implementation**

### Challenge Requirements

Design an e-commerce system with these features:
- Products with name, price and quantity
- Expirable products (Cheese, Biscuits) vs non-expirable (TV, Mobile)
- Shippable products with weight vs non-shippable (scratch cards)
- Shopping cart with quantity validation
- Checkout process with subtotal, shipping fees, and balance management
- Error handling for empty cart, insufficient balance, expired/out-of-stock products
- ShippingService accepting objects with getName() and getWeight() methods

### Solution Overview

**Language:** Java  
**Design:** Object-Oriented Programming with inheritance, interfaces, and composition

**Key Classes:**
- Abstract Product class with ExpirableProduct and NonExpirableProduct subclasses
- ShippableProduct interface for items requiring delivery
- Cart and CartItem for shopping functionality
- Customer class for balance management
- ECommerceSystem for checkout orchestration
- ShippingService for weight-based fee calculation

### Error Handling

The system handles all required error cases:
- "Cart is empty" for empty checkout attempts
- "Not enough money" for insufficient customer balance
- "Product not available" for expired or out-of-stock items

### Technical Notes

- Shipping fee: $5 base + $10 per kg
- Products identified by name for uniqueness
- Cart prevents duplicate product entries
- Automatic stock quantity updates after purchase
- Interface-based shipping service design as specified

### Author
**Essam Eldin Hisham**  
 [essamhishamdev@gmail.com](mailto:essamhishamdev@gmail.com)  
 [LinkedIn Profile](https://linkedin.com/in/0xEssam)  
 [GitHub Profile](https://github.com/0xEssam)

