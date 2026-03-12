package escenario1;
import java.util.ArrayList;
import java.util.HashMap;

public class Hospital {

    public ArrayList<Paciente> ordenLlegada = new ArrayList<>();
    HashMap<Integer, Paciente> mapaPacientes = new HashMap<>();

    public Paciente registrarPacientes(int id, String nombre, String motivo, java.sql.Date fechaAgendada){
        if(mapaPacientes.containsKey(id)){
            return null;
        }

        Paciente p = new Paciente(id, nombre, motivo, fechaAgendada);

        ordenLlegada.add(p);
        mapaPacientes.put(id,p);

        return p;
    }

    public Paciente buscarPaciente(int id){
        return mapaPacientes.get(id);

    }

    public void mostrarPacientes(){
        System.out.println(ordenLlegada);
    }
        
}
