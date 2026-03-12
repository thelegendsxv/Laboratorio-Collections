package escenario1;
public class Main{
    public static void main(String[] args) {
        
        Hospital h = new Hospital();

        h.registrarPacientes(123, "Jose");
         h.registrarPacientes(456, "Jose M");
          h.registrarPacientes(123, "Ana");
           h.registrarPacientes(789, "Lala");

        h.mostrarPacientes();

        System.out.println("buscar paciente" + h.buscarPaciente(123)); 
    }
}   