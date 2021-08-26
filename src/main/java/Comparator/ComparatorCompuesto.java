package Comparator;

import Entidades.Enfrentable;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ComparatorCompuesto implements Comparator<Enfrentable> {
    private List<Comparator<Enfrentable>> comparators;

    public ComparatorCompuesto(List<Comparator<Enfrentable>> comparators) {
        this.comparators = comparators;
    }

    public ComparatorCompuesto() {
        // en caso de no pasar una list, se crea una para evitar null pointer
        comparators = new LinkedList<>();
    }

    public boolean addComparator(Comparator<Enfrentable> c) {
        if (comparators.contains(c)) return false;
        comparators.add(c);
        return true;
    }

    public boolean addComparator(Comparator<Enfrentable> c, int index ){
        if (comparators.contains(c)) return false;
        comparators.add(index,c);
        return true;

    }


    @Override
    public int compare(Enfrentable o1, Enfrentable o2) {

        for (var comparator : comparators) {
            var comparation = comparator.compare(o1, o2);
            if (comparation != 0){
                return comparation;
            }
        }
        // Si atraveso el for sigrnifica que empatan en todas las comps
        return 0;
    }
}
