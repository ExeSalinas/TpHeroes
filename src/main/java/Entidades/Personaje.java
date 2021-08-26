package Entidades;

import Atributo.Atributo;

import java.util.HashMap;
import java.util.List;

public class Personaje extends Enfrentable {
    private HashMap<String, Atributo> atributos = new HashMap<String, Atributo>();

    public Personaje(String nombre, String nombreFantasia) {
        super(nombre, nombreFantasia);
    }


    @Override
    public float getValorAtributo(String key) {
        var atr = atributos.get(key);
        //si es null no esta en el map
        if (atr == null) {
            return 0f;
        }
        return atr.getValor(this);
    }


    @Override
    protected List<Personaje> getPersonaje() {
        return List.of(this);
    }

    /**
     * No contempra repiticiones. Si ya posee un atributo con el
     * mismonombre retorna falso
     *
     * @param name
     * @param atr
     * @return false si contenia el atr , true si no
     */
    public boolean addAtributo(String name, Atributo atr) {
        if (atributos.containsKey(name)) {
            return false;
        }
        this.atributos.put(name, atr);
        return true;
    }

    @Override
    public String toString() {
        var str = new StringBuilder().append("\n Personaje : ").append(nombreFantasia).append("\n").append("ATRIBUTOS : { \n");
        for (var atr : atributos.entrySet()) {
            str.append(atr.getKey()).append(": ");
            str.append(atr.getValue().getValor(this));
            str.append("\n");
        }
        return str.append("}\n").toString();
    }
}
