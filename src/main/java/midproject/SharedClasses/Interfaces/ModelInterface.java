package midproject.SharedClasses.Interfaces;

import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.ViewClasses.AdminGUIFrame;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ModelInterface extends Remote {
    public String login(MessageCallback msgCallback, String username, String password, String userTypeRequest)
            throws RemoteException, UserExistsException,
            AlreadyLoggedInException, AuthenticationFailedException;

    // method to broadcast a message to all logged in clients
    // using msgCallback as session manager/identifier
    public void broadcast(MessageCallback msgCallback, String msg)
            throws RemoteException, NotLoggedInException;

    // method to logout from the chat system using msgCallback as
    // the session manager/identifier
    public void logout(MessageCallback msgCallback, String sessionID)
            throws Exception;

    public void unarchiveSelectedUsers(String userId, String originalFilePath, String archiveFilePath)
            throws Exception;

    public User viewArchivedUserDetails(String userId, String archiveFilePath) throws RemoteException, Exception;

    public void updateRegisteredUsersTable() throws Exception;

    public void updateRegisteredUsersCount() throws Exception;

    public void registerUser(User newUser) throws Exception, InvalidInputException;
}
