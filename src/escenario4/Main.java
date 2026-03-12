package escenario4;

public class Main {

    public static void main(String[] args){

        Ecommerce e = new Ecommerce();

        e.registrarProductos(1, 2000, "celular");
        e.registrarProductos(2, 3000, "tablet");
        e.registrarProductos(3, 1500, "audifonos");
        e.registrarProductos(4, 4000, "tv");

        System.out.println("Productos ordenados por precio:");
        e.mostrarProductoPrecio();

        System.out.println("\nBuscar producto por codigo:");
        System.out.println(e.buscarProductos(2));

        System.out.println("\nInsertando productos constantemente...");
        e.insertarProductosConstantes(5);

        System.out.println("\nProductos ordenados por precio:");
        e.mostrarProductoPrecio();
    }
}