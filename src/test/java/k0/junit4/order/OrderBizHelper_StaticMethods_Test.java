package k0.junit4.order;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(OrderBizHelper.class)
public class OrderBizHelper_StaticMethods_Test {

    @Test
    public void newOrderId_success() {
        PowerMockito.mockStatic(OrderBizHelper.class);
        String expectedResult = "new_id";
        PowerMockito.when(OrderBizHelper.newOrderId()).thenReturn(expectedResult);
        String actualResult = OrderBizHelper.newOrderId();
        Assert.assertEquals(expectedResult, actualResult);
        // TODO:
        //  org.mockito.exceptions.misusing.UnfinishedVerificationException:
        //  Missing method call for verify(mock) here:
        //  Coverage
        // PowerMockito.verifyStatic(OrderBizHelper.class, Mockito.times(1));
    }
}
