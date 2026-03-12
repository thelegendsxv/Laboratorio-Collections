package escenario1;

import java.sql.Date;

public class Paciente {
    int id;
    String nombre;
    String motivo;
    Date fechaAgenadad;

    public Paciente(int id, String nombre, String motivo, Date fechaAgenadad){
        this.id=id;
        this.nombre = nombre;
        this.motivo = motivo;
        this.fechaAgenadad = fechaAgenadad;
    }

    @Override
    public String toString(){
         return id+  " - " + nombre+ " - " + motivo + " - " + fechaAgenadad;
    }
}
    

