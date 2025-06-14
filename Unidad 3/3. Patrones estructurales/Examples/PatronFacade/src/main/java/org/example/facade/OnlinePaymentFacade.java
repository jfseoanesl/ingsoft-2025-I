package org.example.facade;

import org.example.banksystem.BankSystem;
import org.example.banksystem.TransferRequest;
import org.example.billingsystem.BillingPayRequest;
import org.example.billingsystem.BillingSystem;
import org.example.crmsystem.CRMSystem;
import org.example.emailsystem.EmailSystem;
import org.example.util.Customer;
import org.example.util.OnMemoryDB;

import java.util.HashMap;
import java.util.Map;

public class OnlinePaymentFacade implements IPaymentFacade{

    private static final CRMSystem crmSystem = new CRMSystem();
    private static final BillingSystem billingSystem = new BillingSystem();
    private static EmailSystem emailSystem=new EmailSystem();
    private static BankSystem bankSystem=new BankSystem();


    @Override
    public PaymentResponse pay(PaymentRequest request) throws GeneralPaymentError {

        Customer customer = crmSystem.findCustomer(request.getCustomerId());
        if(customer==null){

            throw new GeneralPaymentError("El cliente con id:" + request.getCustomerId() + " no existe");

        } else if ("BAJA".equals(customer.getStatus())) {

            throw new GeneralPaymentError("El cliente con id:" + request.getCustomerId() + " esta dado de baja ");

        }
        else if(request.getAmmount()>billingSystem.queryCustomerBalance(request.getCustomerId())) {
            throw new GeneralPaymentError("El cliente con id:" + request.getCustomerId() + " no tiene saldo suficiente ");
        }

        // Pago bancario. se realiza cargo a la tarjeta
        TransferRequest transferRequest = new TransferRequest(request.getAmmount(), request.getCardNumber(),
                request.getCardName(),
                request.getCardExpDate(),request.getCardSecureNum());
        String payReference = bankSystem.transfer(transferRequest);

        // Afectacion del saldo del sistema de facturacion
        BillingPayRequest billingPayRequest = new BillingPayRequest(request.getAmmount(), request.getCustomerId());
        double newBalance = billingSystem.pay(billingPayRequest);

        // actualizacion de status de cliente
        String newStatus= customer.getStatus();
        if(newBalance<=50){
            newStatus = "Activo";
            OnMemoryDB.changeCustomerStatus(request.getCustomerId(), newStatus);
        }

        // envio de email

        Map<String, String> params = new HashMap<>();
        params.put("$name", customer.getName());
        params.put("$ammount", request.getAmmount()+"");
        params.put("$newBalance", newBalance+"");
        String number = request.getCardNumber();
        String subfix = number.substring(number.length()-4, number.length());
        params.put("$cardNumber", subfix);
        params.put("$reference", payReference);
        params.put("$newStatus", newStatus);

        emailSystem.sendEmail(params);
        return  new PaymentResponse(payReference, newBalance, newStatus);

    }
}
