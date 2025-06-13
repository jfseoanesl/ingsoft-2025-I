package org.example.encapsuladopormetodo;

public class TaxProcesor {

    public static double getTasaImpuesto(String pais){
        if(pais.equals("US")){
            return 0.07;
        }
        else if(pais.equals("EU")){

            return 0.05;

        }
        else {
            return  0.03;
        }

    }

}
