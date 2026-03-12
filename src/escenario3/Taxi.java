package escenario3;

public class Taxi {
    int id;
    String usuario;
    String destino;

    public Taxi(int id, String usuario, String destino){
        this.id=id;
        this.usuario=usuario;
        this.destino=destino;
    }
    @Override
    public String toString(){
        return "El usuario: "+usuario+" - "+id+" va hacia "+destino;

    }
}
