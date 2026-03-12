package escenario4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Ecommerce {

    LinkedList<Producto> listaProductos = new LinkedList<>();
    HashMap<Integer, Producto> mapaProductos = new HashMap<>();

    public TreeSet<Producto> ordenPrecio = new TreeSet<>(
        (a,b) -> {
            int comparacion = Double.compare(a.precio, b.precio);
            if(comparacion == 0){
                return Integer.compare(a.id, b.id);
            }
            return comparacion;
        }
    );

    public Producto registrarProductos(int id, double precio, String nombre){

        if(mapaProductos.containsKey(id)){
            System.out.println("Producto duplicado");
            return null;
        }

        Producto p = new Producto(id, precio, nombre);

        listaProductos.add(p);
        mapaProductos.put(id, p);
        ordenPrecio.add(p);

        return p;
    }

    public Producto buscarProductos(int id){
        return mapaProductos.get(id);
    }

    public void mostrarProductoPrecio(){
        for(Producto p : ordenPrecio){
            System.out.println(p);
        }
    }

    // inserta muchos productos (simula inserción constante)
    public void insertarProductosConstantes(int cantidad){

        for(int i = 1; i <= cantidad; i++){
            registrarProductos(i + 100, i * 500, "producto" + i);
        }

    }
}