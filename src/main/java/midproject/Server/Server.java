package midproject.Server;

import java.rmi.registry.*;
import midproject.SharedClasses.LogInAndLogOutInterface;

public class Server {
	public static void main(String[] args) {
		try {
			LogInAndLogOutInterface servant = new ServerImplementation();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("msgserver",servant);
			System.out.println("message server running...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}