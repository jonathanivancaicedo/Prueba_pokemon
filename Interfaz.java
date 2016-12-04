import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Jonathan
 */
public interface Interfaz extends Remote{
    public int ataque1(int turno) throws RemoteException;
    public boolean termino() throws RemoteException;
    public boolean guardar_pokemon(String nombre, int poder_ataque, int vida) throws RemoteException;
    public void guarda_resultados(int turno) throws RemoteException;
    public int turno() throws RemoteException;
    public String presentar(int turno) throws RemoteException;
    public String resultado()throws RemoteException;
    public String limpiar()throws RemoteException;

    
    
    
}
