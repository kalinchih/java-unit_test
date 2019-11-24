package k0.junit4.order;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class Order_Test {

    private Order order;
    private int expectedResult;

    public Order_Test(Order order, int expectedResult) {
        this.order = order;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                    {createOrder(new int[] {1, 3}), 4},
                    {createOrder(new int[] {2, 5, 6}), 13},
                    {createOrder(new int[] {-1, 1}), 1}
                });
    }

    private static Order createOrder(int... lineItemAmounts) {
        List<OrderLineItem> orderLineItems = new ArrayList<>();
        for (int amount : lineItemAmounts) {
            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setAmount(amount);
            orderLineItems.add(orderLineItem);
        }
        return new Order(orderLineItems);
    }

    @Test
    public void totalLineItemAmount_success() {
        Assert.assertEquals(expectedResult, this.order.totalLineItemAmount());
    }
}
