package Entidades;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Juego {

    private List<Enfrentable> enfrentables = new LinkedList<>();

    public Juego() {

    }

    public List<Enfrentable> getQuienesVencen(Enfrentable e, Comparator<Enfrentable> c) {
        return enfrentables.stream()
                .map(contendientes -> enfrentar(e, contendientes, c))
                .filter(ganadores -> !ganadores.nombre.equals(e.nombre))
                .collect(Collectors.toList());
    }

    public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator<Enfrentable> c) {
        return e1.enfrentar(e2, c);
    }

    public boolean addEnfrentable(Enfrentable e) {
        if (enfrentables.contains(e)) return false;
        enfrentables.add(e);
        return true;
    }

    public List<Personaje> ordenarPersonajes ( Comparator<Enfrentable> c) {

        List<Personaje> ordenada = new LinkedList<>();
        enfrentables.stream()
                .forEach(enfrentable -> ordenada.addAll(enfrentable.odernar(c)));
        return ordenada;

    }

    @Override
    public String toString() {
        return "Juego con Enfrentables: " + enfrentables ;
    }
}
