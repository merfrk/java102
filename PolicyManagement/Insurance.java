package PolicyManagement;

import java.util.Date;

public abstract class Insurance {
    String name;
    Double price;
    Date endDate;

    abstract Double calculate();
}
