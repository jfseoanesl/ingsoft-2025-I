package com.mycompany.singleresponsability.bad;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ParkingManager {

    public static double calcularCostoParqueo(Vehiculo v, LocalTime ingreso, LocalTime salida){
        long horas = ChronoUnit.HOURS.between(salida, ingreso);
        return  Vehiculo.TARIFA * horas;
    }

}
