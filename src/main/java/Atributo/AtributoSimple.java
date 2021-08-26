package Atributo;

import Entidades.Enfrentable;

public class AtributoSimple implements Atributo{
    private float value;

    public AtributoSimple(float value) {
        this.value = value;
    }

    @Override
    public float getValor(Enfrentable e) {
        return  value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
