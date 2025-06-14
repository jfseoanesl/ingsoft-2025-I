package org.example.emailsystem;

import java.sql.SQLOutput;
import java.util.Map;

public class EmailSystem {

    public void sendEmail(Map<String, String> values){

        String templete="\n**********************************************\n"+
                "|To: $name\n"+
                "|From: FacadeSystem\n"+
                "|\n"+
                "|Muchas gracias por utilizar el servicio en\n"+
                "|linea para realizar sus pagos\n"+
                "|Hace un momento acabamos de recibir un pago:\n"+
                "|\n"+
                "|Monto del pago: $ammount,\n"+
                "|Nuevo saldo: $newBalance\n"+
                "|Tarjeta terminacion: $cardNumber\n"+
                "|Referencia del pago: $reference\n"+
                "|Nuevo status: $newStatus\n"+
                "|\n"+
                "|Gracias por su prefernecia\n";

        for(String str: values.keySet()){
            templete = templete.replace(str, values.get(str));
        }

        System.out.println(templete);

    }
}
