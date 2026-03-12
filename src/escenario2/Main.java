package escenario2;
public class Main {

    public static void main(String[] args) {
        
  
    Plataforma p = new Plataforma();

    p.registrarProducto(1, 2000, "xbox", "consola");
    p.registrarProducto(2, 4000, "play 4", "consola");
    p.registrarProducto(3, 3000, "lucha", "libre");
    p.registrarProducto(1, 5000, "lucha", "consola");

    p.mostrarProductoOrdenado();

        System.out.println("Buscar producto: " +p.buscarProducto(2));

        System.out.println("Filtrar categoria consola:");
        p.filtrarCategoria("consola");
    
    }
}
