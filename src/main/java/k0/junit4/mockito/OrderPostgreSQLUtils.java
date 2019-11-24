package k0.junit4.mockito;

import java.sql.SQLException;

public class OrderPostgreSQLUtils extends OrderDbUtil {

    @Override
    Integer createOrder(Order order) throws SQLException {
        return null;
    }

    @Override
    void setOrderStatusCancel(Integer orderId) throws SQLException {}
}
