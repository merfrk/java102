package PolicyManagement;

public class HomeAddress implements Address{
    @Override
    public String getType() {
        return "Home";
    }
}
