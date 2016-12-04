
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Servidor{
	public Servidor(){
		try{
			System.out.println("Estamos en el servidor");
			Interfaz objeto = new Controlador();
			Naming.rebind("rmi://localhost/Pokemon",objeto);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	public static void main(String [] args){
		new Servidor();
	}
}
