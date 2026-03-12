package escenario1;
public class Main{
    public static void main(String[] args) {
        
        Hospital h = new Hospital();

        h.registrarPacientes(123, "Jose", "fiebre", java.sql.Date.valueOf("2024-06-01"));
         h.registrarPacientes(456, "Jose M", "dolor de cabeza", java.sql.Date.valueOf("2024-06-02"));
          h.registrarPacientes(123, "Ana", "tos", java.sql.Date.valueOf("2024-06-03"));
           h.registrarPacientes(789, "Lala", "dolor de garganta", java.sql.Date.valueOf("2024-06-04"));

        h.mostrarPacientes();

        System.out.println("buscar paciente" + h.buscarPaciente(123)); 
    }
}   