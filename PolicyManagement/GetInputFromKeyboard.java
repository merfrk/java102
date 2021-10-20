package PolicyManagement;

import java.util.Scanner;

public class GetInputFromKeyboard {
    public Account getLoginCredentialsFromKeyboard(){

        Scanner scan = new Scanner(System.in);
        String email;
        System.out.println("Enter your email");
        email = scan.nextLine();
        System.out.println("Enter your password");
        String password = scan.nextLine();

        AccountManager accountManager = new AccountManager();
        Account resultAccount = accountManager.login(email,password);

        return  resultAccount;

    }
}
