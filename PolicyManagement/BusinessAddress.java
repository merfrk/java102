package PolicyManagement;

public class BusinessAddress implements Address{
    @Override
    public String getType() {
        return "Business";
    }
}
