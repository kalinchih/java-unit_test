package k0.junit4.mockito;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/** Mockito: practice mock, stub, dummy, verify */
public class OrderBizHelper_PostgreSQLUtil_Test {

    @Mock OrderDbUtil orderDbUtil;
    OrderBizHelper orderBizHelper;

    @Before
    public void setUp() {
        this.orderDbUtil = new OrderPostgreSQLUtils();
        // *** MockitoAnnotations MUST BEHIND after mock object.
        // Otherwise throw `org.mockito.exceptions.misusing.MissingMethodInvocationException`.
        MockitoAnnotations.initMocks(this);
        // *** REMIND objects dependency. OrderBizHelper MUST be initialized after Mock OrderDbUtil.
        this.orderBizHelper = new OrderBizHelper(orderDbUtil);
    }

    @After
    public void tearDown() {
        this.orderDbUtil = null;
        this.orderBizHelper = null;
    }

    @Test
    public void placeOrder_success() throws SQLException, OrderBizException {
        Integer expectedResult = new Integer(1);
        // A stub fakes a return value to the createOrder() of the @Mock OrderDbUtil.
        // Leverage any(Order.class) to create a dummy Order object
        when(this.orderDbUtil.createOrder(any(Order.class))).thenReturn(expectedResult);
        Object actualResult = this.orderBizHelper.placeOrder(any(Order.class));
        Assert.assertEquals(expectedResult, actualResult);
        // Verify the mock method invocation times
        verify(this.orderDbUtil, times(1)).createOrder(any(Order.class));
    }

    @Test(expected = OrderBizException.class)
    public void placeOrder_fail_to_create_an_order() throws SQLException, OrderBizException {
        OrderBizException expectedResult =
                new OrderBizException(
                        OrderBizException.FAIL_TO_CREATE_AN_ORDER, new SQLException());
        when(this.orderDbUtil.createOrder(any(Order.class))).thenThrow(SQLException.class);
        try {
            Object actualResult = this.orderBizHelper.placeOrder(any(Order.class));
        } catch (Exception e) {
            // Assert the exception message
            Assert.assertEquals(OrderBizException.FAIL_TO_CREATE_AN_ORDER, e.getMessage());
            verify(this.orderDbUtil, times(1)).createOrder(any(Order.class));
            // Leverage @Test(expected = OrderBizException.class) to assert Exception class
            throw e;
        }
    }

    @Test
    public void cancelOrder_success() throws SQLException, OrderBizException {
        // stub void setOrderStatusCancel()
        doNothing().when(orderDbUtil).setOrderStatusCancel(anyInt());
        this.orderBizHelper.cancelOrder(anyInt());
        verify(this.orderDbUtil, times(1)).setOrderStatusCancel(any(Integer.class));
    }

    @Test(expected = OrderBizException.class)
    public void cancelOrder_fail_to_cancel_an_order_with_null_order_id()
            throws SQLException, OrderBizException {
        doNothing().when(orderDbUtil).setOrderStatusCancel(any(Integer.class));
        try {
            this.orderBizHelper.cancelOrder(null);
        } catch (Exception e) {
            Assert.assertEquals(
                    OrderBizException.FAIL_TO_CANCEL_AN_ORDER_WITH_NULL_ORDER_ID, e.getMessage());
            throw e;
        }
    }

    @Test(expected = OrderBizException.class)
    public void cancelOrder_fail_to_cancel_an_order() throws SQLException, OrderBizException {
        // Throw SQLException from the stub method
        doThrow(SQLException.class).when(orderDbUtil).setOrderStatusCancel(any(Integer.class));
        try {
            this.orderBizHelper.cancelOrder(anyInt());
        } catch (Exception e) {
            Assert.assertEquals(OrderBizException.FAIL_TO_CANCEL_AN_ORDER, e.getMessage());
            verify(this.orderDbUtil, times(1)).setOrderStatusCancel(any(Integer.class));
            throw e;
        }
    }
}
