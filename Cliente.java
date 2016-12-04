import java.math.RoundingMode;
import java.rmi.Naming;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class Cliente {
    
    public Cliente(){
        try{
            System.out.println("Estamos en el Cliente");
            Interfaz objeto = (Interfaz)Naming.lookup("rmi://localhost/Pokemon");
            int  opcion=1, poder, turno_juego=0, turno_atac;
            
            
            do{
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvinos a la Batalla pokeomon \n"
                        + "Elija una opcion:\n"
                        + "1)Luchar\n"
                        + "2)Salir"));
                if(opcion==1){
                    for(int i=1; i<3;i++){
                        String nom_poke = JOptionPane.showInputDialog("Escriba nombre del pokemon "+i);
                        int poder_ataque = Integer.parseInt(JOptionPane.showInputDialog("Escriba el poder de ataque del pokemon "+ i));
                        objeto.guardar_pokemon(nom_poke, poder_ataque, 100);
                    }
                    
                   int turno = objeto.turno();
                   for(int i=0;objeto.termino() == false;i++){
                    System.out.println("entraste");
                        if(turno == 1){
                            turno_atac = objeto.turno();
                            if(turno_atac == 0 ){
                                System.out.println("Ataque realizado por pokemon 1 "+objeto.ataque1(turno));
                                objeto.guarda_resultados(turno_juego);
                            }else{
                                System.out.println("No Ataco pokemon 1");
                                objeto.guarda_resultados(turno_juego);
                            }
                            turno=0;

                        }else{
                            turno_atac = objeto.turno();
                            if(turno_atac == 1){                                
                               System.out.println("Ataque realizado por pokemon 2 "+objeto.ataque1(turno));
                                objeto.guarda_resultados(turno_juego);
                            }else{
                                System.out.println("No Ataco pokemon 2");
                                objeto.guarda_resultados(turno_juego);
                            }
                            turno=1;

                        }
                            //System.out.println(objeto.presentar(turno_juego));
                            turno_juego++;
                            
                        
                    }


                }

                for (int i=0;i<turno_juego;i++ ) {
                    System.out.println(objeto.presentar(i));
                    
                }
                System.out.println(objeto.resultado());
                 objeto.limpiar();
            }while(opcion==1);
            
           
            
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
            
    }
    public static void main(String [] args){
        new Cliente();
    }
}
