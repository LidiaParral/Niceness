package com.limi.niceness.javabeans;

import com.limi.niceness.R;

import java.util.ArrayList;

public class DatosAnimals {

    private ArrayList<Item> datos;

    public DatosAnimals(){
        datos = new ArrayList<Item>();

        datos.add(new Item(R.drawable.a1, "AMIGOS PERRUNOS",
                "Si no tienes tiempo para pasear a tu mascota o el cansancio por la rutina."
                        + "te lo impide, no dudes en llamarme, con un paseo diario estas protegiendo su salud." +"\n" +
                        "Un perro que no pasea a diario no es un perro feliz" + "\n" +"\n" +
                        "Mi número:+34-693222185" + "\n" +"\n" +
                         "#Perros #Pipican #Paseo #Animales","Si no tienes tiempo para pasear a tu mascota..."));
        datos.add(new Item(R.drawable.a2, "MASCOTAS FELICES",
                "Buenos días, me ofrezco a llevar a sus mascotas al veterinario," +
                        "cuando usted no pueda. Ser responsables de la salud de sus mascotas." + "\n" +"\n" +
                        "#Veterinario #Mascotas #Animales #Salud","Buenos días, me ofrezco a llevar a sus mascotas al veterinario..."));
        datos.add(new Item(R.drawable.a3, "PASEO A TU PERRO",
                "Me gustaría formar un grupo de chat, para poder quedar y reunir a" +
                        " nuestros amigos perrunos para que puedan disfrutar juntos."+ "\n" +"\n" +
                        "#Perros #Pipican #Paseo #Animales","Me gustaría formar un grupo de chat, para..."));
        datos.add(new Item(R.drawable.a4, "CUIDADOR DE FELINOS",
                "Cuidamos de tu gato, como si fuera nuestro, durante tus vacaciones, viajes, escapadas" +"\n" +
                    "Lo cuidamos en tu domicilio o si lo prefieres lo recogemos y lo cuidamos en el nuestro" + "\n" +
                    "Llámanos y te informamos sin compromiso, me llamo Mabel y mi número es 669988501" +"\n" +"\n" +
                    "#Felinos #Gatos #Cuidados #Animales","Cuidamos de tu gato, como si fuera nuestro, durante tus vacaciones,..."));
        datos.add(new Item(R.drawable.a5, "EQUITACION",
                "Empezar desde cero al manejo y monta a caballo.En un entorno natural libre de vallas y cercas." +
                        "El mejor centro ecuestre de la provincia. Para mas informacion contacten con nosotros." + "\n" +
                        " CENTRO ECUESTRE EL HIGUERAL" + "\n" +"\n" +
                        "#Caballos #Hipica #Animales","Empezar desde cero al manejo y monta a caballo..."));
        datos.add(new Item(R.drawable.a6, "PASEO A CABALLO",
                "Somos una joven pareja apasionada del mundo del caballo ven te enseñaremos nuestra forma de vida " +
                        "donde el caballo es parte de nuestra familia.También hacemos clases y rutas para todos los niveles," +
                        "direcciones, técnicas, además te asesoramos y te ayudamos a buscar un caballo o incluso te podemos alquilar uno" +
                        " de los nuestros. " + "\n" +
                        "Vengan a conocernos no se arrepentirán"  + "\n" +"\n" +
                        "#Ruta #Paisajes #Caballos #Hipica #Animales","Somos una joven pareja apasionada del mundo del caballo..."));

    }

    public ArrayList<Item> getDatos() {
        return datos;
    }
}
