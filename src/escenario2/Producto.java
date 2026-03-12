package escenario2;
public class Producto {
    int id;
    double precio;
    String nombre;
    String categoria;

    public Producto(int id, double precio, String nombre, String categoria){
        this.id=id;
        this.precio=precio;
        this.nombre=nombre;
        this.categoria=categoria;
   }

   @Override
   public String toString(){
    return "El producto " +nombre+ " - "+id +" vale: "+precio+ "es "+categoria;
   }

}

   
