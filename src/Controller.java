public class Controller {
    static Model model = new Model();
    static View view = new View();
    public static void main(String[] args) {
        IU.crearVentana();
    }
    public static void crearCoche(String modelo, String matricula){
        Coche aux = model.crearCoche(modelo,matricula);
        if(aux!=null){
            view.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    public static void bajarVelocidad(String matricula){
        int aux = model.bajarVelocidad(matricula);
        view.muestraVelocidad(matricula, aux);
    }

    public static void aumentarVelocidad(String matricula){
        int aux = model.subirVelocidad(matricula);
        view.muestraVelocidad(matricula,aux);
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
