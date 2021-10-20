package PolicyManagement;

import java.util.List;

public class AddressManager {
    public static void addAddress(User user,Address address){
        List<Address> addressList = user.getAdressList();
        addressList.add(address);
    }

    public static void removeAddress(User user,Address address){
        List<Address> addressList = user.getAdressList();
        addressList.remove(address);
    }
}
