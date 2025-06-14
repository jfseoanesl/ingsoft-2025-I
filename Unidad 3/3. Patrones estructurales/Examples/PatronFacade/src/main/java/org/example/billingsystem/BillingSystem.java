package org.example.billingsystem;

import org.example.util.Customer;
import org.example.util.OnMemoryDB;

public class BillingSystem {

    public double queryCustomerBalance(Long customerId){

        Customer customer = OnMemoryDB.customerFind(customerId);
        return customer.getBalance();

    }

    public double pay(BillingPayRequest request){

        Customer customer = OnMemoryDB.customerFind(request.getCustomerId());
        customer.setBalance(customer.getBalance() - request.getAmmount());
        System.out.println("Pago aplicado a cliente " + customer.getName() +", nuevo saldo: " + customer.getBalance() );
        return customer.getBalance();

    }
}
