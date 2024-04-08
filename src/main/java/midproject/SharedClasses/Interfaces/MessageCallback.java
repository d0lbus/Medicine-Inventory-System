package midproject.SharedClasses.Interfaces;

import midproject.SharedClasses.ReferenceClasses.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MessageCallback extends Remote {
	User getUser() throws RemoteException;

	void loginCall(User user) throws RemoteException;

	void broadcastCall(String msg) throws RemoteException;

	void logoutCall(User user) throws RemoteException;

	void updateOnlineUsers(int count, List<String> onlineUserNames) throws RemoteException;

	void updatePendingOrdersCount (int count) throws RemoteException;

	void updateOrdersCount (int count) throws RemoteException;

	void readRUsersList(List<User> users) throws RemoteException;
	void readAUsersList(List<User> users) throws RemoteException;

	void readOrdersList(List<Order> orders) throws RemoteException;

	void readMedicineList(List<Medicine> medicine) throws RemoteException;

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

	void sendOrderSearchResults(List<Order> searchResults) throws RemoteException;

	void sendPendingOrderSearchResults(List<Order> searchResults) throws RemoteException;

	void notifyUserUpdatedByAdmin(String adminUsername, User editedUser, User originalUser) throws RemoteException;

	void notifyUserOrdersToAdmins(String username, String orderId) throws RemoteException;

	/**CUSTOMER SIDE**/
	void updateCart(UserCart userCart) throws RemoteException;

	void notifyOrderProcessed(String orderId, User user, List<OrderItem> orderItems, byte[] imageBytes, String modeOfDelivery, String modeOfPayment) throws RemoteException;

	void notifyOrderStatusChanged(String orderID, String newStatus) throws RemoteException;

    void notifyPasswordChangeResult(boolean b, String s) throws RemoteException;

	void getUserMessage(String message, String username) throws RemoteException;
}