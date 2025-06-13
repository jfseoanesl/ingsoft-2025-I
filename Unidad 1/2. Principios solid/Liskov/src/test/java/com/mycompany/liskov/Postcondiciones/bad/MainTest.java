package com.mycompany.liskov.Postcondiciones.bad;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testLisko(){

        CuentaBancaria cuenta = new CuentaDeposito();
        cuenta.depositar(5000);
        cuenta.retirar(500);
        assertEquals(4500, cuenta.getSaldo(),0);

    }

}