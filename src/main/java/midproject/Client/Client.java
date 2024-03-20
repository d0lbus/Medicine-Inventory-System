package midproject.Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import midproject.SharedClasses.*;

public class Client {
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("localhost");
			LogInAndLogOutInterface msgServer = (LogInAndLogOutInterface) reg.lookup("msgserver");
			Scanner kbd = new Scanner(System.in);
			String username = "";
			String password = "";
			CallbackImplementation mci = null;
			User user = new User();

			while (true) {
				try {
					do {
						System.out.print("Type your name: ");
						username = kbd.nextLine();
						System.out.println("Type your password: ");
						password = kbd.nextLine();
					} while (username.isEmpty() || password.isEmpty());
					user.setUsername(username);
					user.setPassword(password);
					mci = new CallbackImplementation(user);
					msgServer.login(mci, user.getUsername(), password);;
					break;
				} catch (AlreadyLoggedInException e) {
					System.out.println(e.getMessage());
					break;
				} catch (UserExistsException e) {
					System.out.println(e.getMessage());
				} catch (AuthenticationFailedException e){
					System.out.println(e.getMessage());
				}
			}

			System.out.println("chat away!!!!\n");
			while (true) {
				username = kbd.nextLine();
				if (!username.equals("exit")) {
					msgServer.broadcast(mci, username);
				} else {
					msgServer.logout(mci);
					break;
				}
			}
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}