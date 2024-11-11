package escuelaing.edu.co.model;

import escuelaing.edu.co.types.PaymentType;

public class Payment {
    private Long id;
    private Long amount;
    private String currency;
    private PaymentType paymentType;

    public Payment(Long id, Long amount, String currency, PaymentType paymentType) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.paymentType = paymentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
