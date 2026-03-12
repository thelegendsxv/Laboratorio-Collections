package escenario2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Plataforma {
    LinkedList<Producto> listaProductos = new LinkedList<>();
    HashMap<Integer, Producto> mapaProducto = new HashMap<>();
    TreeSet<Producto>ordenarProductoPrecio = new TreeSet<>((a,b) ->Double.compare(a.precio, b.precio));

    //TreeSet<Producto> ordenar = new TreeSet<>((a,b) -> a.nombre.compareTo(b.nombre));   si fuera String(es de repaso)

    public Producto registrarProducto(int id, double precio, String nombre, String categoria){
        if(mapaProducto.containsKey(id)){
            return null;
        }

        Producto p = new Producto(id, precio, nombre, categoria);

        listaProductos.addFirst(p);
        mapaProducto.put(id, p);
        ordenarProductoPrecio.add(p);

        return p;
    }

    public Producto buscarProducto(int id){
        return mapaProducto.get(id);
    }   

    public void mostrarProductoOrdenado(){
        for(Producto p: ordenarProductoPrecio){
            System.out.println(p);
        }
    }


    public void filtrarCategoria(String categoria){
        for(Producto p: listaProductos){
            if(p.categoria.equals(categoria)){
                System.out.println(p);

            }
        }
    }


}
