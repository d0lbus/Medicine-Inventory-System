package midproject.SharedClasses.Interfaces;

import midproject.SharedClasses.ReferenceClasses.Medicine;
import midproject.SharedClasses.ReferenceClasses.Order;
import midproject.SharedClasses.ReferenceClasses.OrderItem;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ModelInterface extends Remote {
    String login(MessageCallback msgCallback, String username, String password, String userTypeRequest)
            throws RemoteException, UserExistsException,
            AlreadyLoggedInException, AuthenticationFailedException;

    void logout(MessageCallback msgCallback, String sessionID)
            throws Exception, UserExistsException;

    void broadcast(String username, String msg)
            throws Exception;

    void sendRUserDetailsToAdmins(String userId, MessageCallback msgCallback) throws RemoteException;

    void sendAUserDetailsToAdmins(String userId, MessageCallback msgCallback) throws RemoteException;

    void archiveUser(String userId, MessageCallback callback, String adminUsername) throws RemoteException;

    void updateDashboard() throws Exception;

    void updateRegisteredUsersTable() throws Exception;

    void updateArchivedUsersTable() throws Exception;

    void updateRegisteredUsersCount() throws Exception;

    void updateInventoryTable() throws Exception;

    void updateOrdersTable() throws Exception;

    void searchOrders(String searchText, MessageCallback callback) throws RemoteException, NoOrdersFoundException;

    void searchPendingOrders(String searchText, MessageCallback callback) throws RemoteException;

    Order retrieveOrderDetails(String orderId)  throws RemoteException;

    void updateOrderStatus(String orderId, String newStatus) throws RemoteException;

    void addMedicine(Medicine medicine, MessageCallback callback, String adminUsername) throws Exception;

    void deleteMedicine(Medicine medicine, MessageCallback callback, String adminUsername) throws Exception, SelectionRequiredException;

    void searchMedicine(String searchText, MessageCallback callback) throws RemoteException;

    void updateMedicine(Medicine editedMedicine, Medicine originalMedicine, MessageCallback callback, String adminUsername) throws Exception;

    void registerUser(User newUser, String adminUsername) throws RemoteException, InvalidInputException;

    void searchUsers(String searchText, MessageCallback callback) throws RemoteException, NoUserFoundException;

    void unarchiveUser(String userId, MessageCallback callback, String username) throws Exception;

    void searchArchivedUsers(String searchText, MessageCallback callback) throws RemoteException, NoUserFoundException;

    void updateUser(User editedUser, User originalUser, MessageCallback callback, String adminUsername) throws RemoteException, SelectionRequiredException;

    void sendMessageToAdmins(String message, String username) throws RemoteException;

    /**CUSTOMER SIDE**/
    User getUserDetailsbyId(String userID) throws Exception, UserNotFoundException;
    User getUserDetails(String username, MessageCallback msgCallback) throws Exception, UserNotFoundException;
    void getOrderHistory(String username, MessageCallback clientCallback) throws RemoteException;
    void getCartDetails(String username, MessageCallback clientCallback) throws RemoteException, CartDetailsFetchFailedException;
    void addMedicineToCart(String medicineId, int quantity, MessageCallback clientCallback, String username) throws RemoteException, MedicineOutOfStockException;
    void updateMedicineQuantityInCart(String medicineId, int newQuantity, MessageCallback clientCallback, String username) throws RemoteException, MedicineQuantityUpdateFailedException;
    void removeMedicineInCart(String medicineId, MessageCallback clientCallback, String username) throws RemoteException, MedicineRemovalFailedException;
    void processOrder(User user, List<OrderItem> orderItems, String base64Image, String modeOfDelivery, String modeOfPayment, MessageCallback clientCallback) throws RemoteException, MedicineOutOfStockException;
    boolean changeUserPassword(String username, String oldPassword, String newPassword, MessageCallback clientCallback) throws RemoteException, PasswordChangeFailedException;
    int retrieveMedicineStock(String medicineId) throws RemoteException;
}
