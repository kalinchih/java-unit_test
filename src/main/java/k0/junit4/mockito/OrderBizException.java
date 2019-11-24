package k0.junit4.mockito;

public class OrderBizException extends Exception {

    public static final String FAIL_TO_CREATE_AN_ORDER = "Fail to create an order.";

    public OrderBizException(String message, Throwable cause) {
        super(message, cause);
    }
}
