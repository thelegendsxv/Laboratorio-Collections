package escenario4;

public class Producto {
    int id;
    double precio;
    String nombre;

    public Producto(int id, double precio, String nombre){
        this.id=id;
        this.precio=precio;
        this.nombre=nombre;
    }

    public String toString(){
        return "El producto "+nombre+" - "+id+" cuesta "+precio;
    }
}
