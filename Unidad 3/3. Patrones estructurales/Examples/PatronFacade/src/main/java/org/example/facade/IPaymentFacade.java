package org.example.facade;

public interface IPaymentFacade {

    PaymentResponse pay(PaymentRequest request) throws GeneralPaymentError;
}
