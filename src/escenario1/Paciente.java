package escenario1;
public class Paciente {
    int id;
    String nombre;

    public Paciente(int id, String nombre){
        this.id=id;
        this.nombre = nombre;
    }

    @Override
    public String toString(){
         return id+  " - " + nombre;
    }
}
    

