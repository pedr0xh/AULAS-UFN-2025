package emailrmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author laboratorio
 */
public class Server {
    
    String HOST_URL = "rmi://localhost/Gerador";
    
    public Server(){
    
        try{
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Gerador objetoRemoto = new Gerador();
            System.out.println("Servidor pronto para gerar e-mails e hashes...");
            Naming.bind(HOST_URL, objetoRemoto);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        
    }
    
    public static void main(String args[]){
        new Server();
    }
    
}
