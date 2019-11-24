package k0.junit4.mockito;

import java.sql.SQLException;

public abstract class OrderDbUtil {

    public abstract Integer createOrder(Order order) throws SQLException;
}
