package Entidades;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Enfrentable {
    protected String nombre;
    protected String nombreFantasia;

    public Enfrentable(String nombre, String nombreFantasia) {

        this.nombre = nombre;
        this.nombreFantasia = nombreFantasia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    abstract public float getValorAtributo(String key);

    /***
     * compara a este enfrentable contra el pasado por parametro
     * @param e enfrentable a combatir
     * @param c criterio a utilizar
     * @return el enfrentable e si e es mayor. O este enfrentable si es mayor o es cero #ResistirEsGanar

     */
    public  Enfrentable enfrentar(Enfrentable e, Comparator<Enfrentable> c){
       return (c.compare(this,e)>=0)? this : e;
    }


    public List<Personaje> odernar(Comparator<Enfrentable> c) {
       return this.getPersonaje().stream()
               .sorted(c)
               .collect(Collectors.toList());
    }

    protected  abstract  List<Personaje> getPersonaje();

}
