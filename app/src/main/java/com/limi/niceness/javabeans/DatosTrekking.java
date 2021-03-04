package com.limi.niceness.javabeans;

import com.limi.niceness.R;

import java.util.ArrayList;

public class DatosTrekking {

    private ArrayList<Item> datos;

    public DatosTrekking(){
        datos = new ArrayList<Item>();

        datos.add(new Item(R.drawable.t1, "MONTAÑA",
                "Ven a pasar un fin de semana con nosotros paseando por la montaña." +
                        "\n" + "\n" +
                        "#Naturaleza #Montaña","Ven a pasar un fin de semana con nosotros...."));
        datos.add(new Item(R.drawable.t2, "SENDERISMO EN GRUPO",
                "Si quiere hacer una ruta acompañado no dude en ponerse en contacto" +
                        "con nosotros, somos un grupo formado por 9 personas." +
                        "\n" + "\n" +
                        "#Ruta #Montaña #GrupoSenderismo", "Si quiere hacer una ruta acompañado..."));
        datos.add(new Item(R.drawable.t3, "ESCALADA EN LA NIEVE",
                "¿Quiere vivir una aventura?" +
                        "¿Le gusta el riesgo?" +
                        "En esta actividad se combinan ambas, la aventura y el riesgo." +
                        "Si la respuesta a las preguntas fue que SÍ, " +
                        "contacte conmigo: +34-698742530" +
                        "Luis Guerrero." +
                        "\n" + "\n" +"#Escalada #Nieve #Alpes #Francia", "¿Le gusta el riesgo?..."));
        datos.add(new Item(R.drawable.t4, "SENDERISMO POR EL CAMPO",
                "Disfrute de la naturaleza paseando por el campo, para ello es necesario llevar " +
                        "una mochila y sobretodo se precisa de un calzado cómodo." +
                        "\n" + "\n" +
                        "#Campo #Bosque #Senderismo", "Disfrute de la naturaleza paseando por el campo..."));
        datos.add(new Item(R.drawable.t5, "ACAMPADA",
                "Si le gustan los planes tranquilos, este anuncio es una buena opción," +
                        "porque le permite encontrar buenos sitios donde se pueda acampar, ya sea en grupo o en pareja." +
                        "\n" + "\n" +
                        "#Camping #Atardecer #Naturaleza #Relax", "Si le gustan los planes tranquilos, este anuncio..."));
        datos.add(new Item(R.drawable.t6, "SNOWBOARD",
                "Busco gente que le guste este deporte." +
                        "Dejo mi número, 684120069, para crear un grupo de chat y asi poder quedar " +
                        "\n" + "\n" +
                        "y juntos practicar lo que más nos gusta." +
                        "#Snowboard #Nieve #Sky #Andorra", "Busco gente que le guste este deporte..."));

    }

    public ArrayList<Item> getDatos() {
        return datos;
    }
}
