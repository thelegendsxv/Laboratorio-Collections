package escenario3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Plataforma {
    HashMap<Integer, Taxi>mapaSolicitudes = new HashMap<>();
    Queue<Taxi>colaSolicitud = new LinkedList<>();

    public Taxi registrarViajes(int id, String Usuario, String destino){
        if(mapaSolicitudes.containsKey(id)){
            return null;
        }
        Taxi t = new Taxi(id, Usuario, destino);

        mapaSolicitudes.put(id, t);
        colaSolicitud.add(t);
        
        return t;
    }

    public Taxi atenderPrimero(){
        Taxi t = colaSolicitud.poll();

        if(t != null){
            mapaSolicitudes.remove(t.id);
        }
    return t;
    }

    public void cancelarSolicitud(int id){
        Taxi t = mapaSolicitudes.get(id);

        if(t != null){
            mapaSolicitudes.remove(id);
            colaSolicitud.remove(t);
            System.out.println("Solicitud cancelada " +t);
        }
    }

    public void mostrarPendientes(){
        for(Taxi t: colaSolicitud){
            System.out.println(t);
        }
    }
    
}
