import java.util.HashMap;
import java.util.Map;

public class UserAccountManager {

    private Map<String, String> userAccounts = new HashMap<>();

    public boolean createAccount(String username, String password) {
        if(userAccounts.containsKey(username)) {
            return false;
        }

        userAccounts.put(username, password);
        return true;
    }

    public boolean login(String username, String password) {
        if(userAccounts.containsKey(username) && userAccounts.get(username).equals(password)) {
            return true;
        }

        return false;
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        if(userAccounts.containsKey(username) && userAccounts.get(username).equals(oldPassword)) {
            userAccounts.put(username, newPassword);
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void deleteAccount(String username, String password) {
        if(userAccounts.containsKey(username) && userAccounts.get(username).equals(password)) {
            userAccounts.remove(username);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void quitAccount(String username) {
        System.out.print("Successfuly quit. Bye " + username);
    }

}
