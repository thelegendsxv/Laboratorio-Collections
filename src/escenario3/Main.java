package escenario3;

public class Main {
    public static void main(String[] args) {
        
  
    Plataforma p = new Plataforma();

    p.registrarViajes( 1, "Jose", "Parque");
    p.registrarViajes( 2, "Maria", "Hospital");
    p.registrarViajes( 3, "Ana", "Universidad");
    p.registrarViajes( 1, "Alejo", "colegio");

  

        System.out.println("Mostrar solicitudes pendientes:");
        p.mostrarPendientes();

        p.cancelarSolicitud(2);

        System.out.println("Mostrar solicitudes pendientes:");
        p.mostrarPendientes();
    
    }
}
