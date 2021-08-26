package Atributo;

import Entidades.Enfrentable;

public class AtributoCondicional implements Atributo {
    private String key1;
    private String key2;
    private Atributo keyThen;
    private Atributo keyElse;

    /***
     * Siempre va a preguntar si el valor de k1 es mayor que k2
     * @param key1
     * @param key2
     * @param keyThen
     * @param keyElse
     */
    public AtributoCondicional(String key1, String key2, Atributo keyThen, Atributo keyElse) {

        this.key1 = key1;
        this.key2 = key2;
        this.keyThen = keyThen;
        this.keyElse = keyElse;
    }

    @Override
    public float getValor(Enfrentable e) {
        var v1 = e.getValorAtributo(key1);
        var v2 = e.getValorAtributo(key2);
        return (v1 > v2) ? keyThen.getValor(e)
                : keyElse.getValor(e);
    }


}
