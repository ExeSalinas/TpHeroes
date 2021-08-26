package Comparator;

import Entidades.Enfrentable;

import java.util.Comparator;

public class ComparatorCriterioSimple implements Comparator<Enfrentable> {
    private String atributo;

    public ComparatorCriterioSimple(String atributo) {
        this.atributo = atributo;
    }

    @Override
    public int compare(Enfrentable o1, Enfrentable o2) {
        var aux = (o1.getValorAtributo(atributo) - o2.getValorAtributo(atributo));
        return (int) Math.round(aux) ;


    }
}
