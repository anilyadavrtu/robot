import domainobject.Product;
import org.junit.Assert;
import org.junit.Test;
import robot.RobotImpl;

/**
 * Unit Test RobotTest
 */
public class RobotTest {
    /**
     * robotWalkWithoutWeight
     */
    @Test
    public void robotWalkWithoutWeight() {
        Product product = new Product("barcode", 0, 3.5);
        RobotImpl robot=new RobotImpl();
       String result=robot.callRobot(product,100);
       Assert.assertEquals("30.0 % battery is left",result);
    }

    /**
     * robotWalkWithWeight
     */
    @Test
    public void robotWalkWithWeight() {
        Product product = new Product("barcode", 3, 2);
        RobotImpl robot=new RobotImpl();
        String result=robot.callRobot(product,100);
        Assert.assertEquals("54.0 % battery is left",result);
    }

    /**
     * robotOverWeight
     */
    @Test
    public void robotOverWeight() {
        Product product = new Product("barcode", 12, 0);
        RobotImpl robot=new RobotImpl();
        String result=robot.callRobot(product,100);
        Assert.assertEquals("",result);
    }
}
