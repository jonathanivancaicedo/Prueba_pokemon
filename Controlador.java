import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jonathan
 */
public class Controlador extends UnicastRemoteObject implements Interfaz {
    int poder=0;
    List<Pokemon> lista;
    List<Mensaje> mensaje;
    public Controlador() throws RemoteException{
        super();
        lista = new ArrayList<Pokemon>();
        mensaje = new ArrayList<Mensaje>();
                
    }

    //atacar al pokemon
    public int ataque1(int turno){ 
        int vida = 0;

        if(turno == 1){
            vida = (lista.get(0).vida)-(lista.get(1).poder_ataque);
            lista.get(0).vida=vida;
        }    
        else{
            vida = (lista.get(1).vida)-(lista.get(0).poder_ataque);
            lista.get(1).vida=vida;
        }  
        System.out.println(vida+"dhdhhdhd");      
        return vida;
    }
    
    //se termina el juego
    public boolean termino(){
        if(lista.get(0).vida<=0||lista.get(1).vida<=0){
            return true;
        }else{    
        return false;
        }
    } 

    
    //Agregar Pokemons
    public boolean guardar_pokemon(String nombre, int poder_ataque, int vida){
        Pokemon p = new Pokemon(nombre, poder_ataque, vida);
        if(lista.add(p)){
                System.out.println("Pokemon Guardado");
            return true;
        }else{
            System.out.println("No se guardo el pokemon");
            return false;
        }
    }
    //Agregar resultado por turno
    public void guarda_resultados(int turno){
        String nom_poke; 
        int vida, t;
        System.out.println(turno);
         t= turno;
         System.out.println(t);
        if(t == 1){
            nom_poke = lista.get(0).nombre;
            vida = lista.get(0).vida;
            Mensaje m = new Mensaje(nom_poke, t, vida);
            mensaje.add(m);
            System.out.println("Nombre_pokemon "+nom_poke+"\n Turno "+t+"\n Vida del pokemon"+vida);

        }else{
            nom_poke = lista.get(1).nombre;
            vida = lista.get(1).vida;
            Mensaje m = new Mensaje(nom_poke, t, vida);
            mensaje.add(m);
            System.out.println("Nombre_pokemon "+nom_poke+"\n Turno "+t+"\n Vida del pokemon"+vida);
        }
           System.out.println("Se guardo mensaje");    
       
                            
    }
    
    //turno y atacar o no
    public int turno(){
        Random rnd = new Random();  
       return rnd.nextInt(2);
    }

    
    public String presentar(int turno){
        String resultado;
            resultado = "El nombre de pokemon es: "+mensaje.get(turno).nombre_pokemon+"\n ELa vida es: "+mensaje.get(turno).vida+"\n turno :"+mensaje.get(turno).turno+"\n";
            System.out.println("presentar");
            System.out.println(resultado);
       
        return resultado;
    }
    
    public String resultado(){
        
        if(lista.get(0).vida > lista.get(1).vida){
            return "El ganador es: "+ lista.get(0).nombre;
        }else
            return "El ganador es: "+ lista.get(1).nombre;
    
      }

      //limpiar lista 
     public String limpiar(){
       

        System.out.println( "Se elimino el pokemon "+lista.get(0).nombre+"\n Se elimino el pokemon "+lista.get(1).nombre);
        lista.remove(1);
        lista.remove(0);
        return "EMpieza de nuevo la Batalla pokemon.................";
    }
    
}