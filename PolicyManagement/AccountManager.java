package PolicyManagement;

import java.util.TreeSet;

public class AccountManager {
    TreeSet<Account> treeSet;

    public Account login(String email,String password){

        for( Account account : treeSet )
            try {
                account.login(email, password);
                if ( account.isLogin() )
                    return account;

            }catch (InvalidAuthenticationException e){
                System.out.println(e.getMessage());
            }

        return null;
    }
}
