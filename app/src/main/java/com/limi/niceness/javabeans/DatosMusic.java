package com.limi.niceness.javabeans;

import com.limi.niceness.R;

import java.util.ArrayList;

public class DatosMusic {

    private ArrayList<Item> datos;

    public DatosMusic(){
        datos = new ArrayList<Item>();

        datos.add(new Item(R.drawable.m1, "SPOTIFY",
                "¿Cuales son las canciones más escuchando en el 2020?" +  "\n" +
                        "Busca en está enlace para estar al día." + "\n" +
                        "web: https://www.elmundo.es/cultura/2020/12/01/5fc60292fdddffdd018b45ab.html" +
                        "\n" +"\n" +
                        "#Música #Spotify #BadBunny #TopMusic","¿Cuales son las canciones más escuchando en el 2020?..."));
        datos.add(new Item(R.drawable.m2, "ENSAYA CON TU GRUPO",
                "Si busca un local para ensayar con su grupo, no dude en contactar " +
                        "conmigo." + "\n" +
                        "Mi número: +34-624103569" +
                        "\n" +"\n" +
                        "#Música #Ensayo #Banda #Batería","Si busca un local para ensayar con su grupo,..."));
        datos.add(new Item(R.drawable.m3, "CURSO DE GUITARRA",
                "Me ofrezco para dar clases de guitarra clásica española" +
                        "El horario lo elige usted, sólo dígame el día y la hora." + "\n" +
                        "Nadia Morales" +
                        "\n" +"\n" +
                        "#Guitarra #Flamenco #Instrumentos #Música","Me ofrezco para dar clases de guitarra..."));
        datos.add(new Item(R.drawable.m4, "MUSIC DJ",
                "Hago sesiones DJ en directo en mi Facebook, si te gusta este tipo de música" +
                        "agregame y disfruta del directo" + "\n" +
                        "Facebook: https://es-es.facebook.com/DjNevOficial" +
                        "\n" +"\n" +
                        "#Música #DJ #Hardcore","Hago sesiones DJ en directo en mi Facebook,..."));
        datos.add(new Item(R.drawable.m5, "CLASES DE PIANO",
                "Si quiere aprender a tocar el piano, yo puedo ser su profesor particular." + "\n" +
                        "Las clases se imparten en L-X de 17:30 a 19:30." +
                        "\n" +"\n" +
                        "#Piano #Teclas #Do #Pentagrama #Música","Si quiere aprender a tocar el piano"));

    }

    public ArrayList<Item> getDatos() {
        return datos;
    }
}
