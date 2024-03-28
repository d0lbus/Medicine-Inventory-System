package midproject.Server;

import java.rmi.registry.*;

import midproject.SharedClasses.Implementations.ModelImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;

public class Server {
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