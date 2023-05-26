## Diagrama de clases:

```mermaid
classDiagram
    class Observable {
        setChanged()
        notifyObserver(valor)
    }
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
    class Controller{
        +main()
        +crearCoche(String, String)
        +subirVelocidad(String)
        +bajarVelocidad(String)
        +buscarCoche(String)
    }
      
    class View {
        +muestraVelocidad(String, Integer)
        +muestraBusqueda(String, String, Integer)
    }
      
    class Model {
        ArrayList~Coche~: parking
        +crearCoche(String, String, String)
        +cambiarVelocidad(String, Integer)
        +bajarVelocidad(Integer v)
        +subirVelocidad(Integer v)
        +getCoche(String)
        +getModelo(String)
        +getVelocidad(String)
    }
      
    class IU { crearVentana() }
      
    class Dialog { msjDialog() }
      
    class ObserverVelocidad { +update() }
    
    Controller "1" *-- "1" ObserverVelocidad: association
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    Observable <|-- Model
    View "1" *-- "1" IU : association
    View "1" *-- "1" Dialog : association
```

---

## Pasos para crear el observer

1. Model
    * Extiende de `Observable`
    * En el método en donde ocurra el cambio (en nuestro caso cambiarVelocidad, subirVelocidad y bajarVelocidad):
        * setChanged()
        * notifyObserver(Valor) -> en este caso: notifyObserver(getCoche(matricula))
        
2. Crear una clase que sea el observador, que implementa la interface `Observer` (ObserverVelocidadMax)
    * definir el método `update()`
    * definir las condiciones en las que avisará
    
3. Controller
    * Instanciar el observer
    * Añadir este observer al observable con `addObserver()`

---

## Evento en la Vista con el Observer
Este sería el diagrama de secuencias explicado de forma general
```mermaid
sequenceDiagram
    actor usuario
    participant View
    participant Controller
    participant Model
    participant ObsExceso
    
    usuario->>View: Click! Crear coche
    View->>Controller: El usuario quiere crear un coche
    activate Controller
    Controller->>Model: Crea un coche, porfa
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>View: ok, coche creado!
    deactivate Controller
    View-->>usuario: Tu coche se creó!
    
    usuario->>View: Click! Subir velocidad
    View->>Controller: El usuario quiere subir la velocidad
    activate Controller
    Controller->>Model: Sube la velocidad, porfa
    activate Model
    Model-->>ObsExceso: Sube la Velocidad
    activate ObsExceso
    ObsExceso-->>View: Cambio en la velocidad
    View-->usuario: Alerta! (si la velocidad supera los 120km/h)
```

---
