package com.limi.niceness.javabeans;

import com.limi.niceness.R;

import java.util.ArrayList;

public class DatosHome {

    private ArrayList<Item> datos;

    public DatosHome(){
        datos = new ArrayList<Item>();

        datos.add(new Item(R.drawable.h1, "PINTAMOS TU CASA",
                "Si estas buscando a alguien de confianza para pintar su casa." + "\n" +
                        "Contacte con nosotros: +34-665230155" +
                        "\n" +"\n" +
                        "#Pintura #Home #Brocha","Si estas buscando a alguien de confianza..."));
        datos.add(new Item(R.drawable.h2, "HERRAMIENTAS",
                "Hola, vengo buscando si alguien pudiera regalarme una llave inglesa" +
                        "que con estos tiempos que corren no me lo puedo permitir." + "\n" +
                        "Lo agradecería, se me ha estropeado el coche y necesito arreglarlo" +
                        "\n" +"\n" +
                        "#Herramientas #LlaveInglesa #Bricolaje #Home","Hola, vengo buscando si alguien pudiera regalarme..."));
        datos.add(new Item(R.drawable.h3, "FONTANERO A DOMICILIO",
                "Expertos en solucionar cualquier averia de gas, nuevas instalaciones individuales" +
                        " o comunitarias, calderas, calentadores, evacuaciones de humos, tallos, montantes, correccion " +
                        "de defectos, llaves de corte, evacuacion de humos. etc. Su seguridad en buenas manos. " +  "\n" +
                        "Enrique Toledo, +34-676220143" +
                        "\n" +"\n" +
                        "#Tuberías #Fontanero #GrifoGotea #Home","Expertos en solucionar cualquier averia de gas,..."));
        datos.add(new Item(R.drawable.h4, "REPARACIONES DE LUZ",
                "¿Necesitas un electricista?" + "\n" +
                        "Somos tu empresa indicada, hacemos instalaciones, reparaciones," +
                        "urgencias 24 horas, porteros automáticos y mucho más.. " + "\n" +
                        "Presupuesto sin compromiso." + "\n" +
                        "Contacte con nosotros: +34-682801236." +
                        "\n" +"\n" +
                        "#Electricidad #Luz #Urgencias24h #Home","¿Necesitas un electricista?..."));
        datos.add(new Item(R.drawable.h5, "CHAPA Y PINTURA",
                "Buen precio" + "\n" +
                        "Todo tipo de trabajos en chapa y pintura:" + "\n" +
                        "-Cabina propia" + "\n" +
                        "-Pinturas de primera calidad" + "\n" +
                        "-Bancada" + "\n" +
                        "Con garantía de profesional." + "\n" +"\n" +
                    "Talleres Framancar." +"\n" +
                    "web: http://www.framancar.com/" + "\n" +"\n" +
                    "#Taller #Coche #Pintura #Home","Buen precio" + "\n" + "Todo tipo de trabajos en chapa y pintura..."));

    }

    public ArrayList<Item> getDatos() {
        return datos;
    }
}
