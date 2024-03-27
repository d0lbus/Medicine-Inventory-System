package midproject.SharedClasses.Interfaces;

import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.AlreadyLoggedInException;
import midproject.SharedClasses.UserDefinedExceptions.AuthenticationFailedException;
import midproject.SharedClasses.UserDefinedExceptions.NotLoggedInException;
import midproject.SharedClasses.UserDefinedExceptions.UserExistsException;
import midproject.ViewClasses.AdminGUIFrame;

import java.rmi.*;
import java.util.List;

public interface ModelInterface extends Remote {
    public String login(MessageCallback msgCallback, String username, String password)
            throws RemoteException, UserExistsException,
            AlreadyLoggedInException, AuthenticationFailedException;

    // method to broadcast a message to all logged in clients
    // using msgCallback as session manager/identifier
    public void broadcast(MessageCallback msgCallback, String msg)
            throws RemoteException, NotLoggedInException;

    // method to logout from the chat system using msgCallback as
    // the session manager/identifier
    public void logout(MessageCallback msgCallback, String sessionID)
            throws RemoteException, NotLoggedInException;

    public void unarchiveSelectedUsers(String userId, String originalFilePath, String archiveFilePath)
            throws Exception;

    public User viewArchivedUserDetails(String userId, String archiveFilePath) throws RemoteException, Exception;

    public List<User> getRegisteredUsers() throws RemoteException;

}
