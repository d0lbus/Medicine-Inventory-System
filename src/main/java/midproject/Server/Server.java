package midproject.Server;

import java.rmi.registry.*;

import midproject.SharedClasses.Servants.ModelImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;

/**
 * This class represents the server side of the messaging system.
 */
public class Server {
	/**
	 * The main method responsible for starting the server.
	 * @param args The command line arguments (not used in this implementation).
	 */
	public static void main(String[] args) {
		try {
			ModelInterface servant = new ModelImplementation();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("msgserver",servant);
			System.out.println("Server running...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}