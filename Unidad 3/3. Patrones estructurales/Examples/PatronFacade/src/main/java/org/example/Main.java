package org.example;

import org.example.facade.*;

public class Main {
    public static void main(String[] args) {

        PaymentRequest request = new PaymentRequest(3L, 100,
                "1234567890123456","Brayan Badillo",
                "10/2015", "345");
        IPaymentFacade paymentFacade = new OnlinePaymentFacade();
        try {

            PaymentResponse response = paymentFacade.pay(request);

        }catch(GeneralPaymentError ex){

            System.out.println(ex);

        }

    }
}