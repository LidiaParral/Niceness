package com.limi.niceness.javabeans;

import com.limi.niceness.R;

import java.util.ArrayList;

public class DatosTechnology {

    private ArrayList<Item> datos;

    public DatosTechnology(){
        datos = new ArrayList<Item>();

        datos.add(new Item(R.drawable.tec1, "AYUDA EN INTERNET",
                "¿Tiene problemas con Internet?," + "\n" +
                        "No se preocupe, yo puedo echarle una mano. Le dejo mi correo electrónico: mariaGonzalez@gmail.com" +
                        "para que pueda contactar conmigo y asi solucionarle sus problemas con la red." +
                        "\n" + "\n" +
                        "#Internet #Ordenador #Web", "¿Tiene problemas con Internet?..."));
        datos.add(new Item(R.drawable.tec2, "PROGRAMACIÓN",
                "Hola, busco a alguien que me pueda ayudar a resolver un error que " +
                        "tengo en el código de una aplicación." + "\n" +
                        "Dejo mi repositorio de GitHub para que le echen un vistazo:" +
                        "https://github.com/jorge17204" +
                        "\n" +"\n" +
                        "#GitHub #JAVA #AndroidStudio #DiseñoApp", "Hola, busco a alguien que me pueda ayudar..."));
        datos.add(new Item(R.drawable.tec3, "PARTIDA DE VIDEOJUEGOS",
                "Busco gente que quiera jugar unas partidas al Call Of Duty. Me gustaría formar un equipo" +
                        "y ganar a los enemigos." + "\n" +
                        "Mi número: +34-633145789" +
                        "\n" +"\n" +
                        "#Videojuego #CallOfDuty #PlayStation4", "Busco gente que quiera jugar unas partidas..."));
        datos.add(new Item(R.drawable.tec4, "VIDEOJUEGO ON-LINE",
                "Quiero formar parte de un TEAM, me gustaría conocer gente de todo el mundo" +
                        "y jugar al Fortnite en una partida on-line" +
                        "\n" +"\n" +
                        "#Fortnite #PartidaOnline #Skins","Quiero formar parte de un TEAM,..."));

    }

    public ArrayList<Item> getDatos() {
        return datos;
    }
}
