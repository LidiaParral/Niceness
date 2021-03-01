package com.limi.niceness.javabeans;


import com.limi.niceness.R;

import java.util.ArrayList;

public class Datos {

    private ArrayList<Item> datos;

    public Datos(){
        datos = new ArrayList<Item>();

        datos.add(new Item(R.drawable.trekking, "TREKKING",
                "Estamos creando un grupo para hacer rutas por las montañas\n" +
                        "Si quieres unirte, contacta con nosotros.\n" +
                        "#Ruta #Montains #Nature\n"));
        datos.add(new Item(R.drawable.yoga, "YOGA",
                "¿Quién se apunta el domingo 10:00h  a una clase de yoga?\n" +
                        "#Relax #Yoga #AireLibre"));
        datos.add(new Item(R.drawable.equitacion, "EQUITACION",
                "Si te gustan los animales y la naturaleza, este es tu grupo favorito"));
        datos.add(new Item(R.drawable.shopping, "SHOPPING",
                "Si eres una persona mayor o tienes dificultades para hacer la compra.\n" +
                        "No dudes en ponerte en contacto conmigo y yo encantada te la haré.\n" +
                        "#Shop #Market \n" +
                        "\n" +
                        "María Velazquez @mariavqz"));
        datos.add(new Item(R.drawable.anciana, "ANCIANOS",
                "Me ofrezco para cuidar a las personas mayores , no dude en escribirme." +
                "\n" +
                "Guillermo Martín @guilleMartinLopez"));
        datos.add(new Item(R.drawable.savethechildren, "NIÑOS",
                "Me ofrezco para dar clase a los niños entre 5 - 12 años , soy maestra de educación primaria." +
                        "\n" +
                        "Elena Pérez @Happysmile"));

    }

    public ArrayList<Item> getDatos() {
        return datos;
    }
}
