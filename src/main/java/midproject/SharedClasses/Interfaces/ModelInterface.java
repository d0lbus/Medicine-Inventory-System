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
    public String login(MessageCallback msgCallback, String username, String password, String userTypeRequest)
            throws RemoteException, UserExistsException,
            AlreadyLoggedInException, AuthenticationFailedException;

    public void logout(MessageCallback msgCallback, String sessionID)
            throws Exception, UserExistsException;

    public void broadcast(String username, String msg)
            throws Exception;

    public void sendRUserDetailsToAdmins(String userId, MessageCallback msgCallback) throws RemoteException;

    public void sendAUserDetailsToAdmins(String userId, MessageCallback msgCallback) throws RemoteException;

    void archiveUser(String userId, MessageCallback callback, String adminUsername) throws RemoteException;

    public void updateDashboard() throws Exception;

    public void updateRegisteredUsersTable() throws Exception;

    public void updateArchivedUsersTable() throws Exception;

    public void updateRegisteredUsersCount() throws Exception;

    public void updateInventoryTable() throws Exception;

    public void updateOrdersTable() throws Exception;

    public void searchOrders(String searchText, MessageCallback callback) throws RemoteException, NoOrdersFoundException;

    public void searchPendingOrders(String searchText, MessageCallback callback) throws RemoteException;

    public Order retrieveOrderDetails(String orderId)  throws RemoteException;

    public void updateOrderStatus(String orderId, String newStatus) throws RemoteException;

    public void addMedicine(Medicine medicine, MessageCallback callback, String adminUsername) throws Exception;

    public void deleteMedicine(Medicine medicine, MessageCallback callback, String adminUsername) throws Exception, SelectionRequiredException;

    public void searchMedicine(String searchText, MessageCallback callback) throws RemoteException;

    public void updateMedicine(Medicine editedMedicine, Medicine originalMedicine, MessageCallback callback, String adminUsername) throws Exception;

    public void registerUser(User newUser, String adminUsername) throws RemoteException, InvalidInputException;

    void searchUsers(String searchText, MessageCallback callback) throws RemoteException, NoUserFoundException;

    void unarchiveUser(String userId, MessageCallback callback, String username) throws Exception;

    void searchArchivedUsers(String searchText, MessageCallback callback) throws RemoteException, NoUserFoundException;

    public void updateUser(User editedUser, User originalUser, MessageCallback callback, String adminUsername) throws RemoteException, SelectionRequiredException;

    void sendMessageToAdmins(String message, String username) throws RemoteException;

    /**CUSTOMER SIDE**/
    User getUserDetailsbyId(String userID) throws Exception, UserNotFoundException;
    User getUserDetails(String username, MessageCallback msgCallback) throws Exception, UserNotFoundException;
    void getCartDetails(String username, MessageCallback clientCallback) throws RemoteException, CartDetailsFetchFailedException;
    void addMedicineToCart(String medicineId, int quantity, MessageCallback clientCallback, String username) throws RemoteException, MedicineOutOfStockException;
    void updateMedicineQuantityInCart(String medicineId, int newQuantity, MessageCallback clientCallback, String username) throws RemoteException, MedicineQuantityUpdateFailedException;
    void removeMedicineInCart(String medicineId, MessageCallback clientCallback, String username) throws RemoteException, MedicineRemovalFailedException;
    int retrieveMedicineStock(String medicineId) throws RemoteException;
    void processOrder(User user, List<OrderItem> orderItems, String base64Image, String modeOfDelivery, String modeOfPayment, MessageCallback clientCallback) throws RemoteException, MedicineOutOfStockException;
    boolean changeUserPassword(String username, String oldPassword, String newPassword, MessageCallback clientCallback) throws RemoteException, PasswordChangeFailedException;
}
