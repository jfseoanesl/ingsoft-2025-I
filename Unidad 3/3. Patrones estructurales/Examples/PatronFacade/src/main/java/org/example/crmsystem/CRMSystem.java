package org.example.crmsystem;


import org.example.util.Customer;
import org.example.util.OnMemoryDB;

public class CRMSystem {

    public Customer findCustomer(Long customerId){
        return OnMemoryDB.customerFind(customerId);
    }


}
