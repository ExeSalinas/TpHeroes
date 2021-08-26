import Atributo.AtributoCondicional;
import Atributo.AtributoOperacion;
import Atributo.AtributoSimple;
import Comparator.ComparatorCompuesto;
import Comparator.ComparatorCriterioSimple;
import Comparator.ComparatorNombre;
import Entidades.Enfrentable;
import Entidades.Juego;
import Entidades.Liga;
import Entidades.Personaje;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Juego juego = new Juego();

//        Personajes
        Personaje e1 = new Personaje("Bruce Wayne", "Batman");
        Personaje e2 = new Personaje("Peter Parker", "Spiderman");
        Personaje e3 = new Personaje("Principe Adam", "He-Man");
        Personaje e4 = new Personaje("Lex Luthor", "Lex Luthor");
        Personaje e5 = new Personaje("Moriarty", "Profesor Moriarty");


        // SIMPLES
        e1.addAtributo("Tecnologia", new AtributoSimple(80f));
        e1.addAtributo("Astucia", new AtributoSimple(96.8f));

//        System.out.println("Agregando duplicados "+ ( e1.addAtributo("Astucia" , new AtributoSimple(90f))));


        // Operacion
        e1.addAtributo("Herramientas", new AtributoOperacion("Tecnologia", "Astucia") {
            @Override
            public float getValor(Enfrentable e) {
                return e.getValorAtributo(key1) + e.getValorAtributo(key2);
            }
        });
        //Condicionales

        e1.addAtributo("Supertraje", new AtributoCondicional("Tecnologia", "Fuerza"
                , new AtributoSimple(80f), new AtributoSimple(20f)));

//        // MODIFICACIONES SOBRE EL ATRIB CONDICIONAL
//        System.out.println("Supertraje " + e1.getValorAtributo("Supertraje"));
//        e1.addAtributo("Fuerza", new AtributoSimple(100f));
//        System.out.println("Supertraje , ahora que tiene fuerza " + e1.getValorAtributo("Supertraje") + " (Y si , ya no lo necesita)");


        //Mock de el resto
        e2.addAtributo("Astucia", new AtributoSimple(70f));
        e3.addAtributo("Astucia", new AtributoSimple(30f));
        e4.addAtributo("Astucia", new AtributoSimple(96f));
        e5.addAtributo("Astucia", new AtributoSimple(96f));

        Liga l1 = new Liga("Liga 1", "Los Buenos");
        Liga l2 = new Liga("Liga 2", "Los Genios");
        Liga l3 = new Liga("Liga 3", "Dream Team");

        l1.addIntegrante(e1);
        // No agrega 2 veces
        l1.addIntegrante(e1);
        l1.addIntegrante(e2);

        l2.addIntegrante(e1);
        l2.addIntegrante(e4);
        l2.addIntegrante(e5);

        l3.addIntegrante(l1);
        l3.addIntegrante(l2);
        l3.addIntegrante(e2);


        Stream.of(e1, e2, e3, e4, e5, l1, l2, l3).forEach(juego::addEnfrentable);

//       MUESTRA TODOS LOS ENFRENTABLES
//       System.out.println(juego);

//        Muestra los valors de atr para liga l1 y personaje e1
//        System.out.println(l1.getValorAtributo("Astucia") + " " + e1.getValorAtributo("Astucia"));

//        VENCEN A HEMAN

//        var vencenHeman = juego.getQuienesVencen(e3, new ComparatorCriterioSimple("Astucia"));
//        System.out.println("Vencedores He Man " + e3.getValorAtributo("Astucia"));
//        for (var vencedor : vencenHeman) {
//            System.out.println(vencedor.getNombreFantasia() + " " + vencedor.getValorAtributo("Astucia"));
//        }

//        VENCEN A MORIARTY

//        var vencenMoriarty = juego.getQuienesVencen(e5, new ComparatorCriterioSimple("Astucia"));
//        System.out.println("Vencedores Moriarty " + e5.getValorAtributo("Astucia"));
//        for (var vencedor : vencenMoriarty) {
//            System.out.println(vencedor.getNombreFantasia() + vencedor.getValorAtributo("Astucia"));
//        }


//        // LISTAR POR CRITERIO COMPUESTO
//
//        var c = new ComparatorCompuesto();
//        c.addComparator(new ComparatorCriterioSimple("Astucia"));
//        c.addComparator(new ComparatorNombre().reversed());
//        var ordenada =  juego.ordenarPersonajes(c);
//
//        ordenada.forEach((elem)-> System.out.println(elem.getNombre() +" " + elem.getValorAtributo("Astucia")));
//        System.out.println("Notar como moriarty y Lex empatan en el atributo, desempatan por nombre, pero como esta reversed queda M antes que L ");
//
////

    }


}
