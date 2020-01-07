package robot;

import domainobject.Product;

public interface Robot {
    /**
     * @param productBarCode
     */
    void scanBarCode(String productBarCode);

    /**
     * @param product
     * @return
     */
    double calBatteryDischarge(Product product);

    /**
     * @param distance
     * @return
     */
    double getBatteryByDistance(double distance);

    /**
     * @param product
     * @param totalBattery
     * @return
     */
     boolean checkRobotHealth(Product product, Integer totalBattery);
}

