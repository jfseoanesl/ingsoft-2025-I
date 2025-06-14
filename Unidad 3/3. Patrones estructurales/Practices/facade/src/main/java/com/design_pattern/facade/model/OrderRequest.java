package com.design_pattern.facade.model;

public class OrderRequest {
    private String productId;
    private int quantity;
    private String customerEmail;
    private String customerPhone;
    private String shippingAddress;
    private String paymentMethod;
    private String cardNumber;
    private String shippingMethod;

    // Constructores, getters y setters
    public OrderRequest(String productId, int quantity, String customerEmail,
                        String customerPhone, String shippingAddress, String paymentMethod,
                        String cardNumber, String shippingMethod) {
        this.productId = productId;
        this.quantity = quantity;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.shippingMethod = shippingMethod;
    }

    // Getters
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public String getCustomerEmail() { return customerEmail; }
    public String getCustomerPhone() { return customerPhone; }
    public String getShippingAddress() { return shippingAddress; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getCardNumber() { return cardNumber; }
    public String getShippingMethod() { return shippingMethod; }
}
