public class View {
    boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }

    void muestraBusqueda(String modelo, String matricula, Integer v){
        System.out.println("RESULTADO DE LA BUSQUEDA: "
                +"\nModelo: "+modelo
                +"\nMatricula: "+matricula
                +"\nVelocidad: "+v);
    }
}
