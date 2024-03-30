package midproject.SharedClasses.Interfaces;

import midproject.SharedClasses.Implementations.CallbackImplementation;
import midproject.SharedClasses.ReferenceClasses.Medicine;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.ViewClasses.AdminGUIFrame;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ModelInterface extends Remote {
    public String login(MessageCallback msgCallback, String username, String password, String userTypeRequest)
            throws RemoteException, UserExistsException,
            AlreadyLoggedInException, AuthenticationFailedException;

    public void logout(MessageCallback msgCallback, String sessionID)
            throws Exception;

    public void broadcast(String msg)
            throws RemoteException, NotLoggedInException;

    public void sendRUserDetailsToAdmins(String userId, MessageCallback msgCallback) throws RemoteException;

    public void sendAUserDetailsToAdmins(String userId, MessageCallback msgCallback) throws RemoteException;

    void archiveUser(String userId, MessageCallback callback, String adminUsername) throws RemoteException;

    public void updateRegisteredUsersTable() throws Exception;

    public void updateArchivedUsersTable() throws Exception;

    public void updateRegisteredUsersCount() throws Exception;

    public void updateInventoryTable() throws Exception;

    public void addMedicine(Medicine medicine, MessageCallback callback, String adminUsername) throws Exception;

    public void deleteMedicine(Medicine medicine, MessageCallback callback, String adminUsername) throws Exception;

    public void searchMedicine(String searchText, MessageCallback callback) throws RemoteException;

    public void updateMedicine(Medicine editedMedicine, Medicine originalMedicine, MessageCallback callback, String adminUsername) throws Exception;

    public void registerUser(User newUser, String adminUsername) throws Exception, InvalidInputException;

    void searchUsers(String searchText, MessageCallback callback) throws RemoteException;

    void unarchiveUser(String userId, MessageCallback callback, String username) throws Exception;
}
