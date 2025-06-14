package org.example.util;

import org.example.util.Card;
import org.example.util.Customer;

import java.util.HashMap;
import java.util.Map;

public class OnMemoryDB {

    private static final Map<Long, Customer> customers = new HashMap<>();
    private static final Map<String, Card> cards = new HashMap<>();

    static{

        customers.put(1L, new Customer(1L, "Brayan Badillo", 500, "Suspendido"));
        customers.put(2L, new Customer(2L, "Willian Yaruro", 300, "Suspendido"));
        customers.put(3L, new Customer(3L, "Carlos Jimenez", 100, "Activo"));
        customers.put(3L, new Customer(3L, "lizeth Estrada", 100, "Baja"));

        cards.put("123", new Card("123", "VISA", "Credit"));
        cards.put("234", new Card("234", "MASTERCARD", "Debit"));
        cards.put("345", new Card("345", "AMEX", "Credit"));

    }

    public static Customer customerFind(Long id){

        return customers.get(id);

    }

    public static void changeCustomerStatus(Long id, String newStatus){

        Customer customer = customerFind(id);
        customer.setStatus(newStatus);
        System.out.println("cambio de status de " + customer.getName() + ", nuevo status:" + customer.getStatus() +  "\n");
    }

    public static boolean validateCardBins(String creditCardPrefix){
        if(cards.containsKey(creditCardPrefix)){
            Card creditCard = cards.get(creditCardPrefix);
            System.out.println("Tarjeta valida >  " + creditCard.getCompany() +"\n");
            return true;
        }
        else{
            System.out.println("Tarjeta invalida > \n");
            return false;
        }
    }

    public static String getCardCompany(String creditCardPrefix){
        if(cards.containsKey(creditCardPrefix)){
            return cards.get(creditCardPrefix).getCompany();

        }
        throw new RuntimeException("Tarjeta no existe");
    }
}
