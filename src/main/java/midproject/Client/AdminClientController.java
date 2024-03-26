package midproject.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.google.gson.*;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.Login;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AdminClientController {

    private static Login loginFrame = new Login();
    private static AdminGUIFrame adminGUIFrame = new AdminGUIFrame();
    private static User user = new User();
    private static Registry registry;
    private static ModelInterface msgserver;
    private static CallbackImplementation mci;

    private static String sessionID;


    public static void main(String[] args) {
        initiateLoginProcess();
        initController();
    }

    private static void initiateLoginProcess() {
        loginFrame.setVisible(true);
        loginFrame.getLogInButton().addActionListener(e -> {
            try {
                String ipAddress = loginFrame.getIpAddressTextField().getText();
                String username = loginFrame.getUsernameTextField().getText();
                String password = new String(loginFrame.getPasswordField().getPassword());

                registry = LocateRegistry.getRegistry(ipAddress);
                msgserver = (ModelInterface) registry.lookup("msgserver");
                mci = new CallbackImplementation(user);
                sessionID = msgserver.login(mci, username, password);

                if (sessionID != null) {
                    loginFrame.dispose();
                    showClientGUI();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Authentication failed.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(loginFrame, "Login error: " + ex.getMessage());
            }
        });
    }

    private static void showClientGUI(){
        adminGUIFrame.setVisible(true);

    }

    private static void initController() {
        adminGUIFrame.getRegisteredUsersButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jsonFilePath = "res/UserInformation.json";
                try {
                    Gson gson = new Gson();
                    Reader reader = Files.newBufferedReader(Paths.get(jsonFilePath));
                    JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

                    DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getrUsersTable().getModel();

                    model.setRowCount(0);

                    for (JsonElement userElement : jsonArray) {
                        JsonObject userObject = userElement.getAsJsonObject();
                        Object[] rowData = {
                                userObject.get("userId").getAsString(),
                                userObject.get("lastName").getAsString(),
                                userObject.get("firstName").getAsString(),
                                userObject.get("userType").getAsString(),
                                userObject.get("username").getAsString()
                        };
                        model.addRow(rowData);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        adminGUIFrame.getrUsersSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(adminGUIFrame.getrUsersTable().getModel());
                adminGUIFrame.getrUsersTable().setRowSorter(sorter);
                String searchText = adminGUIFrame.getrUsersSearchTextfield().getText().trim().toLowerCase();

                if (searchText.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText), 1));
                }
            }
        });

        adminGUIFrame.getrUsersViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

    }

}

