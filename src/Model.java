import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
    static ArrayList<Coche> parking = new ArrayList<>();


    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Al cambiar la velocidad se da cuenta del cambio
     * y notifica al observer
     * @param matricula
     * @param v nueva velocidad
     */
    public void cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        // parametro cambia
        setChanged();
        // notifica del cambio
        notifyObservers(getCoche(matricula));
    }

    /**
     * Al cambiar la velocidad se da cuenta del cambio
     * y notifica al observer
     * @param matricula
     */
    public void subirVelocidad(String matricula) {
        getCoche(matricula).velocidad = getCoche(matricula).velocidad + 10;
        // parametro cambia
        setChanged();
        //notifica al observer
        notifyObservers(getCoche(matricula));
    }

    /**
     * Al cambiar la velocidad se da cuenta del cambio
     * y notifica al observer
     * @param matricula
     */
    public void bajarVelocidad(String matricula) {
        getCoche(matricula).velocidad = getCoche(matricula).velocidad - 10;
        // parametro cambia
        setChanged();
        //notifica al observer
        notifyObservers(getCoche(matricula));

    }

    /**
     * Busca coche según matricula
     * @param matricula a buscar
     * @return Coche o null (si no existe)
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Devuelve el modelo a partir de la matricula
     * @param matricula
     * @return
     */
    public String getModelo(String matricula) {
        return getCoche(matricula).modelo;
    }

    /**
     * Devuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}