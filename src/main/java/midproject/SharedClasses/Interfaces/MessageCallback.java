package midproject.SharedClasses.Interfaces;

import midproject.SharedClasses.ReferenceClasses.*;
import midproject.ViewClasses.AdminGUIFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;


public interface MessageCallback extends Remote {
	public User getUser() throws RemoteException;

	public void loginCall(User user) throws RemoteException;

	public void broadcastCall(String msg) throws RemoteException;

	public void logoutCall(User user) throws RemoteException;

    //public void sendArchivedUsersList(List<User> archivedUsers);

	public void updateOnlineUsers(int count) throws RemoteException;

	public void readRUsersList(List<User> users) throws RemoteException;
	public void readAUsersList(List<User> users) throws RemoteException;

	public void readOrdersList(List<Order> orders) throws RemoteException;

	public void readMedicineList(List<Medicine> medicine) throws RemoteException;

    void countUsersList(List<User> users) throws RemoteException;

	void displayUserDetails(User user) throws RemoteException;

	void displayProfileDetails(User user) throws RemoteException;

	void notifyUserRegisteredByAdmin(String adminUsername, User user) throws RemoteException;

	void notifyUserArchivedByAdmin(String adminUsername, String archivedUsername) throws RemoteException;

	void notifyUserUnarchivedByAdmin(String adminUsername, String username) throws Exception;

	void notifyMedicineAddedByAdmin(String adminUsername, Medicine medicine) throws RemoteException;

	void notifyMedicineArchivedByAdmin(String adminUsername, Medicine medicine) throws RemoteException;

	void notifyMedicineUpdatedByAdmin(String adminUsername, Medicine editedMedicine, Medicine originalMedicine) throws RemoteException;

	void sendSearchResults(List<User> users) throws RemoteException;

	void sendMedicineSearchResults(List<Medicine> users) throws RemoteException;

	void sendArchivedUserSearchResults(List<User> searchResults) throws RemoteException;

	void notifyUserUpdatedByAdmin(String adminUsername, User editedUser, User originalUser) throws RemoteException;

	void notifyUserOrdersToAdmins(String username, String orderId) throws RemoteException;


	/**CUSTOMER SIDE**/
	void updateCart(UserCart userCart) throws RemoteException;

	void notifyOrderProcessed(String orderId, User user, List<OrderItem> orderItems, byte[] imageBytes, String modeOfDelivery, String modeOfPayment) throws RemoteException;

	void notifyOrderStatusChanged(String orderID, String newStatus) throws RemoteException;

}