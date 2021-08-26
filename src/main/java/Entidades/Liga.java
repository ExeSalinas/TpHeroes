package Entidades;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Liga extends Enfrentable {

    private List<Enfrentable> integrantes = new LinkedList<>();

    public Liga(String nombre, String nombreFantasia, List<Enfrentable> integrantes) {
        super(nombre, nombreFantasia);
        this.integrantes = integrantes;
    }

    public Liga(String nombre, String nombreFantasia) {
        super(nombre, nombreFantasia);
    }

    /***
     * Agrega integrante a la liga. No permite duplicados.
     * @param e
     * @return false si estaba el integrante en la lista
     * true si no
     */
    public boolean addIntegrante(Enfrentable e) {

        if (integrantes.contains(e)) return false;
        integrantes.add(e);
        return true;
    }

    @Override
    public float getValorAtributo(String key) {
        float sum = 0;
        for (Enfrentable e : integrantes ) {
            sum += e.getValorAtributo(key);
        }
        return sum/getPersonaje().size();
    }

    @Override
    protected List<Personaje> getPersonaje() {
        List<Personaje> list = new LinkedList<>();
        for (Enfrentable e : integrantes) {
            list.addAll(e.getPersonaje());
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Liga :" + nombreFantasia);

        return str.append(integrantes.stream()
                .map(Enfrentable::toString)
                .collect(Collectors.joining()))
                .toString();
    }
}
