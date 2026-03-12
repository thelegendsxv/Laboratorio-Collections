package escenario2;

public class Main {

    public static void main(String[] args) {
        
        Plataforma p = new Plataforma();

       
        p.registrarProducto(1, 2000, "xbox", "consola");
        p.registrarProducto(2, 4000, "play 4", "consola");
        p.registrarProducto(3, 3000, "lucha", "libre");
        p.registrarProducto(1, 5000, "lucha", "consola"); // duplicado, no se agrega

        // Simular miles de productos nuevos llegando por hora
        System.out.println("\nInsertando 1000 productos nuevos...");
        for (int i = 10; i < 1010; i++) {
            p.registrarProducto(i, i * 150.0, "producto-" + i, i % 2 == 0 ? "consola" : "electronica");
        }
        System.out.println("Total productos registrados: " + p.listaProductos.size());

        System.out.println("\nProductos ordenados por precio:");
        p.mostrarProductoOrdenado();

        System.out.println("\nBuscar producto: " + p.buscarProducto(2));

        System.out.println("\nFiltrar categoria consola:");
        p.filtrarCategoria("consola");
    }
}