package Comparator;

import Entidades.Enfrentable;

import java.util.Comparator;

/***
 *  IMPORTANTE : Ordena por nombre real , no ficticio
 */
public class ComparatorNombre  implements Comparator<Enfrentable> {

    @Override
    public int compare(Enfrentable o1, Enfrentable o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
