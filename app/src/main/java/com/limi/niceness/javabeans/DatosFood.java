package com.limi.niceness.javabeans;

import com.limi.niceness.R;

import java.util.ArrayList;

public class DatosFood {

    private ArrayList<Item> datos;

    public DatosFood(){
        datos = new ArrayList<Item>();

        datos.add(new Item(R.drawable.f1, "MEETING COFFEE",
                "Hola ¿qué tal?, llevo un tiempo fuera de Castellón.Me gustaría charlar con alguien" +
                        " mientras nos tomamos un café." + "\n" +
                        " Soy mayor, de 64 años.Pero creo que eso no importa para hacer amistades y poder" +
                        " conocer gente" + "\n" +"\n" +
                        "#Coffee #Cafetería #Bollería #Food","Hola ¿qué tal?, llevo un tiempo fuera de Castellón..."));
        datos.add(new Item(R.drawable.f2, "RECETAS VEGETARIANAS",
                "Desde hace un par de años me dí cuenta que comer sano es lo más importante" +
                        "hoy en día porque tu salud depende de los que comes. Os dejo un link donde se pueden" +
                        "encontrar recetas vegetarianas. https://www.directoalpaladar.com/tag/recetas-vegetarianas" +
                        "\n" +"\n" +
                        "#Receta #Vegetarian #Food #Healthy","Desde hace un par de años me dí cuenta que comer sano..."));
        datos.add(new Item(R.drawable.f4, "COMPRA ON-LINE",
                "Comprar comida online: tuppers caseros, directo del productor, jamón, vino, aceite de oliva, carne, fruta... " +
                        "La mayor selección de alimentación online." + "\n" +
                        "Nuestra páginas web: https://www.mentta.es/ " + "\n" +"\n" +
                    "#Food #Online #ShoppingBag #Mentta","Comprar comida online: tuppers caseros, directo del productor..."));
        datos.add(new Item(R.drawable.f5, "HAGO LA COMPRA POR TI",
                "Buenos días, soy Roberto Díaz, me ofrezco para ir al supermercado y hacer la compra" +
                        "a gente que no pueda hacerlo, ya sea por motivos de tiempo o por dificultades de movilidad." +
                        "\n" +"\n" +
                        "#Food #Supermercado #Mercadona #Carrefour","Buenos días, soy Roberto Díaz, me ofrezco para ir al supermercado..."));

    }

    public ArrayList<Item> getDatos() {
        return datos;
    }
}
