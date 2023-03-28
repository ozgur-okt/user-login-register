import java.util.Scanner;

public class LoginSystem {
    private UserAccountManager userAccountManager = new UserAccountManager();

    public void run() {

        Scanner scanner = new Scanner(System.in);

        // Creating user account
        userAccountManager.createAccount("user1", "password1");

        // Prompt user to login or register

        for(;;){
            System.out.println("Do you want to login with an account or register a new account? (L/R)");
            String response = scanner.nextLine();
            if(response.equalsIgnoreCase("L")) {
                // Prompt user to login
                System.out.println("Enter username: ");
                String username = scanner.nextLine();

                System.out.println("Enter password: ");
                String password = scanner.nextLine();

                // Logging in
                if(userAccountManager.login(username, password)) {
                    System.out.println("Login successful!");

                    // Prompt user to change password
                    System.out.println("Do you want to change your password? (Y/N)");
                    response = scanner.nextLine();
                    if(response.equalsIgnoreCase("Y")) {
                        System.out.println("Enter old password: ");
                        String oldPassword = scanner.nextLine();

                        System.out.println("Enter new password: ");
                        String newPassword = scanner.nextLine();

                        userAccountManager.changePassword(username, oldPassword, newPassword);
                    }

                    // Prompt user to delete account
                    System.out.println("Do you want to delete your account? (Y/N)");
                    response = scanner.nextLine();
                    if(response.equalsIgnoreCase("Y")) {
                        System.out.println("Enter password to confirm account deletion: ");
                        String confirmPassword = scanner.nextLine();
                        userAccountManager.deleteAccount(username, confirmPassword);
                    }

                    System.out.println("Do you want to quit? (Y/N)");
                    response = scanner.nextLine();
                    if(response.equalsIgnoreCase("Y")) {
                        userAccountManager.quitAccount(username);
                        break;
                    }

                } else {
                    System.out.println("Invalid username or password.");
                }
            } else if(response.equalsIgnoreCase("R")) {
                // Prompt user to register a new account
                System.out.println("Enter new username: ");
                String newUsername = scanner.nextLine();

                System.out.println("Enter new password: ");
                String newPassword = scanner.nextLine();

                if(userAccountManager.createAccount(newUsername, newPassword)) {
                    System.out.println("Registration successful!");
                } else {
                    System.out.println("Registration failed. Username already exists.");
                }
            }
        }
    }
}
