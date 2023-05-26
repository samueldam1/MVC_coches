import java.util.Observable;
import java.util.Observer;

public class ObserverVelocidadMax implements Observer {

        static Model model = new Model();

    /**
     * Este método es llamado siempre que hay un cambio en la velocidad
     * Mandará una alerta por consola cada vez que la velocidad supere 120km/h
     * @param o     objecto observable
     * @param arg   argumento pasado por los metodos {@code notifyObservers}
     */
    @Override
    public void update(Observable o, Object arg) {
        // Hacemos cast para poder trabajar con un objeto Coche
        Coche auxCoche = (Coche) arg;

        // Este 'if' compara la velocidad cada vez que hay un cambio en esta, si supera los 120 manda una alerta
        if (model.getVelocidad(auxCoche.matricula)>120){
            System.out.println("ALERTA: ¡Velociad excedida!");
        }

    }
}