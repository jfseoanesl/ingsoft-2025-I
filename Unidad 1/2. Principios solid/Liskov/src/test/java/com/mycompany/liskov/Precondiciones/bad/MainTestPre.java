package com.mycompany.liskov.Precondiciones.bad;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTestPre {

    @Test
    public void liskovTest(){
        CuentaBancaria cuenta = new CuentaProtegida(1000.0);
        cuenta.retirar(600.0);
        assertEquals(400.0,cuenta.getSaldo(),0.0);
    }

}