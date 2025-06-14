package org.example.banksystem;

import org.example.facade.GeneralPaymentError;
import org.example.util.OnMemoryDB;

import java.util.UUID;

public class BankSystem {

    public String transfer(TransferRequest request) throws GeneralPaymentError {

        String cardPrefix = request.getCardNumber().substring(0,3);
        if(!OnMemoryDB.validateCardBins(cardPrefix)){
            throw new GeneralPaymentError("Tarjeta invalidad");
        }
        String cardCompany = OnMemoryDB.getCardCompany(cardPrefix);
        if("AMEX".equals(cardCompany) && request.getCardNumber().length()!=15){
            throw new GeneralPaymentError("El numero de la tarjeta es invalido");
        }
        else if(("VISA".equals(cardCompany)|| "MASTERCARD".equals(cardCompany)) && request.getCardNumber().length()!=16) {
            throw new GeneralPaymentError("El numero de la tarjeta es invalido");
        }
        String number = request.getCardNumber();
        String cardNumberSubfix=number.substring(number.length()-4, number.length());
        System.out.println("Se ha realizado un cargo al cliente " +
                           request.getCardName() + "\n" +
                           "Por monto de: " + request.getAmmount() + "\n" +
                           "A la tarjeta terminada en " + cardNumberSubfix + "\n");

        return UUID.randomUUID().toString();

    }
}
