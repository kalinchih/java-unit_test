package k0.junit4.mockito;

import java.sql.SQLException;

public class OrderBizHelper {

    private OrderDbUtil orderDbUtil;

    public OrderBizHelper(OrderDbUtil orderDbUtil) {
        this.orderDbUtil = orderDbUtil;
    }

    public Integer placeOrder(Order order) throws OrderBizException {
        try {
            return orderDbUtil.createOrder(order);
        } catch (SQLException e) {
            throw new OrderBizException(OrderBizException.FAIL_TO_CREATE_AN_ORDER, e);
        }
    }

    public void cancelOrder(Integer orderId) throws OrderBizException {
        if (orderId == null) {
            throw new OrderBizException(
                    OrderBizException.FAIL_TO_CANCEL_AN_ORDER_WITH_NULL_ORDER_ID);
        }
        try {
            orderDbUtil.setOrderStatusCancel(orderId);
        } catch (SQLException e) {
            throw new OrderBizException(OrderBizException.FAIL_TO_CANCEL_AN_ORDER, e);
        }
    }
}
