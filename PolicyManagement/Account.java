package PolicyManagement;

import java.util.List;
import java.util.Objects;

public abstract class Account {
    User user;
    List<Insurance> insuranceList;
    AuthenticationStatus authenticationStatus;

    public final void showUserInfo(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(user, account.user) && Objects.equals(insuranceList, account.insuranceList) && authenticationStatus == account.authenticationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, insuranceList, authenticationStatus);
    }

    abstract void addInsurance();

    public void addAddress(Address address){
        user.getAdressList().add(address);
    }
    public void removeAddress( Address adress ){
        user.getAdressList().remove(adress);
    }

    public void login(String mail,String password) throws InvalidAuthenticationException {

        if( mail.equals( user.getEmail() ) && password.equals( user.getPassword() ) ){
            authenticationStatus = AuthenticationStatus.SUCCESS;
        }else{
            throw new InvalidAuthenticationException("Invalid Credentials");
        }
    }

    public boolean isLogin(){

        return authenticationStatus.equals(AuthenticationStatus.SUCCESS);
    }
}
