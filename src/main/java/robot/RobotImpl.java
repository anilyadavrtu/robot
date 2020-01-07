package robot;

import domainobject.Product;
import notification.Notification;

/**
 * RobotImpl : Having all robot functionality
 */
public class RobotImpl implements Robot {

    /**
     * callRobot
     *
     * @param product
     * @param totalBattery
     * @return
     */
    public String callRobot(Product product, Integer totalBattery) {
        double remainBattery = 0;
        String message = "";
        double fullBattery = 100;
        boolean isError = checkRobotHealth(product, totalBattery);
        if (!isError) {
            if (product.getWeight() == 0) {
                remainBattery = fullBattery - getBatteryByDistance(product.getDistance());
                message = remainBattery + " % battery is left";
            } else {
                remainBattery = calBatteryDischarge(product);
                message = remainBattery + " % battery is left";
            }
            scanBarCode(product.getBarcode());
        }

        return message;
    }

    /**
     * scanBarCode
     *
     * @param productBarCode
     */
    public void scanBarCode(String productBarCode) {
        if (!productBarCode.equals("barcode")) {
            new Notification().display("barcode");
        }
    }


    /**
     * calBatteryDischarge
     *
     * @param product
     * @return
     */
    public double calBatteryDischarge(Product product) {
        double maxDistance = 5;
        double maxBattery = 100;
        int extraDischargePer = 2;
        double batteryLeft = maxBattery - (product.getWeight() * extraDischargePer);
        return batteryLeft - (getBatteryByDistance(product.getDistance()));
    }

    /**
     * getBatteryByDistance
     *
     * @param distance
     * @return
     */
    public double getBatteryByDistance(double distance) {
        double maxDistance = 5;
        double maxBattery = 100;
        double perKmBattery = maxBattery / maxDistance;
        return perKmBattery * distance;
    }

    /**
     * checkRobotHealth
     *
     * @param product
     * @param totalBattery
     * @return
     */
    public boolean checkRobotHealth(Product product, Integer totalBattery) {
        Notification notification = new Notification();
        boolean isError = false;
        if (totalBattery < 15) {
            isError = notification.display("redLight");
        } else if (product.getWeight() > 10) {
            isError = notification.display("overweight");
        } else if (product.getDistance() > 10 && calBatteryDischarge(product) < product.getDistance()) {
            isError = notification.display("failure");
        }
        return isError;
    }


}
