public class Controller {
    static Model model = new Model();
    static View view = new View();
    public static void main(String[] args) {
        // Creamos un objeto del 'observer'
        ObserverVelocidadMax obsVelMax = new ObserverVelocidadMax();
        // Usamos el método addObserver para añadir un observer
        model.addObserver(obsVelMax);

        IU.crearVentana();
    }
    public static void crearCoche(String modelo, String matricula){
        Coche aux = model.crearCoche(modelo,matricula);
        if(aux!=null){
            view.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    public static void bajarVelocidad(String matricula){
        model.bajarVelocidad(matricula);
        Integer v = model.getVelocidad(matricula);
        view.muestraVelocidad(matricula,v);
    }

    public static void subirVelocidad(String matricula){
        model.subirVelocidad(matricula);
        Integer v = model.getVelocidad(matricula);
        view.muestraVelocidad(matricula,v);
    }

    /**
     * Metodo que a partir de una matricula devuelve el modelo y la velocidad
     * del coche asociado a esa matricula
     * @param matricula
     */
    public static void buscarCoche(String matricula){
        String modelo = model.getModelo(matricula);
        int v = model.getVelocidad(matricula);

        view.muestraBusqueda(modelo,matricula,v);
    }
}
